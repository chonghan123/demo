package com.example.demo.invoke;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * @author hc
 * @classname ReflectClass
 * @description TODO
 * @date 2020/5/11
 */
public class ReflectClass {

    public static void reflectClassInstance() {

        try {
            Class c = Class.forName("com.example.demo.invoke.Book");
            Object object = c.newInstance();
            Book book = (Book) object;
            book.setAuthor("hc");
            book.setName("111");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void reflectPrivateConstructor() {

        try {
            Class<?> c = Class.forName("com.example.demo.invoke.Book");
            Constructor constructor = c.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            Object object = constructor.newInstance("sfsd", "123");
            Book book = (Book) object;
            System.out.println(object.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void reflectPrivateConstructor1() {

        try {
            Class<?> c = Class.forName("com.example.demo.invoke.Book");
            Constructor constructor = c.getDeclaredConstructor();
            constructor.setAccessible(true);
            Object object = constructor.newInstance("sfsd", "123");
            Book book = (Book) object;
            System.out.println(object.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void reflectPrivateConstructor2() {

        try {
            Class<?> c = Class.forName("com.example.demo.invoke.Book");
            Constructor<?>[] constructors = c.getDeclaredConstructors();

            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                Book book = (Book) constructor.newInstance();
                System.out.println(book.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void reflectPrivateField() {

        try {
            Class<?> c = Class.forName("com.example.demo.invoke.Book");
            Object object = c.newInstance();
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {

                System.out.println(field);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void reflectPrivateMethod() {
        try {
            Class<?> c = Class.forName("com.example.demo.invoke.Book");
            Constructor<?> constructor = c.getConstructor(null);
            Object object = constructor.newInstance(null);
            Method[] methods = c.getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().equals("declaredMethod")) {
                    method.setAccessible(true);
                    String string = (String) method.invoke(object, 1);
                    System.out.println(string);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
