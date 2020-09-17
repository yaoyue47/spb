package com.example.demo.controller;

import com.example.demo.service.ClickServiceImpl;
import com.example.demo.service.RaspberryService;
import com.example.demo.service.RaspberryServiceImpl;
import com.example.demo.vo.HomeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    ClickServiceImpl clickServiceImpl;
    @Autowired
    RaspberryServiceImpl raspberryServiceImpl;

    @GetMapping("/")
    public ModelAndView index(Model model) {
        return new ModelAndView("index");
    }

    @GetMapping("/register")
    public ModelAndView register(Model model) {
        return new ModelAndView("register");
    }

    @GetMapping("/home")
    public ModelAndView home(Model model,HttpServletRequest request){
        HomeMessage homeMessage = new HomeMessage();

        homeMessage.setUser((String) request.getSession().getAttribute("user"));

        clickServiceImpl.increase();
        int click = clickServiceImpl.getClick();
        homeMessage.setClickTime(click);

        List<String> list = raspberryServiceImpl.getList((String) request.getSession().getAttribute("user"));
        homeMessage.setRaspberry(list);

        homeMessage.setRaspberryNow(list.get(0));

        model.addAttribute("message",homeMessage);
        return new ModelAndView("home");
    }
}

