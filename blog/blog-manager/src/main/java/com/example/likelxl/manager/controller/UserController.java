package com.example.likelxl.manager.controller;

import com.example.likelxl.manager.entity.User;
import com.example.likelxl.manager.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @
 * @Description TODO
 * @Date: 2020/5/31 10:30
 * @Create by external_ll@163.com
 **/
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;
    @RequiresAuthentication
    @GetMapping("/{id}")
    public Object test(@PathVariable("id") Long id){
        return userService.getById(id);
    }

    @PostMapping("addUser")
    public Object addUser(@Validated @RequestBody User user){
        return user.toString();
    }

}
