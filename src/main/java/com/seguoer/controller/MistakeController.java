package com.seguoer.controller;


import com.seguoer.mistake.UserNotExistException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MistakeController {
    @RequestMapping("/noUser")
    public  String hello(@RequestParam("user") String user)
    {
        if (user.equals("aaa"))
        {
            throw  new UserNotExistException();
        }
        return "noUser";
    }
}
