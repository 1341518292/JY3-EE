package com.weian.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 拿连接的工具类
 */
public class DButilDemo {

    private DButilDemo(){

    }
    //声明一个数据源
    private static DataSource dataSource;
    //声明一个配置文件
    private static Properties properties = new Properties();
    //声明一个自己的实例
    private static DButilDemo DB = null;

    //加载配置文件和数据源
    static{
        try {
            //拿到资源
            InputStream resourceAsStream = DButilDemo.class.getResourceAsStream("/dataSource.properties");
            //加载
            properties.load(resourceAsStream);
            //创建数据源
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DButilDemo getDB(){
        if(null == DB){
            DB = new DButilDemo();
        }
        return DB;
    }

    //拿连接
    public Connection getConn(){

        try {
            return  dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        DButilDemo db = getDB();
        Connection conn = db.getConn();
        System.out.println(conn);
    }
}
