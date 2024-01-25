package com.qqq.qqq.controller;

import com.qqq.qqq.model.Users;
import com.qqq.qqq.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String getUserMessage() {
        return userService.getUserMessage();
    }

    @GetMapping("/allusers")
    public List<Users> userListesi() {
        return userService.getAllUsers();
    }
}
