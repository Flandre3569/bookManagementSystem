package com.mx.BookSystem.servlet;


import com.mx.BookSystem.bean.Book;
import com.mx.BookSystem.bean.Borrow;
import com.mx.BookSystem.dao.BookDao;
import com.mx.BookSystem.dao.BookDaoImpl;
import com.mx.BookSystem.dao.BorrowDao;
import com.mx.BookSystem.dao.BorrowDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/book")
public class BookServlet extends HttpServlet {

    BookDao bookDao = new BookDaoImpl();
    BorrowDao bd = new BorrowDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
//            req.setCharacterEncoding("UTF-8");
            List<Book> bookList = new ArrayList<Book>();
            bookList = bookDao.queryAll();
            req.setAttribute("bookList",bookList);

            List<Borrow> borrowList=new ArrayList<Borrow>();
            borrowList=bd.queryById((String)req.getSession().getAttribute("userId"));
            req.setAttribute("borrowList",borrowList);
            req.getSession().setAttribute("swf",0);
            req.getRequestDispatcher("Book_index.jsp").forward(req,resp);
//            resp.sendRedirect("Book_index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
