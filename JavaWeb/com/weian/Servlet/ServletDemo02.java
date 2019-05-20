package com.weian.Servlet;

import com.weian.Dao.UserDao;
import com.weian.Dao.UserDaoImp;
import com.weian.Util.Encry;
import com.weian.entity.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDemo02",urlPatterns = "/Welcome")
public class ServletDemo02 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String User = request.getParameter("LoginUser");
        String psw = request.getParameter("LoginPsw");
        UserDao userDao = new UserDaoImp();
        //对用户输入进来的密码加密
        String encryption = Encry.getEncryption(psw);
        User user = userDao.selectUser(new User(User,encryption));

        if(null != user){
            request.setAttribute("user",User);
            request.getRequestDispatcher("Welcome.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("Login.jsp").forward(request,response);
        }

    }
}
