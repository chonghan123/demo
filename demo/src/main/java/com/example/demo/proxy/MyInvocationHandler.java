package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author hc
 * @classname MyInvocationHandler
 * @description TODO
 * @date 2020/5/12
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object subject;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用之前");
        Object returnValue = method.invoke(subject, args);
        System.out.println("调用之后");
        return returnValue;
    }

    public MyInvocationHandler(Object subject) {
        this.subject = subject;
    }
}
