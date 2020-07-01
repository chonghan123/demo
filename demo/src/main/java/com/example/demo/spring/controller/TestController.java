package com.example.demo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.mybatis.pojo.User;
import com.example.demo.redis.RedisUtil;
import com.example.demo.service.UserService;

/**
 * @author hc
 * @classname TestController
 * @description TODO
 * @date 2020/5/13
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    public UserService userService;

    @Autowired
    RedisUtil redisUtil;

    @RequestMapping("/query")
    @ResponseBody
    public User query(String name) {
        User user = userService.queryUser(name);
        return user;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {

        redisUtil.set("name", "doudou");
        String string = redisUtil.get("name");
        return string;
    }
}
