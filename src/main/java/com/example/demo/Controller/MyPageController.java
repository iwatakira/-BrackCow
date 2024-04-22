package com.example.demo.Controller;

import java.sql.Connection;
import java.sql.Statement;

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
		
		Connection conn = null;
		Statement stmt = null;
		
		String name = "ユーザーネーム_初期値";
		//String aaa = null;;
		//String bbb = null;;
		//String ccc = null;;
		
		// 仮のSQLからのデータ取得
		/*try {
			ResultSet rs = stmt.executeQuery("SELECT " + str + "from userDataBase;");
			System.out.println("Fetching result set...");
		  
			while (rs.next()) {
				name = rs.getString(1);
				//String aaa = rs.getString(1);
				//String bbb = rs.getString(1);
				//String ccc = rs.getString(1);
			  
			}
			
		    System.out.println("\n Customer number: " + name);
		    //System.out.println(" Region: " + aaa);
		    //System.out.println(" Name: " + bbb);
		    //System.out.println(" Address: " + ccc);
		    
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}*/
		
		model.addAttribute("value3", str3);
		model.addAttribute("ID",name);
		
		return "MyPage";
	}
}