package com.shiro.service;

import com.shiro.entity.User;

/**
 * Created by liuenxi on 2017/12/12.
 */
public interface UserService {
    User findUserByUserName(String userName);
}
