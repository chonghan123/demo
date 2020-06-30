package com.example.demo.proxy;

/**
 * @author hc
 * @classname RealSubject
 * @description TODO
 * @date 2020/5/12
 */
public class RealSubject implements Subject {

    @Override
    public String sayHello(String name) {
        return "hello"+name;
    }

    @Override
    public String sayGoodBye(String name) {
        return "goodBye"+name;
    }
}
