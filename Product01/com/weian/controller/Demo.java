package com.weian.controller;

import com.alibaba.fastjson.JSONArray;
import com.weian.Entity.User;
import com.weian.dao.UserDao;
import com.weian.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet(name = "Demo",urlPatterns = "*.do")
public class Demo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getRequestURI();
        String[] split = str.split("\\.");
        String me = split[0].substring(1);
        if(me.equals("getUser")){
            try {
                Method method = getClass().getDeclaredMethod(me,HttpServletRequest.class,HttpServletResponse.class);
                System.out.println(HttpServletRequest.class);
                System.out.println(HttpServletResponse.class);
                System.out.println(method);
                //method.invoke(this,request,response);
            } catch (Exception e) {
                System.out.println("失败");
                e.printStackTrace();
            }
            getUser(request,response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public List<User> getUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        UserDao ud = new UserDaoImpl();
        List<User> users = ud.selectAll();

        String id = request.getParameter("id");
        System.out.println("是我getUser");
        if(null != id){
            int newId = Integer.parseInt(id);
            System.out.println(newId);
        }
        String s = JSONArray.toJSONString(users);
        JSONArray objects = JSONArray.parseArray(s);
        System.out.println(objects);
        response.getWriter().print(objects);
        return users;
    }
}
