package org.example.service;

import org.example.config.FeignConfig;
import org.example.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author czq
 * @date 2024/4/24 15:09
 * @Description:
 */
//@FeignClient(value = "book-service", configuration = FeignConfig.class)
//@FeignClient(value = "book-service" ,fallback = FeignServiceFallBack.class)
@FeignClient(value = "book-service" )
public interface FeignService {


    @RequestMapping("/book/get/{id}")
    Book getBook(@PathVariable("id") Long id);


    @RequestMapping("/book/add")
    String add(@RequestBody Book book);


}
