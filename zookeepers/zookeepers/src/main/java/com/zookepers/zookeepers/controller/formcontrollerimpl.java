package com.zookepers.zookeepers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class formcontrollerimpl implements formcontroller{
    
    	
	@GetMapping("/")
	public String main() {
		
		return "index";
	}
	
	@GetMapping("/login.do")
	public String login() {
		
		return "login";
	}
	
	@GetMapping("/join.do")
	public String join() {
		return "join";
	}
	
	@GetMapping("/Board.do")
	public String board() {
		return "Board";
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