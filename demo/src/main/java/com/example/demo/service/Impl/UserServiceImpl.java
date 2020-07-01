package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mybatis.mapper.UserMapper;
import com.example.demo.mybatis.pojo.User;
import com.example.demo.service.UserService;

/**
 * @author hc
 * @classname UserServiceImpl
 * @description TODO
 * @date 2020/7/1
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserMapper userMapper;

    @Override
    public User queryUser(String name) {
        return userMapper.query(name);
    }
}
