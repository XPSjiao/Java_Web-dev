package com.bo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @program: Java_Web-dev
 * @description: 注销
 * @author: EthanJiao
 * @create: 2022-02-24
 **/

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //让session失效
        session.invalidate();
        //重定向到/index，跳回主页
        resp.sendRedirect("/");
    }
}
