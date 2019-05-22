package com.weian.dao;

import com.weian.Entity.User;
import com.weian.utils.DButilDemo;
import com.weian.utils.Encryption;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao{
    public UserDaoImpl() {
      qr  = new QueryRunner();
    }
    //声明并初始化连接工具
    private DButilDemo db = DButilDemo.getDB();
    //声明查询工具
    private QueryRunner qr;

    //查询所有数据
    @Override
    public List<User> selectAll() {
        String sql = "SELECT user,password FROM User";
        Connection conn = db.getConn();
        List<User> users;
        try {
            users = qr.query(conn,sql,new BeanListHandler<>(User.class));
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //登录验证
    @Override
    public User selectOne(User user) {
        String sql = "SELECT user,password FROM user WHERE user=? AND password=?";
        Connection conn = db.getConn();
        try {
            User query = qr.query(conn, sql, new BeanHandler<>(User.class),user.getUser(),Encryption.setEncry(user.getPassword()));
            if(null != query){
                return query;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }   finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void insertOne(User user) {
        String sql = "INSERT INTO user(user,password) VALUES(?,?)";
        Connection conn = db.getConn();
        try {
            int update = qr.update(conn, sql, user.getUser(), Encryption.setEncry(user.getPassword()));
            if(0<update){
                System.out.println("注册成功");
            }else {
                System.out.println("失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delectOne(String user) {
        String sql = "delete FROM user WHERE user=?";
        Connection conn = db.getConn();
        try {
            int update = qr.update(conn, sql, user);
            if(update>0){
                System.out.println("删除成功");
            }else {
                System.out.println("失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void modifyOne(User user) {
        String sql = "UPDATE user SET password=? WHERE user=?";
        Connection conn = db.getConn();
        try {
            int update = qr.update(conn, sql, Encryption.setEncry(user.getPassword()), user.getUser());
            if(0<update){
                System.out.println("修改成功");
            }else {
                System.out.println("失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
