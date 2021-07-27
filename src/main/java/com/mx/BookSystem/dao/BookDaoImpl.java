package com.mx.BookSystem.dao;

import com.mx.BookSystem.bean.Book;
import com.mx.BookSystem.bean.User;
import com.mx.BookSystem.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao{

    private DBUtil util = new DBUtil();

    @Override
    public List<Book> queryAll() throws Exception {
        List<Book> bookList = new ArrayList<Book>();
        Connection con = util.getCon();
        String sql = "select * from book";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            String bookId = rs.getString("bookId");
            String bookName = rs.getString("bookName");
            String author = rs.getString("author");
            double price = rs.getDouble("price");
            String remarks = rs.getString("remarks");
            int isBorrowed = rs.getInt("isBorrowed");
            Book b = new Book(bookId,bookName,author,price,remarks,isBorrowed);
            bookList.add(b);
        }
        util.close(rs, pst, con);
        return bookList;
    }

    @Override
    public Book queryById(String bookId) throws Exception {
        Connection con = util.getCon();
        String sql = "select * from book where bookId = ?;";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,bookId);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            if(bookId.equals(rs.getString("bookId"))){
                String id = rs.getString("bookId");
                String bookName = rs.getString("bookName");
                String author = rs.getString("author");
                double price = rs.getDouble("price");
                String remarks = rs.getString("remarks");
                int isBorrowed = rs.getInt("isBorrowed");
                Book b = new Book(id,bookName,author,price,remarks,isBorrowed);
                util.close(rs, pst, con);
                return b;
            }
        }
        util.close(rs, pst, con);
        return null;
    }

    @Override
    public void add(Book book) throws Exception {
        Connection con = util.getCon();
        String sql = "insert into book(bookId,bookName,author,price,remarks,isBorrowed) values (?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,book.getBookId());
        pst.setString(2,book.getBookName());
        pst.setString(3,book.getAuthor());
        pst.setDouble(4,book.getPrice());
        pst.setString(5,book.getRemarks());
        pst.setInt(6,book.getIsBorrowed());
        pst.executeUpdate();
        util.close(null, pst, con);
    }

    @Override
    public void delete(String bookId) throws Exception {
        Connection con = util.getCon();
        String sql = "delete from book where bookId = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,bookId);

        pst.executeUpdate();
        util.close(null, pst, con);
    }

    @Override
    public void update(String bookId,Book book) throws Exception {
        Connection con = util.getCon();
        String sql = "update book set bookId=?,bookName=?,author=?,price=?,remarks=?,isBorrowed=? where bookId=?;";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,book.getBookId());
        pst.setString(2,book.getBookName());
        pst.setString(3,book.getAuthor());
        pst.setDouble(4,book.getPrice());
        pst.setString(5,book.getRemarks());
        pst.setInt(6,book.getIsBorrowed());
        pst.setString(7,bookId);
        pst.executeUpdate();
        util.close(null, pst, con);
    }

    @Override
    public void xiugai(String bookId,int i) throws Exception {
        Connection conn=util.getCon();
        String sql="update book set isBorrowed=? where bookId=?; ";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,i);
        ps.setString(2,bookId);
        ps.executeUpdate();
        util.close(null,ps,conn);
    }

    @Override
    public Book queryByName(String bookname) throws Exception {
        Connection con = util.getCon();
        String sql = "select * from book where bookName = ?;";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,bookname);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            String bookId = rs.getString("bookId");
            String bookName = rs.getString("bookName");
            String author = rs.getString("author");
            double price = rs.getDouble("price");
            String remarks = rs.getString("remarks");
            int isBorrowed = rs.getInt("isBorrowed");
            Book b = new Book(bookId,bookName,author,price,remarks,isBorrowed);
            util.close(rs, pst, con);
            return b;
        }
        util.close(rs, pst, con);
        return null;
    }

}
