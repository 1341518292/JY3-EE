package com.weian.Util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 拿到连接的工具
 */
public class Conn {
    private static Properties prop = new Properties();
    static{
        try {
            prop.load(Conn.class.getResourceAsStream("/mysql.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String psw = prop.getProperty("password");
        Connection root = null;
        try {
             root = DriverManager.getConnection(url, user, psw);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return root;
    }
    public static void closeConn(Connection connection, PreparedStatement preparedStatement){
        if(null != preparedStatement){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null != connection){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void closeConn(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
            closeConn(connection,preparedStatement);
            if(null != resultSet){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }
}
