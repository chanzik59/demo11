package org.example.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.entity.Book;
import org.example.entity.User;
import org.example.service.BookDubboService;
import org.example.service.FeignService;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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


    @Resource
    private FeignService feignService;



    @DubboReference
    private BookDubboService bookDubboService;

    @RequestMapping("add")
    @ResponseBody
    public String add(User user){
        return String.valueOf(userService.addUser(user));
    }


    @RequestMapping("get/{id}")
    @ResponseBody
    public Book findUserBook(@PathVariable("id") Long id){
        User user = userService.findUser(id);
//        return feignService.getBook(user.getBookId());
        return  bookDubboService.getById(user.getBookId());

    }

    @RequestMapping("get1/{id}")
    @ResponseBody
    public Book findUserBook1(@PathVariable("id") Long id){
        User user = userService.findUser(id);
        return feignService.getBook(user.getBookId());

    }

}
