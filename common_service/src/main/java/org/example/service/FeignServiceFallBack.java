package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
