package com.example.springcruddemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/home")
    public String home2() {
        return "home";
    }
//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
//    @GetMapping("/hello")
//    public String hello() {
//        return "hello";
//    }

}
