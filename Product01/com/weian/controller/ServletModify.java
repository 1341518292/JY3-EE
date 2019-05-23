package com.weian.controller;

import com.weian.Entity.User;
import com.weian.dao.UserDao;
import com.weian.dao.UserDaoImpl;
import com.weian.utils.Encryption;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletModify",urlPatterns = "/modify.do")
public class ServletModify extends HttpServlet {

    private UserDao ud;

    @Override
    public void init() throws ServletException {
        ud = new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int newId = Integer.parseInt(id);
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        ud.modifyOne(new User(newId,user,password));
        String newPsw = Encryption.setEncry(password);
        response.getWriter().print(newPsw);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
