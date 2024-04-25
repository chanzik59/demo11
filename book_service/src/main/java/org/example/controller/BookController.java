package org.example.controller;

import org.example.entity.Book;
import org.example.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    public String add(@RequestBody Book book) {
        return String.valueOf(bookService.addBook(book));

    }


    @RequestMapping("get/{id}")
    @ResponseBody
    public Book add(@PathVariable("id") Long id) {
        return bookService.getBook(id);
    }

}
