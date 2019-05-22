package com.weian.dao;

import com.weian.Entity.User;

import java.util.List;

/**
 * User类的接口
 */
public interface UserDao {
    //增加一条数据
    void insertOne(User user);
    //删除一条数据
    void delectOne(String user);
    //修改一条数据
    void modifyOne(User user);
    //查询所有用户
    List<User> selectAll();
    //查询一个用户和登录检测
    User selectOne(User user);

}
