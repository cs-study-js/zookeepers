package com.zookeepers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String main() {
		
		return "index";
	}
	
	@GetMapping("/login.html")
	public String login() {
		
		return "login";
	}
	
	@GetMapping("/join.html")
	public String join() {
		return "join";
	}
	
	@GetMapping("/Board.html")
	public String board() {
		return "Board";
	}
	
	@GetMapping("/Board_detail.html")
	public String board_detail() {
		return "Board_detail";
	}
	
	@GetMapping("/TBoard.html")
	public String tboard() {
		return "TBoard";
	}
	
	@GetMapping("/TBoard_detail.html")
	public String tboard_detail() {
		return "TBoard_detail";
	}
	
	@GetMapping("/Mypage.html")
	public String mypage() {
		return "mypage";
	}
}
