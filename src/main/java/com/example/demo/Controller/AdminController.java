package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("Kintai/*")
@Controller
public class AdminController {
  @GetMapping("Admin")
  public String open(Model model) {
    String str = "管理者画面";
    model.addAttribute("value", str);
    return "Admin";
  }
}