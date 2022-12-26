package com.zookepers.zookeepers.entity;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name="member")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class MemberEntity {
    @Id
    @Column(name="Member_no")
    private String memberNo;
    
    @Column(name="Member_name", unique=true)
    private String memberName;

    @Column(name="Member_ID")
    private String memberId;

	@Column(name="Member_password")
	public String memberPassword;

    @Column(name="Member_nickname")
    private String memberNickname;

    @Column(name="Member_grade")
    private String memberGrade;

    @Column(name="Member_address")
    private String memberAddress;

    @Column(name="Member_detailaddress")
    private String memberDetailaddress;

    @Column(name="Member_phonenum")
    private String memberPhonenum;

    @Column(name="Member_joindate")
    private LocalDateTime memberJoindate;

    @Column(name="Member_tradecount")
    private int memberTradecount;

    @Column(name="Member_tradegrade")
    private String memberTradegrade;

    @Column(name="Member_profile")
    private String memberProfile;

    @Column(name="Member_wrcount")
    private int memberWrcount;
    
    @Column(name="Member_cmcount")
    private int memberCmcount;
}
