package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(@RequestParam("name") String name, Model model) {
        model.addAttribute("message", "Hello, " + name + "!");
        return "hello";
    }
}
