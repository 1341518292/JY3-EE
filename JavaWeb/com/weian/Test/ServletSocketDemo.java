package com.weian.Test;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServletSocketDemo {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("������ѿ���");
            //��������
            Socket accept = serverSocket.accept();
            //�õ��ֽ���
            InputStream inputStream = accept.getInputStream();
            //���ֽ���ת�ɻ�����
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String s = bufferedReader.readLine();
            System.out.println("�ͻ��˷��͵���Ϣ:"+s);
            bufferedReader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
