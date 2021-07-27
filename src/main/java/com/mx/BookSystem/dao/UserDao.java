package com.mx.BookSystem.dao;

import com.mx.BookSystem.bean.User;

import java.util.List;

public interface UserDao {
    //查询所有用户
    List<User> queryAll() throws Exception;
    //通过id查询用户
    User queryById(String userId)throws Exception;
    //增加一个用户
    void add(User user)throws Exception;
    //根据id删除一个用户
    void delete(String userId)throws Exception;
    //修改密码
    void update(String userId,String password)throws Exception;
    //加一
    void jia(String userId) throws  Exception;
    //减一
    void jian(String userId) throws  Exception;
}
