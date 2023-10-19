package com.seguoer.controller;

import com.seguoer.config.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
    @Autowired
    MyProperties myProperties;
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
    @RequestMapping("/show")
    String show(Model model){
        model.addAttribute("hello","hello world");
        return "demo1";
    }
    @RequestMapping("/myProperties")
    @ResponseBody
    String myProperties() {
        System.out.println(myProperties.getName());
        return myProperties.getName();
    }


}
