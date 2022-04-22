package com.grp4.houseship.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grp4.houseship.member.model.MemberService;

@Controller
//因為index.jsp被放進WEB-INF裡,不能作為起始點直接訪問
//所以進入點改成網址輸入"http://localhost:8080/HouseShip/home"這樣?還能帶"所有會員數量"的屬性過去
//但為什麼要@RequestMapping(path = "/")?攔截所有頁面?導到index頁面?


public class IndexController {

  @Autowired
  private MemberService memberService;
  //這應該就是進入點?
  @GetMapping(path = "/home")
  public String home(Model model) {
  	//帶著會員數量前往首頁
      //model.addAttribute("memberNumOfData", memberService.getDataCount());
      return "index";
  }
  
}
