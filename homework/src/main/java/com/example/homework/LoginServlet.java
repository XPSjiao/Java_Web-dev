package com.example.homework;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: Java_Web-dev
 * @description: 登录
 * @author: EthanJiao
 * @create: 2022-02-24
 **/

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //通过request取出账号和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //如果条件成立，就记录下来，并且跳转到另一个servlet中取出一些数据
        if ("admin".equals(username) && "111".equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            //地址栏重定向
            resp.sendRedirect("index");
        } else {
            //如果账号和密码有一个不配对，就向用户输出一个登录失败的信息
            resp.setCharacterEncoding("UTF-8");//防止中文乱码
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = resp.getWriter();
            writer.print("<script>\n" +
                    "    alert(\"登录失败\");\n" +
                    "    location.href=(\"/\");\n" +
                    "</script>");
//            resp.sendRedirect("/");//重定向到根目录页面
        }
    }
}
