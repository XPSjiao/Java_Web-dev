package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * 获取文件的真实路径（服务器）
 */
@WebServlet(urlPatterns = "/path")
public class ServletContextDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1.得到ServletContext对象
        ServletContext context = this.getServletContext();
        //2.web目录资源访问
        String bPath = context.getRealPath("/b");
        System.out.println(bPath);
        //3.web-inf目录下的资源访问
        String cPath = context.getRealPath("/WEB-INF/c.txt");
        System.out.println(cPath);

        //4.src目录或子目录下的资源访问
        String aPath = context.getRealPath("WEB-INF/classes/servlet/a.txt");
        System.out.println(aPath);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
