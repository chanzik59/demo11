package org.example.controller;

import org.example.entity.Book;
import org.example.entity.User;
import org.example.service.BookService;
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
@RequestMapping("book")
@Controller
public class BookController {

    @Resource
    private BookService bookService;

    @RequestMapping("add")
    @ResponseBody
    public String add(Book book){
        return String.valueOf(bookService.addBook(book));
    }

}
