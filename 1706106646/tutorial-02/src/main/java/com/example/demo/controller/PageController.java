package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {
    @RequestMapping("/hello")
    public String index() {
        return "hello";
    }

    @RequestMapping("/hello2")
    public String hello2(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello2";
    }
    

}