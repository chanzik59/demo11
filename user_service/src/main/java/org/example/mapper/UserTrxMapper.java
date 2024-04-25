package org.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.example.entity.UserTrx;

/**
 * @author czq
 * @date 2024/4/25 17:12
 * @Description:
 */
public interface UserTrxMapper {


    @Insert("insert into userTrx(trxId,userId,status) values(#{trxId},#{userId},#{status})")
    int addUserTrx(UserTrx userTrx);


    @Select("select * from userTrx where trxId=#{trxId}")
    UserTrx find(String trxId);


    @Delete("delete  from userTrx where trxId=#{trxId}")
    int delete(String trxId);



}
