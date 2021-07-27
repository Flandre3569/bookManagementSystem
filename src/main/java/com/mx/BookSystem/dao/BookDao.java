package com.mx.BookSystem.dao;


import com.mx.BookSystem.bean.Book;

import java.util.List;

public interface BookDao {
    //查询所有图书
    List<Book> queryAll() throws Exception;
    //通过id查询图书
    Book queryById(String bookId) throws Exception;
    //增加一本图书
    void add(Book book) throws Exception;
    //删除一本图书
    void delete(String bookId) throws Exception;
    //修改图书信息
    void update(String bookId,Book book) throws Exception;
    //修改借阅状态
    void xiugai(String bookId,int n) throws Exception;
    //通过书名查询图书
    Book queryByName(String bookName)throws Exception;
}
