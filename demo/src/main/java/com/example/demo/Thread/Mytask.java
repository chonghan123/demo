package com.example.demo.Thread;

/**
 * @author hc
 * @classname Mytask
 * @description TODO
 * @date 2020/4/23
 */
public class Mytask implements Runnable {

    @Override
    public void run() {
        System.out.println("111");
    }


    public static void main(String[] args) {
        Thread t = new Thread(new Mytask());
        t.start();
    }
}
