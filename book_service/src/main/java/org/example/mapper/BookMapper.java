package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.example.entity.Book;

/**
 * @author czq
 * @date 2024/4/23 17:18
 * @Description:
 */
public interface BookMapper {

    @Insert("insert into  user(name,num) values(#{name},#{num})")
    int insert(Book book);
}
