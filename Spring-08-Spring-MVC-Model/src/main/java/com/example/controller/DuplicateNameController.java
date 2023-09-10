package com.example.controller;

import com.example.enums.Gender;
import com.example.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/another")
public class DuplicateNameController {
    @RequestMapping("/list")
    public String mentor(Model model){

        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(new Mentor("Mike","Smith",45, Gender.MALE));
        mentorList.add(new Mentor("Tom","Hanks",65, Gender.MALE));
        mentorList.add(new Mentor("Ammy","Bryan",25, Gender.FEMALE));

        model.addAttribute("mentors",mentorList);


        Mentor mentor1 = new Mentor("Mike","Smith",45, Gender.MALE);
        model.addAttribute("mike",mentor1);
        Mentor mentor2= new Mentor("Tom","Hanks",65, Gender.MALE);
        model.addAttribute("tom",mentor2);
        Mentor mentor3 = new Mentor("Ammy","Bryan",25, Gender.FEMALE);
        model.addAttribute("ammy",mentor3);

        return "/mentor/mentor";
    }
}
