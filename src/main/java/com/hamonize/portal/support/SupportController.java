package com.hamonize.portal.support;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.hamonize.portal.file.FileRepository;
import com.hamonize.portal.file.FileVO;
import com.hamonize.portal.user.SecurityUser;
import com.hamonize.portal.user.User;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/support")
public class SupportController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FileRepository fr;

    @Autowired
    SupportRepository sr;

    @RequestMapping("/list")
    public String supportList(HttpSession session, Support vo, Model model) {
        logger.info("\n\n\n <<< list >> ");
        SecurityUser user = (SecurityUser) session.getAttribute("userSession");

        List<Support> list = sr.findAll();
        List<Support> slist = new ArrayList<>();

        for (Support support : list) {

            logger.info("신청일 : {}", support.getInsdate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
            support.setViewDate(support.getInsdate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
            slist.add(support);
        } 

    
        model.addAttribute("list", slist);
        return "/support/list";
	}

    @GetMapping("/apply")
    public String supportCreate(Support vo, HttpSession session, Model model) {
        
        logger.info("\n\n\n <<< 1:1문의 작성 >> ");
        SecurityUser user = (SecurityUser) session.getAttribute("userSession");
      
        return "/support/apply";
	}

    @GetMapping("/edit")
    public String supportEdit(Support vo, HttpSession session, Model model) {
        logger.info("seq : ",vo.getSeq());

        logger.info("\n\n\n <<< 1:1문의 상세 수정 >> ");
        SecurityUser user = (SecurityUser) session.getAttribute("userSession");
        logger.info("seq >> {}", vo.getSeq());
        Support edit = sr.findBySeq(vo.getSeq());
            
        model.addAttribute("edit", edit);
    
        return "/support/apply";
	}

    @GetMapping("/view")
    public String supportView(Support vo, HttpSession session, Model model) {
        logger.info("seq : ",vo.getSeq());

        logger.info("\n\n\n <<< 1:1문의 상세 보기>> ");
        SecurityUser user = (SecurityUser) session.getAttribute("userSession");
            logger.info("seq >> {}", vo.getSeq());
            Support edit = sr.findBySeq(vo.getSeq());
                
            model.addAttribute("edit", edit);
    
        return "/support/view";
	}

    @RequestMapping("/save")
    @ResponseBody
    public Long save(HttpSession session, Support vo ) {
        logger.info("\n\n\n <<< support 저장 >> ");
        Support ret = new Support();
        Long retval = (long) 0;
        SecurityUser user = (SecurityUser) session.getAttribute("userSession");
        
        vo.setUserid(user.getUserid());
        logger.info("getSeq >> {}",vo.getSeq());
        
        if(vo.getSeq() != null ){
            vo.setUpdtdate(LocalDateTime.now());
            int aa = sr.update(vo);
            retval = (long) aa;

            logger.info("update >>>{} ", retval);
            
        } else{
            logger.info("save >>> ");
            vo.setStatus("0");
            vo.setInsdate(LocalDateTime.now());
            ret = sr.save(vo);
            retval = ret.getSeq();
        }
        
      
        return retval;
    }

    @RequestMapping("/delete")
    public String delete(HttpSession session, Support vo) throws Exception{
        logger.info("seq : ",vo.getSeq());

        logger.info("\n\n\n <<< doamin 결제 페이지 >> ");
        SecurityUser user = (SecurityUser) session.getAttribute("userSession");
        sr.delete(vo);

        return "redirect:/support/list";
	}

    @RequestMapping("/getImageUrl")
    public void imgView(@RequestParam("seq") Integer seq, HttpSession session, HttpServletResponse response, Model model)  throws IOException {
        
       SecurityUser user = (SecurityUser) session.getAttribute("userSession");
       logger.info("file path : {}", seq);

       FileVO file = fr.findByUseridAndSeq(user.getUserid(), seq );
        
        logger.info("file path : {}", file.getFilepath());
        
        StringBuilder sb = new StringBuilder("file:"+ file.getFilepath());
        URL fileUrl = new URL(sb.toString());
        logger.info("fileUrl >> {}",fileUrl);

        IOUtils.copy(fileUrl.openStream(), response.getOutputStream());
	}

}
