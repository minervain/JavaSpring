package com.qqq.qqq.controller;


import com.qqq.qqq.service.UserService;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private   UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }
    @GetMapping("/user")
    public String getUserMessage(){
        return userService.getUserMessage();
    }
}
