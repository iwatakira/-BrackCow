package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller					
@RequestMapping("Kintai/*")
public class InOutController {

    @GetMapping("InOut")
    public String openInOutPage(Model model) {
        String str = "出退勤画面";
        model.addAttribute("value", str);
        return "InOut";
    }   
    
    /**
     * ボタンを押したら出退勤の記録をする
     * @param action
     * @param startTime
     * @param model
     * @return
     * @author 菅原 凜
     * @version 4
     */
    @PostMapping("doAction")
    public String doAction(@RequestParam String action, @RequestParam(required = false) String startTime, Model model) {
        if ("出勤".equals(action)) {
            if (startTime != null && !startTime.isEmpty()) {
                model.addAttribute("value", "既に出勤済みです");
            } else {
                model.addAttribute("value", "出勤しました");
            }
        } else if ("退勤".equals(action)) {
            if (startTime != null && !startTime.isEmpty()) {
                model.addAttribute("value", "退勤しました");
            } else {
                model.addAttribute("value", "退勤しました");
            }
        }
        return "InOut";
    }
}
