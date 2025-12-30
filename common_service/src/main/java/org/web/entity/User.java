package org.web.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author czq
 * @date 2024/4/23 17:14
 * @Description:
 */

@Data
public class User  implements Serializable {
    private Long id;

    private String name;

    private Integer age;

    private Long bookId;



}
