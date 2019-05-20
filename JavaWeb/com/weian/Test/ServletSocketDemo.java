package com.weian.Test;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServletSocketDemo {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务端已开启");
            //阻塞方法
            Socket accept = serverSocket.accept();
            //拿到字节流
            InputStream inputStream = accept.getInputStream();
            //将字节流转成缓冲流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String s = bufferedReader.readLine();
            System.out.println("客户端发送的消息:"+s);
            bufferedReader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
