package com.skc.springfreemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class MarkerController {

    @GetMapping("/")
    public String hello(Model model, @RequestParam(value = "name") String name){
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/fruits")
    public String fruits(Model model, @RequestParam(value = "name") String name){
        model.addAttribute("names", Arrays.asList("apple", "grape", "mango"));
        model.addAttribute("title", "Fruits name");
        return "fruits";
    }
}
