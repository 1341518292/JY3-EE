package com.weian.dao;

import com.weian.Entity.Product;
import com.weian.utils.DButilDemo;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 商品实现类
 * @author weian
 * @since 2019-05-23
 */
public class ProductDaoImpl implements ProductDao{

    public ProductDaoImpl(){
         qr = new QueryRunner();
    }

    //拿到工具类
    private DButilDemo db = DButilDemo.getDB();
    //初始化功能引用
    private QueryRunner qr;


    @Override
    public void addPro(Product product) {
        String sql = "INSERT INTO product VALUES(?,?,?,?,?,?,?,?,?)";
        Connection conn = db.getConn();
        try {
            int update = qr.update(conn, sql, product.getPro_id(), product.getPro_name(), product.getPro_price(), product.getPro_image(), product.getPro_des(), product.getPro_stock(), product.getPro_date(), product.getPro_category_id(), product.getPro_factory());
            if(0<update){
                System.out.println("添加成功");
            }else {
                System.out.println("失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deletePro(int pro_id) {
        String sql = "DELETE FROM product WHERE pro_id=?";
        Connection conn = db.getConn();
        try {
            int update = qr.update(conn, sql, pro_id);
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void modifyPro(Product product) {
        String sql = "UPDATE product SET ";
    }

    @Override
    public Product selectPro(int pro_id) {
        String sql = "SELECT * FROM product WHERE pro_id = ?";
        Connection conn = db.getConn();
        Product query;
        try {
            query = qr.query(conn, sql, new BeanHandler<>(Product.class), pro_id);
            return query;
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

    @Override
    public List<Product> selectAllPro() {
        String sql = "SELECT * FROM product";
        Connection conn = db.getConn();
        List<Product> query;
        try {
            query = qr.query(conn, sql, new BeanListHandler<>(Product.class));
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
