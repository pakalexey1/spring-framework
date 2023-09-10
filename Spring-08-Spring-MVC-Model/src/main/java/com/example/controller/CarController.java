package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/car")
public class CarController {

    @RequestMapping("/info") //localhost:9090/car/info?make=Honda&year=2015
    public String carinfo(@RequestParam String make, @RequestParam Integer year, Model model){

        model.addAttribute("make",make);
        model.addAttribute("year",year);
        return "/car/car-info";
    }

    @RequestMapping("/info2") //localhost:9090/car/info?make=Honda&year=2015
    public String carinfo2(@RequestParam(value = "make", required = false, defaultValue = "VAZ") String make, @RequestParam Integer year, Model model){

        model.addAttribute("make",make);
        model.addAttribute("year",year);
        return "/car/car-info";
    }
    @RequestMapping("/info/{make}/{year}") //localhost:9090/car/info/honda
    public String getCarinfo(@PathVariable String make, @PathVariable Integer year, Model model){

        model.addAttribute("make",make);
        model.addAttribute("year",year);
        return "/car/car-info";
    }
}
