package com.example.controller;

import com.example.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homepage(Model model) {

        model.addAttribute("name", "Welcome to");
        model.addAttribute("course", "MVC course");

        String subject = "Collections";
        model.addAttribute("subject", subject);

        //create some random student ID

        int studentId = new Random().nextInt();
        model.addAttribute("id", studentId);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(2);
        numbers.add(6);
        numbers.add(3);
        model.addAttribute("numbers",numbers);

        Student student = new Student(1, "Mike", "Smith");
        model.addAttribute("student", student);

        return "/student/welcome";
    }
}
