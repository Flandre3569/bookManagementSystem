package com.mx.BookSystem.servlet;

import com.mx.BookSystem.bean.Book;
import com.mx.BookSystem.bean.Borrow;
import com.mx.BookSystem.bean.User;
import com.mx.BookSystem.dao.*;
import com.mysql.cj.Session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    UserDao userDao = new UserDaoImpl();
    BookDao bookDao = new BookDaoImpl();
    BorrowDao borrowDao = new BorrowDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setCharacterEncoding("UTF-8");
            String userId = request.getParameter("username");
            String pwd = request.getParameter("password");
            String identity = request.getParameter("identity");


            User user = new User();
            user=userDao.queryById(userId);
            if(user==null){
                request.setAttribute("msg","用户名、密码或身份错误");
                request.getRequestDispatcher("login-index.jsp").forward(request,response);
            }else{
                if(userId.equals(user.getUserId()) && pwd.equals(user.getPassword()) && identity.equals(user.getIdentity())){

                    if(user.getIdentity().equals("用户")){
                        //用户
                        request.getSession().setAttribute("userId",userId);
                        User u = userDao.queryById(userId);
                        request.getSession().setAttribute("bookNum",u.getBookNum());
                        response.sendRedirect("index.jsp");

                    }else{
                        //管理员
                        List<User> userList = new ArrayList<User>();
                        userList = userDao.queryAll();
                        List<Book> bookList = new ArrayList<Book>();
                        bookList = bookDao.queryAll();
                        List<Borrow> borrowList = new ArrayList<Borrow>();
                        borrowList = borrowDao.queryAll();

                        request.getSession().setAttribute("userList",userList);
                        request.getSession().setAttribute("bookList",bookList);
                        request.getSession().setAttribute("borrowList",borrowList);

                        request.getSession().setAttribute("admin",userId);
                        request.getSession().setAttribute("swf",0);
                        response.sendRedirect("Manager_index.jsp");
                    }
                }else{
                    request.setAttribute("msg","用户名、密码或身份错误");
                    request.getRequestDispatcher("login-index.jsp").forward(request,response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
