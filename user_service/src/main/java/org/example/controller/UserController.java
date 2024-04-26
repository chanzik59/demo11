package org.example.controller;

import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboReference;
import org.example.entity.Book;
import org.example.entity.User;
import org.example.service.BookDubboService;
import org.example.service.FeignService;
import org.example.service.TccUserService;
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


    @Resource
    private TccUserService tccUserService;


    @RequestMapping("get/{id}")
    @ResponseBody
    public Book findUserBook(@PathVariable("id") Long id) {
        User user = userService.findUser(id);
        return bookDubboService.getById(user.getBookId());

    }

    @RequestMapping("get1/{id}")
    @ResponseBody
    public Book findUserBook1(@PathVariable("id") Long id) {
        User user = userService.findUser(id);
        return feignService.getBook(user.getBookId());

    }


    @RequestMapping("add1")
    @ResponseBody
    @GlobalTransactional(rollbackFor = Exception.class)
    public String add1(User user) {
        int i1 = userService.addUser(user);
        Book book = new Book();
        book.setName("小张1");
        book.setNum(10);
        int i = bookDubboService.addBook(book);
        return "成功";

    }

    @RequestMapping("add")
    @ResponseBody
    @GlobalTransactional(rollbackFor = Exception.class)
    public String add(User user) {
        userService.addUser(user);
        Book book = new Book();
        book.setName("小张1");
        book.setNum(10);
        book.setId(user.getBookId());
        feignService.add(book);
        return "成功";
    }


    @RequestMapping("tcc/add")
    @ResponseBody
    @GlobalTransactional(rollbackFor = Exception.class)
    public String addTcc(User user) {
        tccUserService.tryAdd(user);
        Book book = new Book();
        book.setName("小张1");
        book.setNum(10);
        book.setId(user.getBookId());
        feignService.add(book);
        return "成功";
    }


}
