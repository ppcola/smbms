package com.xi.servlet.user;


import com.xi.pojo.User;
import com.xi.service.user.UserServiceImpl;
import com.xi.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    // Servlet:控制层 调用业务层代码

    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("进入LoginServlet--start.....");

        String userCode = req.getParameter("userCode");

        String userPassword = req.getParameter("userPassword");


        // 和数据库中的密码进行对比即可 和业务层取出的进行对比

        UserServiceImpl userService = new UserServiceImpl();

        User user = userService.login(userCode, userPassword);  //已经把登录的人查询出来了

        if(user != null&&user.getUserPassword().equals(userPassword)){    //数据库中有此人，可以登录

            req.getSession().setAttribute(Constants.USER_SESSION,user); // 将用户的信息，放到session中;

            resp.sendRedirect("jsp/frame.jsp");

        }else {     //数据库中有此人，无法登录，转发回登录页面，提示用户名，密码错误

            req.setAttribute("error","用户名或者密码不正确");

            req.getRequestDispatcher("login.jsp").forward(req,resp);

        }

    }



    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req, resp);

    }
}
