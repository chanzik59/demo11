package org.web;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.web.entity.Book1;
import org.web.mapper.local.BookMapper;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Unit test for simple App.
 */

@SpringBootTest
public class AppTest {


    @Resource
    private BookMapper bookMapper;



    @Test
    public void test1(){
//        List<Book1> books = bookMapper.selectByName("小芳");
//        System.out.println(books);
    }




    @Test
    public void select(){
        QueryWrapper<Book1> wrapper = new QueryWrapper<>();
        wrapper.select("id","name");
        wrapper.like("name","%芳");
        wrapper.ge("num",50);
        List<Book1> books = bookMapper.selectList(wrapper);
        System.out.println(books);


    }

    @Test
    public void update(){
        Book1 book = new Book1();
        book.setName("小猪");
        QueryWrapper<Book1> wrapper = new QueryWrapper<>();
        wrapper.eq("id",40);
        int update = bookMapper.update(book, wrapper);
    }

    @Test
    public void updateWrapper(){
        UpdateWrapper<Book1> wrapper = new UpdateWrapper<>();
        wrapper.setSql("num=num-1");
        wrapper.in("id",39,40);
        bookMapper.update(wrapper);
    }

    @Test
    public void lambda(){
        LambdaQueryWrapper<Book1> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(Book1::getId, Book1::getName);
        wrapper.like(Book1::getName,"小");
        List<Book1> books = bookMapper.selectList(wrapper);
        System.out.println(books);
    }


    @Test
    public void customUpdate(){

        LambdaQueryWrapper<Book1> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(Book1::getId,40,39);


//        int i = bookMapper.customUpdate(wrapper, 2);

//        System.out.println(i);

    }


    @Test
    public void enumSelect(){
        Page<Object> of = Page.of(2, 20);
        Book1 book = bookMapper.selectById(39);
        System.out.println(book);
    }


    @Test
    public void groupBy(){
        QueryWrapper<Book1> wrapper = new QueryWrapper<>();
        wrapper.groupBy("status");
        wrapper.select("status","sum(num)");
        List<Map<String, Object>> list = bookMapper.selectMaps(wrapper);

        System.out.println(list);
    }


    @Test
    public void updateA(){
    }









}
