package com.example.demo.Thread;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author hc
 * @classname MyThread
 * @description TODO
 * @date 2020/4/23
 */
public class MyThread extends Thread {


    @Override
    public void run() {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid.replace("-", ""));
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new MyThread());

    }

}
