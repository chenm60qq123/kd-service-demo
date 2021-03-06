package com.kd.servicedemo.controller;

import com.kd.servicedemo.entity.UserEntity;
import com.kd.servicedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("getAll")
    @ResponseBody
    public List<UserEntity> getAll(){
        return userService.selectAll();
    }

}
