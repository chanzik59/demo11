package org.web.service;

import org.web.entity.User;

/**
 * @author czq
 * @date 2024/4/23 17:21
 * @Description:
 */
public interface UserService {

    int addUser(User user);


    User  findUser(Long id);
}
