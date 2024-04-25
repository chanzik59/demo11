package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.example.entity.Book;

/**
 * @author czq
 * @date 2024/4/23 17:18
 * @Description:
 */
public interface BookMapper {

    @Insert("insert into  book(name,num) values(#{name},#{num})")
    int insert(Book book);


    @Select("select  * from book where id=#{id}")
    Book getBy(Long id);
}
