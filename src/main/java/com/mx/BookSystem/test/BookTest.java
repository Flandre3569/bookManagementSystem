package com.mx.BookSystem.test;

import com.mx.BookSystem.bean.Book;
import com.mx.BookSystem.dao.BookDao;
import com.mx.BookSystem.dao.BookDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class BookTest {
    public static void main(String[] args) throws Exception {
        BookDao bookDao = new BookDaoImpl();
        List<Book> bookList = new ArrayList<Book>();

//        for (Book book:bookList) {
//            System.out.println(book);
//        }
//        Book book = new Book();
//        book =  bookDao.queryById("1000");
//        System.out.println(book);

//        Book b = new Book("1004","草房子","曹文轩",25.0,"经典文学作品",0);
//        bookDao.add(b);

//        bookDao.delete("1004");
//        Book b = new Book("1003","我是猫","夏日漱石",59,"我是猫",0);
//        bookDao.update("1003",b);
//
//        bookList = bookDao.queryAll();
//        for (Book book:bookList) {
//            System.out.println(book);
//        }
        bookDao.xiugai("1000",0);
    }
}
