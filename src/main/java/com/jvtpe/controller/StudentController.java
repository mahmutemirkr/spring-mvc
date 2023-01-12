package com.jvtpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/students")
public class StudentController {

    @GetMapping("/hi")
    public ModelAndView sayHi(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","Hello");
        modelAndView.addObject("messagebody","This app student project");
        modelAndView.setViewName("hi");
        return modelAndView;
    }
}
