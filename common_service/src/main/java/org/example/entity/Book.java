package org.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author czq
 * @date 2024/4/23 17:14
 * @Description:
 */

@Data
public class Book implements Serializable {
    private Long id;

    private String name;

    private Integer num;



}
