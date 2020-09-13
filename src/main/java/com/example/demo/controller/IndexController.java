package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @RequestMapping("/")
    public ModelAndView index(Model model) {
        return new ModelAndView("index");
    }

    @RequestMapping("/register")
    public ModelAndView register(Model model) {
        return new ModelAndView("register");
    }
}

