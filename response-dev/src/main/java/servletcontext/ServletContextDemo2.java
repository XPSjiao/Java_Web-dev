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
 * @description:通过ServletContext获取MIME类型
 * 1-获取MIME类型
 * 2-共享数据
 * 3-获取服务器的真实路径
 * @author: EthanJiao
 * @create: 2022-02-25
 **/
@WebServlet("/context2")
public class ServletContextDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        //image/jpeg
        String filename = "a.jpg";
        String mimeType = context.getMimeType(filename);
        System.out.println(mimeType);

        String filename1 = "a.doc";
        String mimeType1 = context.getMimeType(filename1);
        System.out.println(mimeType1);

        String filename2 = "a.gif";
        String mimeType2 = context.getMimeType(filename2);
        System.out.println(mimeType2);

    }
}
