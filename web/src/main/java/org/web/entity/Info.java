package org.web.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author czq
 * @date 2025/3/7 16:54
 * @Description:
 */
@Data
public class Info {

    private String name;

    private BigDecimal price;

}
