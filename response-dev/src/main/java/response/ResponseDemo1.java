package response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @program: Java_Web-dev
 * @description:重定向1
 * @author: EthanJiao
 * @create: 2022-02-25
 **/
@WebServlet(urlPatterns = "/responseDemo1")
public class ResponseDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp); //把参数送下去
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ResponseDemo1...");
        //1.设置状态码为302（重定向）
        resp.setStatus(302);
        //通过request域来传递数据
//        req.setAttribute("msg","hello response");
//        //2.设置响应头 直接跳转到百度
//        resp.setHeader("location","/responseDemo2");
//        resp.setHeader("location","https://www.baidu.com");
        //简单的写法，重定向，可以跨域
//        resp.sendRedirect("https://www.baidu.com");
//        resp.setHeader("msq","hello");//在规范中没有的需要（alt+shift+enter）添加

        //page -> request -> session ->application 从前往后，域越来越大
        req.setAttribute("msg","hello response");
        req.getRequestDispatcher("responseDemo2").forward(req,resp);


    }
}
