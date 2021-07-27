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

@WebServlet("/delete")
public class BookDeleteServlet extends HttpServlet {

    BookDao bookDao = new BookDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setCharacterEncoding("UTF-8");
            String bookId = req.getParameter("bookId");
            bookDao.delete(bookId);
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
