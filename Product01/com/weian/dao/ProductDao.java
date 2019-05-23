package com.weian.dao;

import com.weian.Entity.Product;

import java.util.List;

/**
 * 商品功能
 * @author weian
 * @since 2019-05-23
 */
public interface ProductDao {

    //添加一件商品
    void addPro(Product product);
    //删除一件商品
    void deletePro(int pro_id);
    //修改商品
    void modifyPro(Product product);
    //查找一件商品
    Product selectPro(int pro_id);
    //查看所有商品
    List<Product> selectAllPro();

}
