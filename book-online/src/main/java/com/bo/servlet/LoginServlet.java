package com.bo.servlet;

import com.bo.entity.User;
import com.bo.service.UserService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @program: Java_Web-dev
 * @description: 登录验证
 * @author: EthanJiao
 * @create: 2022-02-24
 **/
@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取得表单参数
        String account = req.getParameter("accoount");
        String password = req.getParameter("password");
        UserService userService = new UserService();
        //获得用户列表数据
        ServletContext sc = this.getServletContext();
        List<User> userList = (List<User>) sc.getAttribute("userList");
        //将数据传到userService
        userService.setUserList(userList);
        //调用登录功能
        User user = userService.signIn(account,password);
        if(user != null){
            //登录成功，将用户对象记入session
            HttpSession session = req.getSession();
            session.setAttribute("user",user);

            //重定向到/index，进入到IndexServlet
            resp.sendRedirect("/index");
        }else {
            //登录失败
            resp.setContentType("text/html;charset=utf-8");
            resp.setCharacterEncoding("UTF-8");
            //获得response对象的字符输出流
            PrintWriter out = resp.getWriter();

            //输出js脚本，弹出登录失败的信息，重定向回登录页面
            out.print("<script>alert('账号或密码错误');local.href='/login';</script>");
            resp.sendRedirect("/");
        }
    }
}
