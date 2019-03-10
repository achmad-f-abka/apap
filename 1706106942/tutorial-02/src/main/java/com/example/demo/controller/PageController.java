package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {
    /*@RequestMapping("/hello")
    public String index(){
        return "hello";
    }
   /* @RequestMapping("/hello2")
    public String hello2(@RequestParam(value = "name")
            String name, Model model){
        model.addAttribute("name", name);
        return "hello2";
    }*/
    @RequestMapping(value={"/hello2", "/hello2/{name}"})
    public String helloPath(@PathVariable Optional<String> name, Model model){
        if (name.isPresent()){
            model.addAttribute("name", name.get());
        }else{
            model.addAttribute("name", "Phoenix");
        }        
        return "hello2";
    }
}