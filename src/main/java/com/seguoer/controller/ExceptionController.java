package com.seguoer.controller;


import com.seguoer.mistake.UserNotExistException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



import java.util.HashMap;
import java.util.Map;

//@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(UserNotExistException.class)
    String arithmeticException(UserNotExistException a, Model model) {
        Map<String, Object> map = new HashMap<>();
        //定义错误码，否则默认为200
        model.addAttribute("javax.servlet.error.status_code", 401);
        map.put("code", "user.notexist");
        map.put("message", "用户出错");
        //将自定义map放入Attribute中
        model.addAttribute("ext", map);
        //重定向到error页面
        return "forward:error";
    }
}
