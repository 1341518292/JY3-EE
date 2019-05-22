package com.weian.controller;

import com.weian.Entity.User;
import com.weian.dao.UserDao;
import com.weian.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletLogin",urlPatterns = "/login.do")
public class ServletLogin extends HttpServlet {

    //Dao
    UserDao ud = null;

    @Override
    public void init() throws ServletException {
        ud = new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String u = request.getParameter("u");
        String p = request.getParameter("p");
        User user = ud.selectOne(new User(u, p));
        if(null != user){
            List<User> users = ud.selectAll();
            request.setAttribute("users",users);
            request.getRequestDispatcher("page/Welcome.jsp").forward(request,response);
        }else {
            response.sendRedirect("page/Login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
