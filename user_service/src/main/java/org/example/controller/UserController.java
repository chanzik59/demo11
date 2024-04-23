package org.example.controller;

import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author czq
 * @date 2024/4/23 17:33
 * @Description:
 */
@RequestMapping("user")
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("add")
    @ResponseBody
    public String add(User user){
        return String.valueOf(userService.addUser(user));
    }

}
