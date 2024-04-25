package org.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.example.entity.User;

/**
 * @author czq
 * @date 2024/4/23 17:18
 * @Description:
 */
public interface UserMapper {

    @Insert("insert into  user(name,age,bookId) values(#{name},#{age},#{bookId})")
    @SelectKey(statement = "select last_insert_id() from dual", before = false, resultType = Long.class, keyColumn = "id", keyProperty = "id")
    int insert(User user);


    @Select("select * from user where id=#{id}")
    User get(Long id);


    @Delete("delete  from user where id=#{id}")
    int delete(Long id);
}
