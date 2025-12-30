package org.web.mapper.local;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.web.entity.Book;

/**
 * @author czq
 * @date 2024/4/23 17:18
 * @Description:
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

//    @Insert("insert into  book(id,name,num) values(#{id},#{name},#{num})")
//    int insert(Book book);


    @Select("select  * from book where id=#{id}")
    Book getBy(Long id);
}
