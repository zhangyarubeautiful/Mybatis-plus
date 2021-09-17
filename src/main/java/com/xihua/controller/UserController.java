package com.xihua.controller;

import com.xihua.entity.User;
import com.xihua.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type User controller.
 */
@Api(tags = "用户管理")
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * List user list.
     *
     * @return the list
     */
    @ApiOperation(value = "获取所有用户", notes = "获取所有用户信息")
    @GetMapping("/list")
    public List<User> listUser(){
        return userService.getUserList();
    }

    /**
     * Gets user by id *
     *
     * @param id id
     * @return the user by id
     */
    @ApiOperation(value = "根据id获取用户", notes = "根据id获取用户")
    @PostMapping("/get")
    public User getUserById(@RequestParam("id") Integer id){
        return new User();
    }

}
