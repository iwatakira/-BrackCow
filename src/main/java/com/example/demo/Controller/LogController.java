package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.database.EmployeeData;
import com.example.demo.database.EmployeeRepository;

@RequestMapping("Kintai/*")
@Controller
public class LogController {

	@Autowired
	private EmployeeRepository emplRepo;
	
	@GetMapping("Log")
	public String open(Model model) {
				
		String str = "従業員管理画面";
		model.addAttribute("value", str);
		
		List<EmployeeData> dataList  = emplRepo.getAllData();

		int num = emplRepo.count();	
								
		model.addAttribute("users", dataList);
		
		return "Log";
	}
	
	
}


