package org.example.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.entity.Book;
import org.example.mapper.BookMapper;
import org.springframework.stereotype.Service;

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
}



