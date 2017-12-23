package com.shiro.service.impl;

import com.shiro.dao.UserMapper;
import com.shiro.entity.User;
import com.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liuenxi on 2017/12/12.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserByUserName(String userName) {
        return userMapper.findUserByUserName(userName);
    }
}
