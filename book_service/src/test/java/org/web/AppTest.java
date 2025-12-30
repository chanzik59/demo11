package org.web;



import org.web.mapper.local.BookMapper;
import org.web.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


/**
 * Unit test for simple App.
 */

@SpringBootTest
public class AppTest {


    @Resource
    private BookMapper bookMapper;


    @Resource
    private BookService bookService;


    @Test
    public void test(){
        System.out.println(bookMapper);
//        Book by = bookMapper.getBy(1L);
//        System.out.println(by);

//        Book book = bookMapper.selectById(1L);
//
//        System.out.println(book);
//        QueryWrapper<Book> wrapper = new QueryWrapper<>();
//        wrapper.select("name").like("name","小");
//
//
//
//        Book book = new Book();
//        book.setName("小芳");
//        book.setNum(30);
//
//        bookMapper.insert(book);
//        LambdaQueryWrapper<Book> wrapper1 = new LambdaQueryWrapper<>();
//        wrapper1.in(Book::getId, Arrays.asList(1,2,4));
//
//        List<Book> books = bookMapper.selectList(wrapper1);
//        System.out.println(books);
//        UpdateWrapper<Book> updateWrapper = new UpdateWrapper<>();







    }







}
