package com.example.demo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hc
 * @classname TestController
 * @description TODO
 * @date 2020/5/13
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/test")
    public void test(String name) {

        int i = 10;
        System.out.println(name);
    }
}
