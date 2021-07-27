package com.mx.BookSystem.test;


import com.mx.BookSystem.bean.Borrow;
import com.mx.BookSystem.dao.BorrowDao;
import com.mx.BookSystem.dao.BorrowDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class BorrowTest {
    public static void main(String[] args) throws Exception {

        BorrowDao borrowDao = new BorrowDaoImpl();

        List<Borrow> borrowList = new ArrayList<Borrow>();
        borrowList=borrowDao.queryById("222");
        for (Borrow borrow:borrowList) {
            System.out.println(borrow);
        }
        borrowDao.delete("1000");
    }
}
