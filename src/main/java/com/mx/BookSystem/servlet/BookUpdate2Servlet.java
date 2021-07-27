package com.mx.BookSystem.servlet;

import com.mx.BookSystem.bean.Book;
import com.mx.BookSystem.dao.BookDao;
import com.mx.BookSystem.dao.BookDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/update2")
public class BookUpdate2Servlet extends HttpServlet {

    BookDao bookDao = new BookDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setCharacterEncoding("UTF-8");
            String bookId = req.getParameter("bookId");
            String bookName = req.getParameter("bookName");
            String author = req.getParameter("author");
            double price = Double.parseDouble(req.getParameter("price"));
            String remarks = req.getParameter("remarks");
            int isBorrowed = (int) req.getSession().getAttribute("isBorrowed");
            Book book = new Book(bookId,bookName,author,price,remarks,isBorrowed);

            bookDao.update((String)req.getSession().getAttribute("bookId"),book);
            List<Book> bookList = new ArrayList<Book>();
            bookList = bookDao.queryAll();
            req.getSession().setAttribute("bookList",bookList);
            req.getSession().setAttribute("swf",2);

            resp.sendRedirect("Manager_index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
