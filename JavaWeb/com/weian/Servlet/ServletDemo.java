package com.weian.Servlet;

import com.weian.Dao.UserDaoImp;
import com.weian.Util.Encry;
import com.weian.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Weian
 * 我的第一个Servlet
 */
@WebServlet(name = "ServletDemo",urlPatterns = "/weian")
public class ServletDemo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String psw = request.getParameter("psw");
        //对密码进行加密
        String encryption = Encry.getEncryption(psw);
        UserDaoImp userDaoImp = new UserDaoImp();
        User user1 = new User(user, encryption);
        userDaoImp.addUser(user1);
        request.getRequestDispatcher("Login.jsp").forward(request,response);
    }


}
