package com.zookepers.zookeepers.Entity;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name="member")
@DynamicInsert
public class Member {
    @Id
    @Column(name="Member_no")
    private String memberno;
    
	public String getMember_no() {
		return this.memberno;
	}  

	public void setMember_no(String member_no) {
		this.memberno = member_no;
	}

    @Column(name="Member_name", unique=true)
    private String member_name;
  
	public String getMember_name() {
		return this.member_name;
	}  

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}


    @Column(name="Member_ID")
    private String memberid;

    public String getMember_id(){
        return this.memberid;
    }

	public void setMember_id (String member_id) {
		this.memberid = member_id;
	}

	@Column(name="Member_password")
	public String member_password;

	public String getMember_password() {
		return this.member_password;
	}

	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}

    @Column(name="Member_nickname")
    private String member_nickname;

	public String getMember_nickname() {
		return this.member_nickname;
    }

	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}


    @Column(name="Member_grade")
    private String member_grade;

	public String getMember_grade() {
		return this.member_grade;
	}

	public void setMember_grade(String member_grade) {
		this.member_grade = member_grade;
	}


    @Column(name="Member_address")
    private String member_address;

	public String getMember_address() {
		return this.member_address;
	}

	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}


    @Column(name="Member_detailaddress")
    private String member_detailaddress;

	public String getMember_detailaddress() {
		return this.member_detailaddress;
	}

	public void setMember_detailaddress(String member_detailaddress) {
		this.member_detailaddress = member_detailaddress;
	}


    @Column(name="Member_phonenum")
    private String member_phonenum;

	public String getMember_phonenum() {
		return this.member_phonenum;
	}

	public void setMember_phonenum(String member_phonenum) {
		this.member_phonenum = member_phonenum;
	}


    @Column(name="Member_joindate")
    private LocalDateTime member_joindate;

	public LocalDateTime getMember_joindate() {
		return this.member_joindate;
	}

	public void setMember_joindate(LocalDateTime member_joindate) {
		this.member_joindate = member_joindate;
	}


    @Column(name="Member_tradecount")
    private int member_tradecount;

	public int getMember_tradecount() {
		return this.member_tradecount;
	}

	public void setMember_tradecount(int member_tradecount) {
		this.member_tradecount = member_tradecount;
	}


    @Column(name="Member_tradegrade")
    private String member_tradegrade;

	public String getMember_tradegrade() {
		return this.member_tradegrade;
	}

	public void setMember_tradegrade(String member_tradegrade) {
		this.member_tradegrade = member_tradegrade;
	}

    
    @Column(name="Member_profile")
    private String member_profile;

	public String getMember_profile() {
		return this.member_profile;
	}

	public void setMember_profile(String member_profile) {
		this.member_profile = member_profile;
	}

    
    @Column(name="Member_wrcount")
    private int member_wrcount;

	public int getMember_wrcount() {
		return this.member_wrcount;
	}

	public void setMember_wrcount(int member_wrcount) {
		this.member_wrcount = member_wrcount;
	}

    
    @Column(name="Member_cmcount")
    private int member_cmcount;

	public int getMember_cmcount() {
		return this.member_cmcount;
	}

	public void setMember_cmcount(int member_cmcount) {
		this.member_cmcount = member_cmcount;
	}

    
}
