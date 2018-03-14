package com.adaweng.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@PropertySource("classpath:application.properties")
public class HelloController {

    @Value("${app.userName}")
    private String  userName;

    @Value("${app.title}")
    private String title;

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("welcome");
        mv.addObject("name", userName);
        mv.addObject("bookTitle", title);
        return mv;
    }

}
