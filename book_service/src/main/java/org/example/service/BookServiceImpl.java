package org.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.Book;
import org.example.mapper.BookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.stream.Stream;

/**
 * @author czq
 * @date 2024/4/23 17:21
 * @Description:
 */
@Service
public class BookServiceImpl  extends ServiceImpl<BookMapper,Book> implements BookService {

    @Resource
    private BookMapper bookMapper;


    @Override
    public int addBook(Book book) {
        Db
        return bookMapper.insert(book);
    }

    @Override
    public Book getBook(Long id) {
        return bookMapper.getBy(id);
    }
}
