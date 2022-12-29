package com.zookeepers.zookeepers.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.zookeepers.zookeepers.dto.MessageResponseDto;
import com.zookeepers.zookeepers.entity.MemberEntity;

@Controller
@RequestMapping("/")
public class HomeController {
  @GetMapping
  public String home(@SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser, Model model, HttpServletRequest request, HttpSession session) {
      model.addAttribute("loginUser", loginUser);

      return "index";
  }
  
  private String showMessageAndRedirect(final MessageResponseDto params, Model model) {
    model.addAttribute("params", params);                                 //alert 메세지. 추가예정
    return "messageRedirect";
}
}