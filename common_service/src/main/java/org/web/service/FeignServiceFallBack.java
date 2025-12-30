package org.web.service;

import lombok.extern.slf4j.Slf4j;
import org.web.entity.Book;
import org.springframework.stereotype.Component;

/**
 * @author czq
 * @date 2024/4/24 15:09
 * @Description:
 */

@Slf4j
@Component
public class FeignServiceFallBack  implements FeignService{


    @Override
    public Book getBook(Long id) {
        log.warn("降级");
        return new Book();
    }

    @Override
    public String add(Book book) {
        log.warn("降级");
        return "服务降级";
    }
}
