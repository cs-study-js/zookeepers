package com.zookeepers.zookeepers.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zookeepers.zookeepers.dto.member.JoinRequestDto;
import com.zookeepers.zookeepers.dto.member.LoginRequestDto;
import com.zookeepers.zookeepers.entity.MemberEntity;
import com.zookeepers.zookeepers.service.member.MemberService;

@Controller
public class LoginController {
    	
    private final MemberService memberService;

    public LoginController(MemberService memberService){
        this.memberService = memberService;
    }
    
	@GetMapping("/login.do")
	public String login() {
		
		return "login";
	}

	@PostMapping("/memberLogin.do")
	public String loginDo(LoginRequestDto loginDto, HttpServletRequest request, RedirectAttributes rttr, Model model){
		HttpSession session = request.getSession();	
		MemberEntity loginUser = memberService.login(loginDto);
		
		if(loginUser == null){
			
			return "redirect:/login.do";
		}
		
		session.setAttribute("loginUser", loginUser);
		
		return "redirect:/";
	}

	@GetMapping("/logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();

		session.invalidate();

		return "redirect:/";
	}

	@GetMapping("/join.do")
	public String join() {
		return "join";
	}

	@PostMapping("/memberJoin.do")
	public String joinDo(JoinRequestDto joinDto){
		memberService.join(joinDto);             //회원가입 Service 호출
		return "redirect:/";
	}

	@GetMapping("/mypage.do")
	public String mypage(@SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser, Model model){
		model.addAttribute("loginUser", loginUser);

		if(loginUser != null){
			return "mypage";          //로그인 되어있을경우 myPage 이동
		}

		else{
			return "login";			// 로그인 되어있지 않을경우 로그인창 이동
		}

	}
}