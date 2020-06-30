package com.example.demo.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author hc
 * @classname MyInterceptor
 * @description TODO
 * @date 2020/5/11
 */
public class MyInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("增强");
        Object object =methodProxy.invokeSuper(o, objects);
        return object;
    }
}
