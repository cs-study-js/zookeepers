package com.zookepers.zookeepers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.zookepers.zookeepers.dto.BoardSearchDto;
import com.zookepers.zookeepers.entity.MemberEntity;

@Controller
public class TradeBoardController {
    
    
	@GetMapping("/tboard.do")
	public String tradeboard(@SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser, Model model) {
		model.addAttribute("loginUser", loginUser);

		return "tboard";
	}
	
	@GetMapping("/tboardDetail.do")
	public String tradeboardDetail(@SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser, Model model) {
		model.addAttribute("loginUser", loginUser);
		return "tboardDetail";
	}
	
	@PostMapping("/tboardSearch.do")
	public String tradeboardSearch(BoardSearchDto form){
		return "tboard";
	}
}
