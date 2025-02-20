package org.example.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import io.seata.core.context.RootContext;
import io.seata.rm.tcc.api.BusinessActionContext;
import org.example.entity.User;
import org.example.entity.UserTrx;
import org.example.mapper.UserMapper;
import org.example.mapper.UserTrxMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author czq
 * @date 2024/4/25 16:42
 * @Description:
 */


@Service
@SentinelResource
public class TccUserServiceImpl implements TccUserService {

    @Resource
    private UserMapper userMapper;


    @Resource
    private UserTrxMapper userTrxMapper;


    @Override
    public void tryAdd(User user) {
        String xid = RootContext.getXID();
        UserTrx userTrx = userTrxMapper.find(xid);
        if (Objects.nonNull(userTrx)) {
            //业务悬挂
            return;
        }
        int id = userMapper.insert(user);
        userTrx = new UserTrx();
        userTrx.setUserId(user.getId());
        userTrx.setTrxId(xid);
        userTrx.setStatus("0");
        userTrxMapper.addUserTrx(userTrx);
    }

    @Override
    public boolean confirm(BusinessActionContext context) {
        int delete = userTrxMapper.delete(context.getXid());
        return delete == 1;
    }

    @Override
    public boolean cancel(BusinessActionContext context) {
        UserTrx userTrx = userTrxMapper.find(context.getXid());
        //空回滚
        if (Objects.isNull(userTrx)) {
            userTrx = new UserTrx();
            userTrx.setTrxId(context.getXid());
            userTrx.setStatus("1");
            int i = userTrxMapper.addUserTrx(userTrx);
            return i==1;
        }
        if(userTrx.getStatus().equals("1")){
            return true;
        }
        int delete = userMapper.delete(userTrx.getUserId());
        return delete==1;
    }
}
