package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(path="Kintai/", method=RequestMethod.POST)
@Controller
public class MyPageController {
  @GetMapping("MyPage")
  public String open(@RequestParam("UserId") String str,@RequestParam("Pass")String str2,Model model) {
    String str5 = "マイページ";
    model.addAttribute("value", str5);
    model.addAttribute("ID",str);
	model.addAttribute("PASS",str2);
	  
    return "MyPage";
  }
}