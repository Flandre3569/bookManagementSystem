package com.mx.BookSystem.dao;

import com.mx.BookSystem.bean.User;
import com.mx.BookSystem.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    private DBUtil util = new DBUtil();


    @Override
    public List<User> queryAll() throws Exception {
        List<User> userList = new ArrayList<User>();
        Connection con = util.getCon();
        String sql = "select * from user;";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            String userId = rs.getString("userId");
            String password = rs.getString("password");
            String identity = rs.getString("identity");
            int bookNum = rs.getInt("bookNum");
            User u = new User(userId,password,identity,bookNum);
            userList.add(u);
        }
        util.close(rs, pst, con);
        return userList;
    }

    @Override
    public User queryById(String userId) throws Exception {
        Connection con = util.getCon();
        String sql = "select * from user where userId = ?;";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,userId);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            if(userId.equals(rs.getString("userId"))){
                String id = rs.getString("userId");
                String password = rs.getString("password");
                String identity = rs.getString("identity");
                int bookNum = rs.getInt("bookNum");
                User u = new User(id,password,identity,bookNum);
                util.close(rs, pst, con);
                return u;
            }
        }
        util.close(rs, pst, con);
        return null;
    }

    @Override
    public void add(User user) throws Exception {
        Connection con = util.getCon();
        String sql = "insert into user(userId,password,identity,bookNum) values (?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,user.getUserId());
        pst.setString(2,user.getPassword());
        pst.setString(3,user.getIdentity());
        pst.setInt(4,user.getBookNum());
        pst.executeUpdate();
        util.close(null, pst, con);
    }

    @Override
    public void delete(String userId) throws Exception {
        Connection con = util.getCon();
        String sql = "delete from user where userId = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,userId);

        pst.executeUpdate();
        util.close(null, pst, con);
    }

    @Override
    public void update(String userId,String password) throws Exception {
        Connection con = util.getCon();
        String sql = "update user set password=? where userId=?;";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,password);
        pst.setString(2,userId);
        pst.executeUpdate();
        util.close(null, pst, con);
    }

    @Override
    public void jia(String userId) throws Exception {
        Connection con = util.getCon();
        String sql = "update user set bookNum=? where userId=?;";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,queryById(userId).getBookNum()+1);
        pst.setString(2,userId);
        pst.executeUpdate();
        util.close(null, pst, con);
    }
    @Override
    public void jian(String userId) throws Exception {
        Connection con = util.getCon();
        String sql = "update user set bookNum=? where userId=?;";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,queryById(userId).getBookNum()-1);
        pst.setString(2,userId);
        pst.executeUpdate();
        util.close(null, pst, con);
    }

}
