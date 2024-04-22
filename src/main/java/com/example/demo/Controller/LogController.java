package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("Kintai/*")
@Controller
public class LogController {
  @GetMapping("Log")
  public String open(Model model) {
    String str = "出退勤ログ画面";
    model.addAttribute("value", str);
    return "Log";
  }
}