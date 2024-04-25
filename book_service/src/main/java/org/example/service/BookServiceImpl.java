package org.example.service;

import org.example.entity.Book;
import org.example.mapper.BookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author czq
 * @date 2024/4/23 17:21
 * @Description:
 */
@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;


    @Override
    public int addBook(Book book) {
        bookMapper.insert(book);

        throw new RuntimeException("模拟异常");
    }

    @Override
    public Book getBook(Long id) {
        return bookMapper.getBy(id);
    }
}
