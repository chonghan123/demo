package com.example.demo.service;

import com.example.demo.mybatis.pojo.User;

public interface UserService {
    User queryUser(String name);

}
