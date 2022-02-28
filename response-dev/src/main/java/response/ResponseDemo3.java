package response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: Java_Web-dev
 * @description:Response对象练习，向客户端返回字符数据
 * @author: EthanJiao
 * @create: 2022-02-25
 **/
@WebServlet(urlPatterns = "/responseDemo3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info = "JavaWeb开发";
        //resp.setCharacterEncoding("UTF-8");//并不能解决乱码问题
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(info);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req,resp);
    }
}
