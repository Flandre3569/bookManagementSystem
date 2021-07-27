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

@WebServlet("/update1")
public class BookUpdate1Servlet extends HttpServlet {

    BookDao bookDao = new BookDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            String bookId = req.getParameter("bookId");
            Book book = bookDao.queryById(bookId);
            req.getSession().setAttribute("bookId",book.getBookId());
            req.getSession().setAttribute("bookName",book.getBookName());
            req.getSession().setAttribute("author",book.getAuthor());
            req.getSession().setAttribute("price",book.getPrice());
            req.getSession().setAttribute("remarks",book.getRemarks());
            req.getSession().setAttribute("isBorrowed",book.getIsBorrowed());
            req.getSession().setAttribute("swf",4);

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
