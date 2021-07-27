package com.mx.BookSystem.servlet;

import com.mx.BookSystem.bean.Book;
import com.mx.BookSystem.bean.User;
import com.mx.BookSystem.dao.UserDao;
import com.mx.BookSystem.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/userDelete")
public class UserDeleteServlet extends HttpServlet {

    UserDao userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            String userId = req.getParameter("userId");
            userDao.delete(userId);

            List<User> userList = new ArrayList<User>();
            userList = userDao.queryAll();
            req.getSession().setAttribute("userList",userList);
            req.getSession().setAttribute("swf",1);
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
