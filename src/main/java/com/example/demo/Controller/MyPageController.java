package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.database.EmployeeData;
import com.example.demo.database.EmployeeRepository;

@RequestMapping("Kintai/*")
@Controller
public class MyPageController {
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("MyPage")
	public String openMyPage(@RequestParam("UserId")int str,@RequestParam("Pass")String str2,Model model) {
		String title = "ユーザーマイページ";
		String Name = "ユーザーネーム_初期値";
		
		EmployeeData em = empRepo.getFromID(str);
		Name = em.getName();
		
		model.addAttribute("Title", title);
		model.addAttribute("Name",Name);
		model.addAttribute("ID",str);
		
		return "MyPage";
	}
	
	@PostMapping("check")
	public String postInOut(@RequestParam("UserId")int str,@RequestParam("Pass")String str2, Model model) {
		
		model.addAttribute("UserId", str);
				
		return "InOut";
	}
}
