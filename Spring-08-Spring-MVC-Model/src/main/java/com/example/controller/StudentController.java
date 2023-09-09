package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homepage(Model model){

    model.addAttribute("name","Welcome to");
    model.addAttribute("course","MVC course");



        return "/student/welcome";
    }
}
