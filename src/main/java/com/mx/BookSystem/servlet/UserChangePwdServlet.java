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

@WebServlet("/change")
public class UserChangePwdServlet extends HttpServlet {

    UserDao userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setCharacterEncoding("UTF-8");
            String oldPwd = req.getParameter("oldPwd");
            String newPwd = req.getParameter("newPwd");
            String userId = (String) req.getSession().getAttribute("userId");
            User user = userDao.queryById(userId);
            if(oldPwd.equals(user.getPassword())){
                userDao.update(userId,newPwd);
                req.getSession().setAttribute("message","密码修改成功！");
                resp.sendRedirect("User_index.jsp");
            }else{
                req.getSession().setAttribute("message","旧密码错误，密码修改失败！");
                resp.sendRedirect("User_index.jsp");
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
