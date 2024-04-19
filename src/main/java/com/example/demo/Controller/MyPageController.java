package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(path="Kintai/*", method=RequestMethod.POST)
@Controller
public class MyPageController {
  @GetMapping("MyPage")
  public String open(Model model) {
    String str = "マイページ";
    model.addAttribute("value", str);
    return "MyPage";
  }
}