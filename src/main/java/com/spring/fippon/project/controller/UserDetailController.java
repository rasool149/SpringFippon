package com.spring.fippon.project.controller;

import com.spring.fippon.project.entity.UserDetail;
import com.spring.fippon.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserDetailController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public UserDetail addUser(@RequestBody UserDetail userDetail) {
        return userService.saveUser(userDetail);
    }

    @GetMapping("/all")
    public List<UserDetail> getAllUsers() {
        return userService.getAllUsers();
    }

    // Additional methods as needed
}
