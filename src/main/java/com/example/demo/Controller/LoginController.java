package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("Kintai/")
@Controller
public class LoginController {
  @GetMapping("Login")
  public String getlogin(Model model) {
    String str = "ログイン画面";
    model.addAttribute("value", str);
    
    return "Login";
  }
  
  @PostMapping("Kintai/MyPage")
  public String postLogin(@RequestParam("UserId") String str,@RequestParam("Pass")String str2,Model model) {
	  
	  model.addAttribute("ID",str);
	  model.addAttribute("PASS",str2);
	  
	  return "MyPage";
  }
}