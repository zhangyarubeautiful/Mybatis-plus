package com.xihua.controller;

import com.xihua.entity.User;
import com.xihua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type User controller.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * List user list.
     *
     * @return the list
     */
    @GetMapping("/user")
    public List<User> listUser(){
        return userService.getUserList();
    }

}
