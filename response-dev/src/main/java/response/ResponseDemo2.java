package response;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @program: Java_Web-dev
 * @description:重定向2
 * @author: EthanJiao
 * @create: 2022-02-25
 **/
@WebServlet(urlPatterns = "/responseDemo2")
public class ResponseDemo2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp); //把参数送下去
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ResponseDemo2 被访问...");
//        Object msg = req.getAttribute("msg");
//        System.out.println(msg);
        ServletContext context = req.getServletContext();
        Object data = context.getAttribute("data");
        System.out.println(data);
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
