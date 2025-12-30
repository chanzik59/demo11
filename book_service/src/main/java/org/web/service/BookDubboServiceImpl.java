package org.web.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.web.entity.Book;
import org.web.mapper.local.BookMapper;

import javax.annotation.Resource;

/**
 * @author czq
 * @date 2024/4/23 17:21
 * @Description:
 */
@DubboService
public class BookDubboServiceImpl implements BookDubboService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public Book getById(Long id) {
        return bookMapper.getBy(id);
    }

    @Override
    public int addBook(Book book) {
       return  bookMapper.insert(book);
    }
}



