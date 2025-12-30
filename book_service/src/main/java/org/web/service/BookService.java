package org.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.web.entity.Book;


/**
 * @author czq
 * @date 2024/4/23 17:21
 * @Description:
 */
public interface  BookService extends IService<Book> {

    int addBook(Book book);


    Book getBook(Long id);
}
