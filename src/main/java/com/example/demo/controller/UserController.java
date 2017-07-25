package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.IUserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 胡包明 on 2017/7/20.
 */
@RestController
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {

        this.userService = userService;

    }
    @GetMapping("/api/users/search/by/department")
    public List<User> getUsersByDepartmentId(@RequestParam Long departmentId){
        return userService.selectUsersByDepartmentId(departmentId);
    }


}
