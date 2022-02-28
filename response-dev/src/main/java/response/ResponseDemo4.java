package response;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @program: Java_Web-dev
 * @description: 字节输出流
 * @author: EthanJiao
 * @create: 2022-02-25
 **/
@WebServlet(urlPatterns = "/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info = "JavaWeb开发";
        //0.设定响应头
        resp.setContentType("text/html;charset=utf-8");
        //1.获取字节输出流
        ServletOutputStream sos = resp.getOutputStream();
        //2.输出数据（将字符串转为字节数组并指定编码为UTF-8）
//        sos.write(info.getBytes(StandardCharsets.UTF_8));
        sos.write(info.getBytes());
        sos.flush();
        sos.close();
    }
}
