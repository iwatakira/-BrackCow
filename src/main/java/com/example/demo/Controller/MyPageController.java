package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("Kintai/*")
@Controller
public class MyPageController {
	@GetMapping("MyPage")
	public String open(@RequestParam("UserId")String str,@RequestParam("Pass")String str2,Model model) {
		String str3 = "ユーザーマイページ";
		model.addAttribute("value3", str3);
		model.addAttribute("ID",str);
		
		return "MyPage";
	}
}