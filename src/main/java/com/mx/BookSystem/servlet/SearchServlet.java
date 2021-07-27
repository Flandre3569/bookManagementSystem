package com.mx.BookSystem.servlet;

import com.mx.BookSystem.bean.Book;
import com.mx.BookSystem.bean.Borrow;
import com.mx.BookSystem.dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BookDao bookdao=new BookDaoImpl();
            BorrowDao borrowdao=new BorrowDaoImpl();
            UserDao userdao=new UserDaoImpl();
            String bookName=request.getParameter("searchName");
            System.out.println(bookName);////
            String userId=(String)request.getSession().getAttribute("userId");
            Book book=bookdao.queryByName(bookName);
            System.out.println(book);
            request.setAttribute("book",book);
            List<Book> bookList=new ArrayList<Book>();
            bookList=bookdao.queryAll();
            request.setAttribute("bookList",bookList);
            List<Borrow> borrowList=new ArrayList<Borrow>();
            borrowList=borrowdao.queryById(userId);
            request.setAttribute("borrowList",borrowList);
            request.getSession().setAttribute("swf",2);
            request.getRequestDispatcher("Book_index.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
