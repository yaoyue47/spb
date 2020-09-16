package com.example.demo.controller;

import com.example.demo.utiliy.Captcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CaptchaController {
    @GetMapping("/api/captcha")
    public void getcaptcha(HttpServletRequest request, HttpServletResponse response){
        //设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        //设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        Captcha captcha = new Captcha();
        captcha.getRandCode(request, response);
        System.out.println(request.getSession().getAttribute("CAPTCHA"));
    }


}
