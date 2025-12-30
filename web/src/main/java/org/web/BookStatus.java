package org.web;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author czq
 * @date 2025/3/7 16:32
 * @Description:
 */
@Getter
public enum BookStatus {

    yes(0,"有效"),

    no(1,"有效");


    @EnumValue
    private final Integer value;

    private final String msg;

    BookStatus(Integer value, String msg) {
        this.value = value;
        this.msg = msg;
    }
}
