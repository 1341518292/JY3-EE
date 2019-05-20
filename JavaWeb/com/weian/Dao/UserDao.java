package com.weian.Dao;

import com.weian.entity.User;

public interface UserDao {

    //添加用户
    void addUser(User user);
    //查找用户
    User selectUser(User user);
}
