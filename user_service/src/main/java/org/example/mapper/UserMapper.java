package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.example.entity.User;

/**
 * @author czq
 * @date 2024/4/23 17:18
 * @Description:
 */
public interface UserMapper {

    @Insert("insert into  user(name,age) values(#{name},#{age})")
    int insert(User user);


    @Select("select * from user where id=#{id}")
    User  get(Long id);
}
