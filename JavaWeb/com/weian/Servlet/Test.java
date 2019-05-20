package com.weian.Servlet;


import com.weian.Util.Encry;


public class Test {

    public static void main(String[] args) {
        String str = Encry.getEncryption("zwa1234");
        System.out.println(str);
    }

}
