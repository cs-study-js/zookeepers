package com.zookeepers.controller;

import org.springframework.stereotype.Controller;
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
}
