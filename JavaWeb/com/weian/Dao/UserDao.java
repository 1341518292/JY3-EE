package com.weian.Dao;

import com.weian.entity.User;

public interface UserDao {

    //����û�
    void addUser(User user);
    //�����û�
    User selectUser(User user);
}
