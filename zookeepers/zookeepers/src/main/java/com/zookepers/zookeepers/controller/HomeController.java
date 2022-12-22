package com.zookepers.zookeepers.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.zookepers.zookeepers.entity.MemberEntity;

@Controller
@RequestMapping("/")
public class HomeController {
  @GetMapping
  public String home(@SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser, Model model, HttpServletRequest request, HttpSession session) {
      model.addAttribute("loginUser", loginUser);

      return "index";
  }
  @GetMapping("/newIndex")
  public String newHome(@SessionAttribute(name = "loginUser", required = false)MemberEntity loginUser, Model model){
    model.addAttribute("loginUser", loginUser);

    return "newIndex";
  }
}