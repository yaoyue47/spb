package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @GetMapping("/")
    public ModelAndView index(Model model) {
        return new ModelAndView("index");
    }

    @GetMapping("/register")
    public ModelAndView register(Model model) {
        return new ModelAndView("register");
    }

    @GetMapping("/home")
    public ModelAndView home(Model model, HttpServletRequest request){
        //System.out.println(request.getSession().getAttribute("status"));
        return new ModelAndView("home");
    }
}

