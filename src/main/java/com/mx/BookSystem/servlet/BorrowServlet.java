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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/borrow")
public class BorrowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            BorrowDao bd1=new BorrowDaoImpl();
            BookDao bd2=new BookDaoImpl();
            UserDao ud=new UserDaoImpl();
            String bookId=request.getParameter("bookId");
            String userId=(String)request.getSession().getAttribute("userId");
            if(bd2.queryById(bookId).getIsBorrowed()==1||ud.queryById(userId).getBookNum()>=8){
                Book book=null;
                request.setAttribute("book",book);
                List<Book> bookList=new ArrayList<Book>();
                bookList=bd2.queryAll();
                request.setAttribute("bookList",bookList);
                List<Borrow> borrowList=new ArrayList<Borrow>();
                borrowList=bd1.queryById(userId);
                request.setAttribute("borrowList",borrowList);
                User u = ud.queryById(userId);
                request.getSession().setAttribute("bookNum",u.getBookNum());
                request.getRequestDispatcher("Book_index.jsp").forward(request,response);
            }
            long id=System.currentTimeMillis();
            Date d=new Date(id);
            String bookName= null;
            bookName = bd2.queryById(bookId).getBookName();
            String author= null;
            author = bd2.queryById(bookId).getAuthor();
            Borrow borrow=new Borrow(userId,bookId,bookName,author,d,d);

            bd1.add(borrow);
            bd1.delay(60,bookId);
            bd2.xiugai(bookId,1);
            ud.jia(userId);

            User u = ud.queryById(userId);
            request.getSession().setAttribute("bookNum",u.getBookNum());

            Book book=null;
            request.setAttribute("book",book);
            List<Book> bookList=new ArrayList<Book>();
            bookList=bd2.queryAll();
            request.setAttribute("bookList",bookList);
            List<Borrow> borrowList=new ArrayList<Borrow>();
            borrowList=bd1.queryById(userId);
            request.setAttribute("borrowList",borrowList);


            request.getSession().setAttribute("swf",0);

            request.getRequestDispatcher("Book_index.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
