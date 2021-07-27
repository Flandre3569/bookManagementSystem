package com.mx.BookSystem.servlet;

import com.mx.BookSystem.bean.Book;
import com.mx.BookSystem.bean.Borrow;
import com.mx.BookSystem.bean.User;
import com.mx.BookSystem.dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/return")
public class ReturnServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        String bookId=request.getParameter("bookId");
        String userId=(String)request.getSession().getAttribute("userId");
        BorrowDao borrowdao=new BorrowDaoImpl();
        UserDao ud=new UserDaoImpl();
        BookDao bd=new BookDaoImpl();
            borrowdao.delete(bookId);
            ud.jian(userId);
            bd.xiugai(bookId,0);
            Book book=null;
            request.setAttribute("book",book);
            List<Book> bookList=new ArrayList<Book>();
            bookList=bd.queryAll();
            request.setAttribute("bookList",bookList);
            List<Borrow> borrowList=new ArrayList<Borrow>();
            borrowList=borrowdao.queryById(userId);
            request.setAttribute("borrowList",borrowList);
            request.getSession().setAttribute("swf",1);
            User u = ud.queryById(userId);
            request.getSession().setAttribute("bookNum",u.getBookNum());

            request.getRequestDispatcher("Book_index.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
