package org.example.service;

import org.example.entity.UserTrx;
import org.example.mapper.UserTrxMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author czq
 * @date 2024/4/25 17:16
 * @Description:
 */
@Service
public class UserTrxServiceImpl implements UserTrxService{

    @Resource
    private UserTrxMapper userTrxMapper;
    @Override
    public int addUserTrx(UserTrx userTrx) {
        return userTrxMapper.addUserTrx(userTrx);
    }

    @Override
    public UserTrx find(String trxId) {
        return userTrxMapper.find(trxId);
    }
}
