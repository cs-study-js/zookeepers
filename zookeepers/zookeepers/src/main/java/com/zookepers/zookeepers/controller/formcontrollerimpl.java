package com.zookepers.zookeepers.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.zookepers.zookeepers.domain.Member;
import com.zookepers.zookeepers.service.MemberService;

@Controller
public class formcontrollerimpl implements formcontroller{
    private final MemberService memberService;
	
	@Autowired
	public formcontrollerimpl(MemberService memberService) {
        this.memberService = memberService;
    }



    	
	@GetMapping("/")
	public String main() {
		
		return "index";
	}
	
	@GetMapping("/login.do")
	public String loginpage() {
		
		return "login";
	}
	
	@PostMapping("/member_login.do")
	public String login(MemberForm form){
		Member member = new Member();
		member.setMember_id(form.getMember_id());
		member.setMember_password(form.getMember_password());

		Member loginResult = memberService.login(member);

		return "index";
	}

	@GetMapping("/join.do")
	public String join() {
		return "join";
	}
	
	@PostMapping("/member_join.do")
	public String create(MemberForm form){
		Member member = new Member();
		member.setMember_no(form.getMember_id());
		member.setMember_id(form.getMember_id());
		member.setMember_password(form.getMember_password());
		member.setMember_name(form.getMember_name());
		member.setMember_nickname(form.getMember_nickname());
		member.setMember_phonenum(form.getMember_phonenum());
		member.setMember_address(form.getDummy_address());
		member.setMember_detailaddress(form.getMember_detailaddress());
		member.setMember_joindate(LocalDateTime.now());
		memberService.join(member);
		return "index";
	}

	@GetMapping("/Board.do")
	public String board() {
		return "Board";
	}
	
	@GetMapping("/Board_write.do")
	public String board_write(){
		return "Board_write";
	}

	@GetMapping("/Board_detail.do")
	public String board_detail() {
		return "Board_detail";
	}
	
	@GetMapping("/TBoard.do")
	public String tboard() {
		return "TBoard";
	}
	
	@GetMapping("/TBoard_detail.do")
	public String tboard_detail() {
		return "TBoard_detail";
	}
	
	@GetMapping("/Mypage.do")
	public String mypage() {
		return "mypage";
	}
}