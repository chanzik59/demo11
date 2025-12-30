package org.web.mapper.local;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.web.entity.Book1;


import java.util.List;


/**
 * @author czq
 * @date 2025/3/6 16:44
 * @Description:
 */

public interface BookMapper extends BaseMapper<Book1> {


//    List<Book1>  selectByName(@Param("name") String name);
//
//
//    int customUpdate(@Param(Constants.WRAPPER) Wrapper wrapper, @Param("num") int num);
}
