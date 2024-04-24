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
public class AdminController {
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("Admin")
	public String open(@RequestParam("UserId")int str,Model model) {
		String title = "管理者ページ";
		String Name = "管理者ネーム_初期値";
		
		EmployeeData em = empRepo.getFromID(str);
		Name = em.getName();
		
		model.addAttribute("Title", title);
		model.addAttribute("Name",Name);
		model.addAttribute("ID",str);
		
		return "Admin";
	}
	
	@PostMapping("Log")
	public String postInOut(@RequestParam("UserId")int str, Model model) {
		
		model.addAttribute("UserId", str);
				
		return "Log";
	}

}
