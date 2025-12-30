package org.web.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.web.entity.Book1;
import org.web.mapper.local.BookMapper;

/**
 * @author czq
 * @date 2025/3/7 10:50
 * @Description:
 */
//@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book1> implements BookService {
}
