package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author hc
 * @classname JdkProxy
 * @description TODO
 * @date 2020/5/12
 */
public class JdkProxy {

    public static void main(String[] args) {
        Subject realSubject = new RealSubject();
        InvocationHandler invocationHandler = new MyInvocationHandler(realSubject);
        ClassLoader loader = realSubject.getClass().getClassLoader();
        Class[] interfaces = realSubject.getClass().getInterfaces();
        Subject subject = (Subject) Proxy.newProxyInstance(loader, interfaces, invocationHandler);
        System.out.println(subject.getClass().getName());
        String hello = subject.sayHello("hc");
        System.out.println(hello);
    }

}
