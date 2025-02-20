package org.example;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.example.entity.Book;
import org.example.mapper.BookMapper;
import org.example.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


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
