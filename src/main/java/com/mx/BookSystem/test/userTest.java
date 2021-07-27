package com.mx.BookSystem.test;

import com.mx.BookSystem.bean.User;
import com.mx.BookSystem.dao.UserDao;
import com.mx.BookSystem.dao.UserDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class userTest {
    public static void main(String[] args) throws Exception {
        //dao测试
        UserDao userDao = new UserDaoImpl();
        List<User> userList = new ArrayList<User>();


        userDao.jia("222");
        userList = userDao.queryAll();
        for (User user:userList) {
            System.out.println(user);
        }
//        User u = new User();
//        u = userDao.queryById("111");
//        System.out.println(u);

    }
}
