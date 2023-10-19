package com.seguoer.controller;

import com.seguoer.config.MyProperties;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
    String show(Model model, Map<String,Object> map , HttpServletRequest req){
        map.put("HELLO","HELLO WORLD");
        req.setAttribute("HLO","HLO WD");
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
