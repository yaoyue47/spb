package com.example.demo.controller;

import com.example.demo.pojo.Raspberry;
import com.example.demo.service.RaspberryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ConfigureController {
    @Autowired
    RaspberryServiceImpl raspberryServiceImpl;

    @PostMapping("/api/configure")
    public ModelAndView configure(Model model, @RequestParam String user, HttpServletRequest request) {
        List<Raspberry> raspberryList = raspberryServiceImpl.getRaspberryList(user);
        model.addAttribute("message",raspberryList);
        model.addAttribute("user",request.getSession().getAttribute("user"));
        return new ModelAndView("configure");
    }
}
