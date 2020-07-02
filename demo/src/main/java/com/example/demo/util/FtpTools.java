package com.example.demo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 * @author hc
 * @classname FtpTools
 * @description TODO
 * @date 2020/4/20
 */
public class FtpTools {

    private String userName;

    private String password;

    private String ip;

    private int port = 21;

    private static FTPClient ftpClient = new FTPClient();


    public void init(String userName, String password, String ip, int port) {
        this.userName = userName;
        this.password = password;
        this.ip = ip;
        this.port = port;

    }

    private void login() {

        try {
            ftpClient.connect(ip, port);
            ftpClient.login(userName, password);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void disConnection() {
        try {
            if (ftpClient.isConnected()) {
                ftpClient.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void store(String remote, String local) {
        try {
            int reply;
            login();
            reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();

            }
            InputStream input = null;
            changeDirectory(ftpClient, remote);

            File localFile = new File(local);

            if (!localFile.exists()) {

                return;
            }
            File[] listFiles = localFile.listFiles();
            if (!ArrayUtils.isEmpty(listFiles)) {
                String updName;
                String uploadFileName;
                for (File listFile : listFiles) {
                    if (listFile.isFile()) {

                        updName = listFile.getName();
                        uploadFileName = local + updName;
                        input = new FileInputStream(uploadFileName);
                        ftpClient.enterLocalPassiveMode();
                        ftpClient.storeFile(updName, input);
                        input.close();
                    }

                }


            }

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    private void changeDirectory(FTPClient ftpClient, String path) {
        try {
            if (!ftpClient.changeWorkingDirectory(path)) {
                String[] temp = path.split(System.getProperty("file.separator"));
                for (String s : temp) {
                    if (!ftpClient.changeWorkingDirectory(s)) {
                        ftpClient.makeDirectory(s);
                        ftpClient.changeWorkingDirectory(s);
                    }
                }
                ftpClient.changeWorkingDirectory(path);
            }
        } catch (IOException e) {
        }
    }
}
