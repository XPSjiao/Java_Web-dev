package servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: Java_Web-dev
 * @description: download
 * @author: EthanJiao
 * @create: 2022-02-25
 **/
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数，文件名称
        String filename = req.getParameter("filename");
        //2.使用字节输入流加载文件到内存
        //2.1通过servletcontext找到文件服务器路径
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/img/" + filename);
        //2.2用字节流读入
        InputStream inputStream = new FileInputStream(realPath);

        //3.设置响应头的打开方式
        resp.setHeader("content-disposition","attachment;filename="+filename);

        //4.将输入流中的数据
        ServletOutputStream sos = resp.getOutputStream();

        //缓冲区
        byte[] buffer = new byte[1024 * 8];
        int len ;
        while ((len = inputStream.read(buffer)) != -1){
            sos.write(buffer,0,len);
        }
        sos.close();
        inputStream.close();

    }
}
