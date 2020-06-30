package com.example.demo.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author hc
 * @classname MyServer
 * @description TODO
 * @date 2020/4/21
 */
public class MyServer {


//    public static void main(String[] args) {
//
//        try (ServerSocket s= new ServerSocket(8189)) {
//
//            try (Socket incoming = s.accept()) {
//
//                InputStream inputStream = incoming.getInputStream();
//                OutputStream outputStream = incoming.getOutputStream();
//
//                try (Scanner in = new Scanner(inputStream)) {
//
//                    PrintWriter out = new PrintWriter(outputStream,true);
//                    out.print("Hello! Enter bye to exit");
//                    boolean done = false;
//                    while (!done && in.hasNextLine()) {
//
//                        String line = in.nextLine();
//                        out.print("echo"+line);
//                        if (line.trim().equals("bye")) {
//                            done = true;
//                        }
//
//
//                    }
//
//                }
//
//
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

}
