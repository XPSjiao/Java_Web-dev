package servletcontext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @program: Java_Web-dev
 * @description:通过ServletContext共享数据
 * 1-获取MIME类型
 * 2-共享数据
 * 3-获取服务器的真实路径
 * @author: EthanJiao
 * @create: 2022-02-25
 **/
@WebServlet("/context3")
public class ServletContextDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        context.setAttribute("data","hello world");
        resp.sendRedirect("/responseDemo2");

    }
}
