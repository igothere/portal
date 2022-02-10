package com.hamonize.portal.subscribe;


import javax.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.validation.constraints.Size;
import org.hibernate.annotations.Comment;

@Getter
@Setter
@Entity
@SequenceGenerator(
            name="TBL_SUBSCRIBE_INFO_SEQ_GEN",
            sequenceName="SUBSCRIBE_INFO_SEQ",
            initialValue=1, //시작값
            allocationSize=1                                
            )
@Table(name="tbl_subscribe_info")
public class Subscribe {
    @Id
    @Size(max=50)
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE, 
            generator="TBL_SUBSCRIBE_INFO_SEQ_GEN"     
            )
    @Comment("시퀀스 번호")
    private int seq;

    @Comment("도메인 정보")
    private String domain;

    @Comment("유저 아이디")
    private String userid;

    @Comment("pg사 정보")
    private String pg;

    @Column(name = "item_no")
    @Comment("구매한 아이템 번호")
    private String itemno;

    @Comment("결제 수단 종류 > CR: 신용(체크)카드, BA: 계좌이체")
    private String paytype;

    @Comment("결제 계좌번호")
    @Column(name = "bank_account")
    private int bankaccount;

    @Comment("사용자 이름")
    private String name;

    @Comment("카드번호")
    private String cardnum;
    
    @Comment("cvc 번호")
    private String cvc;
    
    @Comment("카드 만료일")
    private String expdate;
    
    @Column(name = "insert_dt")
    @Comment("결제 일시")
    private Date insertdt;

    @Column(name = "update_dt")
    @Comment("결제정보 업데이트 일시")
    private Date updatedt;

}
