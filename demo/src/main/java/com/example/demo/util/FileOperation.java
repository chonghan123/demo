package com.example.demo.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;

public class FileOperation {

    @Test
    public static Boolean readFileByFileInputStream(String fileName) {
        Boolean flag = false;
        try {
            File file = new File(fileName);
            FileInputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int line = 0;
            StringBuffer buffer = new StringBuffer();
            while ((line = inputStream.read(bytes)) != -1) {
                String string = new String(bytes, 0, line);
                buffer.append(string);
            }
            System.out.println(buffer.toString());
            inputStream.close();
            flag = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }
        return flag;
    }

    @Test
    public static void writeFileByFileOutputStream(String fileName) {
        File file = new File(fileName);
        try {
            FileOutputStream outputStream = new FileOutputStream(file, false);
            String ccc = "34324fsdf33\nrwr";
            byte[] bytes = ccc.getBytes();
            outputStream.write(bytes);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public static void readFileByInputStreamReader(String fileName) {
        File file = new File(fileName);
        try {
            InputStreamReader inputStreamReader = null;
            inputStreamReader = new InputStreamReader(new FileInputStream(file));
            int i = 0;
            char[] chars = new char[30];
            while ((i = inputStreamReader.read(chars)) != -1) {

                System.out.println(chars);
            }
            inputStreamReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public static void writeFileByOutputStreamWriter(String fileName) {
        try {
            File file = new File(fileName);
            OutputStreamWriter outputStreamWriter = null;
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file, true));
            char[] c = "\n333".toCharArray();
            outputStreamWriter.write(c, 0, c.length);
            outputStreamWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public static void writeFileByBufferedWriter(String fileName) {
        try {
            File file = new File(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            byte[] bytes = "5555".getBytes();
            bufferedWriter.write("666", 0, 1);
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public static void writeFileByBufferedOutputStream(String fileName) {
        try {
            File file = new File(fileName);
            BufferedOutputStream bufferedWriter = new BufferedOutputStream(new FileOutputStream(file, true));
            byte[] bytes = "5555".getBytes();
            bufferedWriter.write(bytes, 0, bytes.length);
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public static void readFileByBufferedInputStream(String fileName) {
        try {
            File file = new File(fileName);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            byte[] bytes = new byte[1024];
            int length = 0;
            String string = null;
            StringBuffer buffer = new StringBuffer();
            while ((length = bufferedInputStream.read(bytes)) != -1) {
                string = new String(bytes);
                buffer.append(string);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public static void readToWrite(String fileName) {
        //只需判断文件夹是不是空，文件会自动生成
        File file = new File(fileName);
        File file1 = new File(fileName);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            File temp = new File("D:" + File.separator + "2" + File.separator + "aaa.txt");
            reader = new BufferedReader(new FileReader(file));
            writer = new BufferedWriter(new FileWriter(temp));
            char[] c = new char[10];
            int length = 0;
            while ((length = reader.read(c)) != -1) {

                writer.write(c, 0, length);
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public static void listFile(String fileName) {

        File localFile = new File(fileName);
        File[] listFiles = localFile.listFiles();
        int num = 1;
        for (File files : listFiles) {
            System.out.println(files);
            System.out.println(String.valueOf(num) + "_" + files.getName());
            num++;

        }
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}
