package com.example.demo.controller;

import com.example.demo.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @PostMapping("/api/login")
    public String login(
            @RequestParam(value = "user") String user,
            @RequestParam(value = "pwd") String pwd,
            @RequestParam(value = "check") String check,
            HttpServletRequest request
            ){
        request.getSession().setAttribute("status","true");
        request.getSession().setAttribute("user",user);
        if (check.equals("on")){
            request.getSession().setMaxInactiveInterval(30*60);
        }else {
            request.getSession().setMaxInactiveInterval(0);
        }
        //System.out.println(request.getSession().getMaxInactiveInterval());
        return "redirect:/home";
    }

}
