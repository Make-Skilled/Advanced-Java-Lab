package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @RequestMapping("/welcome")
    public String display(@RequestParam("name") String name, Model model) {
        model.addAttribute("msg", "Hello, " + name + "! Welcome to Spring MVC.");
        return "welcome";
    }
}
