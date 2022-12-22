package com.zookepers.zookeepers.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zookepers.zookeepers.dto.JoinDto;
import com.zookepers.zookeepers.dto.LoginDto;
import com.zookepers.zookeepers.entity.MemberEntity;
import com.zookepers.zookeepers.service.member.MemberService;

@Controller
public class LoginController {
    	
    private final MemberService memberService;

    public LoginController(MemberService memberService){
        this.memberService = memberService;
    }
    
	@GetMapping("/login.do")
	public String loginpage() {
		
		return "login";
	}
	
	@GetMapping("/newLogin.do")
	public String loginPage(){
		return "newLogin";
	}

	@PostMapping("/memberLogin.do")
	public String login(LoginDto loginDto, HttpServletRequest request, RedirectAttributes rttr, Model model){

		HttpSession session = request.getSession();
		MemberEntity loginUser = memberService.login(loginDto);
		
		String failString = "아이디 혹은 비밀번호가 잘못되었습니다.";
		
		if(loginUser == null){
			System.out.println("로그인 실패야.");
			rttr.addFlashAttribute("loginFail", failString);
			return "redirect:/newLogin.do";
		}
		
		session.setAttribute("loginUser", loginUser);
		session.setAttribute("memNo", loginUser.getMemberNo());
		
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
	public String create(JoinDto joinDto){
		memberService.join(joinDto);
		return "index";
	}
}