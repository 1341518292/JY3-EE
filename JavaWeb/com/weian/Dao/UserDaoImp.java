package com.weian.Dao;

import com.weian.Util.Conn;
import com.weian.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * user µœ÷¿‡
 */
public class UserDaoImp implements UserDao{

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO user(user,password) VALUES (?,?)";
        Connection conn = Conn.getConnection();
        PreparedStatement preparedStatement = null;
        try {
             preparedStatement = conn.prepareStatement(sql);
             preparedStatement.setString(1,user.getUser());
             preparedStatement.setString(2,user.getPassword());
             preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Conn.closeConn(conn,preparedStatement);
        }
    }

    @Override
    public User selectUser(User user) {

        String sql = "SELECT user,password FROM User WHERE user = ? AND password = ?";
        Connection conn = Conn.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,user.getUser());
            preparedStatement.setString(2,user.getPassword());
            rs = preparedStatement.executeQuery();
            if (rs.next()){
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Conn.closeConn(conn,preparedStatement,rs);
        }
        return null;
    }
}
