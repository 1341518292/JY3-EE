package com.weian.Test;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketDemo {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            //�����ͻ���(host:��ַ,port:�˿ں�)
            Socket socket = new Socket("127.0.0.1",8888);
            System.out.println("�ͻ����ѿ���");
            System.out.println("������Ҫ���͵Ļ�");
            String str = scanner.nextLine();
            //�õ�����ֽ���
            OutputStream outputStream = socket.getOutputStream();
            //ת������ַ���
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write(str);
            //����,��Ϊ����˶�ȡһ��
            bufferedWriter.newLine();
            //ˢ�£���ˢ�µĻ�����ʾ����������Ļ�
            bufferedWriter.flush();
            //�ر�
            bufferedWriter.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
