package org.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.web.BookStatus;

/**
 * @author czq
 * @date 2025/3/6 16:48
 * @Description:
 */
@Data
@ToString
@TableName(value = "book",autoResultMap = true)
@ApiModel(description = "书本类")
public class Book1 {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("书名")
    private String name;

    @TableField(exist = false)
    private String address;
    @ApiModelProperty("数量")
    private Long num;

    @TableField("status")
    private BookStatus status;

    @TableField(typeHandler = JacksonTypeHandler.class,value = "info")
    private Info info;


}
