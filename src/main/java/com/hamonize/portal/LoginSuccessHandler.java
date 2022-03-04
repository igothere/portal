package com.hamonize.portal;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hamonize.portal.file.FileRepository;
import com.hamonize.portal.file.FileVO;
import com.hamonize.portal.login.LoginController;
import com.hamonize.portal.subscribe.Subscribe;
import com.hamonize.portal.subscribe.SubscribeRepostory;
import com.hamonize.portal.user.SecurityUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.PortResolverImpl;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class LoginSuccessHandler implements AuthenticationSuccessHandler{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
  
    private RequestCache reqCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStratgy = new DefaultRedirectStrategy();
    private RequestCache requestCache = new HttpSessionRequestCache();
		
    @Autowired
    SubscribeRepostory sr;

    @Autowired
    FileRepository fr;
  
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        logger.info("ddddd > {}",authentication.getPrincipal().getClass());

        SecurityUser user = (SecurityUser) authentication.getPrincipal();
        HttpSession httpSession = request.getSession(true);
        logger.info("onAuthenticationSuccess user domain : {}",user.getDomain());
        logger.info("onAuthenticationSuccess user username : {}",user.getUsername());
        
        httpSession.setAttribute("userSession", user);
        
        FileVO file = fr.findByUseridAndKeytype(user.getUserid(), "img");
        try {
            if( !"".equals(file.getFilepath().toString()) ){
                httpSession.setAttribute("profileImg", file.getFilepath());
            }
                
        } catch (NullPointerException e) {
            logger.error("profileimg 없음 ");
        }
        
        
        logger.info("session id: {}", httpSession.getId());
        logger.info("getUserid : {}", user.getUserid());
        
        
        
        if(user.getUserid() != null){
            response.sendRedirect("/"); 
            // if((String) httpSession.getAttribute("url") != null ){
            //     // response.sendRedirect((String) httpSession.getAttribute("url")); 
                
            //     response.sendRedirect("/");

            // }else{
            //     response.sendRedirect("http://localhost:8081/main");
            // }
        } else{
            response.sendRedirect("/login");
        }

        clearAuthenticationAttributes(request);
        
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session == null) return;
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }


    
}
