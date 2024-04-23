package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.database.EmployeeData;
import com.example.demo.database.EmployeeRepository;

@RequestMapping("Kintai/*")
@Controller
public class LoginController {
	@Autowired
	EmployeeRepository emplorepo;
	
	@GetMapping("Login")
	public String open(Model model) {
		String str = "ログイン画面";
		model.addAttribute("value", str);
		return "Login";
	}

	@PostMapping("check")
	public ModelAndView postLogin(@RequestParam("UserId")int str,@RequestParam("Pass")String str2/*,Model model*/) {
		
		//model.addAttribute("ID",str);
		//model.addAttribute("PASS",str2);
		boolean checkid = emplorepo.existFromId(str);
		
		if(checkid)
		{
			EmployeeData data = emplorepo.getFromID(str);
			String pass =  data.getPassword(); 
			if(pass.equals(str2))
			{
				ModelAndView model = new ModelAndView("redirect:/Kintai/MyPage");
				model.addObject("UserId", str);
				model.addObject("Pass", str2);
				return model;
			}
		}
				
		return new ModelAndView("redirect:/Kintai/Login");
		
		
	}
}