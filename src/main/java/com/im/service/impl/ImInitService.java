package com.im.service.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

@Service
public class ImInitService implements InitializingBean {

    private ServerSocket serverSocket;

    @Override
    public void afterPropertiesSet() throws Exception {

        try {
            System.out.println("后台正在开启通讯端口...");
            serverSocket = new ServerSocket(10086);
            System.out.println("后台开启通讯端口成功");
        } catch (Exception e){
            System.out.println("后台通讯端口开启失败--->"+e.getMessage());
        }


        while (true){
            System.out.println("等待客户端连接中...");
            Socket socket = serverSocket.accept();
            System.out.println("客户端发起连接了：IP:"+socket.getInetAddress()+"  PORT:"+socket.getPort());
            InputStream inputStream = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);
            String message = br.readLine();
            System.out.println("客户端:"+message);

            inputStream.close();
            isr.close();
            br.close();

            if (message != null) {
                if (message.equals("bye")) {
                    break;
                }
            }
        }
    }
}
