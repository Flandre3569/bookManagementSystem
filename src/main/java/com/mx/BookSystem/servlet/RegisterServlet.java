package com.mx.BookSystem.servlet;

import com.mx.BookSystem.bean.User;
import com.mx.BookSystem.dao.UserDao;
import com.mx.BookSystem.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    UserDao userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String userId = request.getParameter("username2");
            String pwd = request.getParameter("password2");

            User u = new User();
            u = userDao.queryById(userId);

            if(u==null || !u.getUserId().equals(userId)){
                User user = new User(userId,pwd,"用户",0);
                userDao.add(user);
                request.getRequestDispatcher("login-index.jsp").forward(request,response);
            }else{
                request.setAttribute("msg2","注册失败，用户已存在或者格式不正确！");
                request.getRequestDispatcher("login-index.jsp").forward(request,response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
