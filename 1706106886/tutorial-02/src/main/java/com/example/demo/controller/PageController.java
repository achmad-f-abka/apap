package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/hello")
	public String index() {
		return "hello";
	}
	
	@RequestMapping("/hello2")
	public String hello2(@RequestParam(value="name")String name, Model model) {
		model.addAttribute("name", name);
		return "hello2";
		
	}
	
	@RequestMapping(value= {"/hello2","/hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "Phoenix");
		}
		return "hello2";
	}
	

	@RequestMapping(value = "/kalkulator", method = RequestMethod.GET)
    public String greeting(@RequestParam(value= "num1")  String num1,
                           @RequestParam(value = "num2") String num2,
                           @RequestParam(value = "operasi") String operasi,
                           Model model) {
        if (num1 != null && num2 != null && operasi != null) {
            switch (operasi) {
                case "pluss" :
                    model.addAttribute("result", Double.parseDouble(num1) + Double.parseDouble(num2));
                    break;
                case "minus" :
                    model.addAttribute("result", Double.parseDouble(num1) - Double.parseDouble(num2));
                    break;
                case "product" :
                    model.addAttribute("result", Double.parseDouble(num1) * Double.parseDouble(num2));
                    break;
                case "divide" :
                    model.addAttribute("result", Double.parseDouble(num1) / Double.parseDouble(num2));
                    break;
                default:
                    break;

            }
        }
        return "kalkulator";
    }
	
	

}
