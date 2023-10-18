package com.seguoer.controller;

import com.seguoer.config.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {
    @Autowired
    MyProperties myProperties;
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/myProperties")
    String myProperties() {
        System.out.println(myProperties.getName());
        return myProperties.getName();
    }

}
