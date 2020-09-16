package com.example.demo.controller;

import com.example.demo.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class LoginAjaxController {
    @Autowired
    LoginServiceImpl loginServiceImpl;

    @RequestMapping("/api/login_ajax")
    public int login(@RequestBody Map<String,String> data, HttpServletRequest request){
        String captcha = data.get("captcha");
        String user = data.get("user");
        String pwd = data.get("pwd");
        if(!loginServiceImpl.checkCaptcha(captcha,request)){
            return 2;
        }
        if (!loginServiceImpl.checkPassword(user,pwd)){
            return 0;
        }
        return 1;
    }

}
