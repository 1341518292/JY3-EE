package com.weian.utils;

import com.weian.controller.ServletProduct;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 拿到方法的工具
 * @author weian
 * @since 2019-05-23
 */
public class MethodUtilDemo {


    //设置单例模式
    private MethodUtilDemo(){

    }

    private static MethodUtilDemo mu = null;

    public static MethodUtilDemo getUtil(){
        if(null == mu){
            mu = new MethodUtilDemo();
        }
        return mu;
    }

    //传入地址名拿到该执行的方法
    public Method getMethodUtil(String methodName){
        //声明一个方法
        Method method;
        //截取字符串
        String[] split = methodName.split("\\.");
        String str = split[0];
        //拿到方法名
        String me = str.substring(1);
        System.out.println(me);
        try {
            method = ServletProduct.class.getDeclaredMethod(me, HttpServletRequest.class, HttpServletResponse.class);
            return method;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
