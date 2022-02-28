package com.example.homework;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Java_Web-dev
 * @description: 登录跳转
 * @author: EthanJiao
 * @create: 2022-02-24
 **/
@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book[] books ={
                new Book("Java","Java.jpg","Java大神"),
                new Book("JavaWeb","JavaWeb.jpg","JavaWeb超人"),
                new Book("JavaScript","JavaScript.jpg","JavaScript牛人"),
        };
        List<Book> bookList = Arrays.asList(books);//books数组转为集合
        req.setAttribute("bookList",bookList);
        req.getRequestDispatcher("index.jsp").forward(req,resp);//经过indexServlet之后由服务器端将页面转发到真正的首页jsp页面
    }
}
