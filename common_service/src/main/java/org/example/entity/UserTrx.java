package org.example.entity;

import lombok.Data;

/**
 * @author czq
 * @date 2024/4/25 17:12
 * @Description:
 */
@Data
public class UserTrx {

    private Long id;

    private String trxId;

    private Long userId;

    private String status;
}
