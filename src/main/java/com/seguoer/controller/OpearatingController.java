package com.seguoer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OpearatingController {
    @GetMapping("login")
    String show() {
        return "index_login";
    }


    @PostMapping("/verify")
    String verify(Model model, @RequestParam String email, @RequestParam String pwd) {
        System.out.println(email);
        System.out.println(pwd);
        model.addAttribute("email",email);
        model.addAttribute("pwd",pwd);
        return "user";
    }
}
