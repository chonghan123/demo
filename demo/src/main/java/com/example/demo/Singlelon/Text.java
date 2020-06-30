package com.example.demo.Singlelon;

/**
 * @author hc
 * @classname Text
 * @description TODO
 * @date 2020/4/23
 */
public class Text {

    private static Text text = null;

    private static class SingletonFactory{
        private static Text instance = new Text();
    }
    public static Text getInstance(){
        return SingletonFactory.instance;
    }

}
