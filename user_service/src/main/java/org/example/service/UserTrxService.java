package org.example.service;

import org.example.entity.UserTrx;

/**
 * @author czq
 * @date 2024/4/25 17:15
 * @Description:
 */
public interface UserTrxService {


    int addUserTrx(UserTrx userTrx);



    UserTrx find(String trxId);
}
