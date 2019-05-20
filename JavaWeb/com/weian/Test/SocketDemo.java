package com.weian.Test;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketDemo {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            //创建客户端(host:地址,port:端口号)
            Socket socket = new Socket("127.0.0.1",8888);
            System.out.println("客户端已开启");
            System.out.println("请输入要发送的话");
            String str = scanner.nextLine();
            //拿到输出字节流
            OutputStream outputStream = socket.getOutputStream();
            //转成输出字符流
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write(str);
            //换行,因为服务端读取一行
            bufferedWriter.newLine();
            //刷新，不刷新的话会显示不到你输入的话
            bufferedWriter.flush();
            //关闭
            bufferedWriter.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
