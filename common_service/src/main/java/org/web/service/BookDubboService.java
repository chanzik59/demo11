package org.web.service;

import org.web.entity.Book;

/**
 * @author czq
 * @date 2024/4/25 10:58
 * @Description:
 */
public interface BookDubboService {


    Book getById(Long id);

    int addBook(Book book);
}
