package com.bo.servlet;

import com.bo.entity.Book;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * @program: Java_Web-dev
 * @description: 主页的servlet
 * @author: EthanJiao
 * @create: 2022-02-24
 **/
@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取各个Servlet共享的对象
        ServletContext sc = this.getServletContext(); //得到前面设置的全局对象
        //获取全局应用对象中的变量
        List<Book> bookList = (List<Book>) sc.getAttribute("bookList");//唯一的数据，因为监听器只会做一次
        //存入request
        req.setAttribute("bookList",bookList);
        //把相应对象的对象类型设置为纯文本类型
        resp.setContentType("text/plain;charset=utf-8");
        resp.getWriter().print(bookList.toString());//把集合转为字符串，响应的时候就能看到图书记录
        //通过服务器转发，将数据带过去，并保持地址栏不变
        req.getRequestDispatcher("/index.jsp").forward(req,resp);//转发到主页面

    }
}
