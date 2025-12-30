package org.web.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.web.entity.Book;
import org.web.entity.User;
import org.web.service.BookDubboService;
import org.web.service.FeignService;
import org.web.service.TccUserService;
import org.web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author czq
 * @date 2024/4/23 17:33
 * @Description:
 */
@Slf4j
@RequestMapping("user")
@Controller
public class UserController {

    @Resource
    private UserService userService;


    @Resource
    private FeignService feignService;


    @DubboReference
    private BookDubboService bookDubboService;


    @Resource
    private TccUserService tccUserService;


    @RequestMapping("get/{id}")
    @ResponseBody
//    @SentinelResource(value ="/user/get/{id}"  ,blockHandler = "blockHandler")
    public Book findUserBook(@PathVariable("id") Long id) {
        User user = userService.findUser(id);
        return bookDubboService.getById(user.getBookId());

    }

    public Book blockHandler(Long id, BlockException e) {
        log.error("进入流控管理", e);
        return new Book();
    }

    @RequestMapping("get1/{id}")
    @ResponseBody
    public Book findUserBook1(@PathVariable("id") Long id) {
        User user = userService.findUser(id);
        return feignService.getBook(user.getBookId());

    }


    @RequestMapping("add1")
    @ResponseBody
    @GlobalTransactional(rollbackFor = Exception.class)
    public String add1(User user) {
        int i1 = userService.addUser(user);
        Book book = new Book();
        book.setName("小张1");
        book.setNum(10);
        int i = bookDubboService.addBook(book);
        return "成功";

    }

    @RequestMapping("add")
    @ResponseBody
    @GlobalTransactional(rollbackFor = Exception.class)
    public String add(User user) {
        userService.addUser(user);
        Book book = new Book();
        book.setName("小张1");
        book.setNum(10);
        book.setId(user.getBookId());
        feignService.add(book);
        return "成功";
    }


    @RequestMapping("tcc/add")
    @ResponseBody
    @GlobalTransactional(rollbackFor = Exception.class)
    public String addTcc(User user) {
        tccUserService.tryAdd(user);
        Book book = new Book();
        book.setName("小张1");
        book.setNum(10);
        book.setId(user.getBookId());
        feignService.add(book);
        return "成功";
    }


    @RequestMapping("sentinel")
    @ResponseBody
    public String sentinel() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "成功";
    }


}
