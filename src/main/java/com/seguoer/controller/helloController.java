package com.seguoer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

}
