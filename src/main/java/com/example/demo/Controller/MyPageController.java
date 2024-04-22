package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("Kintai/*")
@Controller
public class MyPageController {
	@GetMapping("MyPage")
	public String open(Model model) {
		String str1 = "ユーザーマイページ";
		String str2 = "****";
		model.addAttribute("value1", str1);
		model.addAttribute("value2", str2);
		return "MyPage";
	}
}