package org.web.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.web.entity.User;
import org.web.mapper.local.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author czq
 * @date 2024/4/23 17:21
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @SentinelResource("findUser")
    @Override
    public User findUser(Long id) {
        return userMapper.get(id);
    }
}
