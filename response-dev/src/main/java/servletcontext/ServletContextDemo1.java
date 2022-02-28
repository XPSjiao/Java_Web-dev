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
 * @description:两种方法获取ServletContext对象
 * @author: EthanJiao
 * @create: 2022-02-25
 **/
@WebServlet("/context1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.通过request对象获取
        ServletContext sc1 = req.getServletContext();
        //2.通过当前的Servlet对象获取
        ServletContext sc2 = this.getServletContext();

        //true
        System.out.println( sc1 == sc2);
    }
}
