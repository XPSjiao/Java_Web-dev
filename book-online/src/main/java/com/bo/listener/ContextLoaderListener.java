package com.bo.listener;

import com.bo.entity.Book;
import com.bo.entity.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Java_Web-dev
 * @description: 监听器
 * @author: EthanJiao
 * @create: 2022-02-24
 **/
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    /**
     * @param sce
     *
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //tomcat启动
        System.out.println("容器启动");
        //创建并生成用户数据列表
        List<User> userList = new ArrayList<>(3);
        User[] users ={
                new User(1,"aaa@qq.com","123456","笑笑","user1.jpg","江苏苏州", LocalDate.of(2022,2,21)),
                new User(2,"bbb@qq.com","123456","小一","user2.jpg","江苏南京", LocalDate.of(2022,2,22)),
                new User(3,"ccc@qq.com","123456","豆豆","user3.jpg","江苏南通", LocalDate.of(2022,2,21)),
        };
        userList = Arrays.asList(users);

        //创建并生成图书数据列表
        List<Book> bookList = new ArrayList<>(10);
        Book[] books ={
                new Book(1,"摆脱不安：告别过度依赖","book1.jpg","[日] 加藤谛三"),
                new Book(2,"关于人生，莎士比亚的神回复","book2.jpg","林楸燕 倪志昇"),
                new Book(3,"社会心理学","book3.jpg","戴维·迈尔斯"),
                new Book(4,"登天的感觉：我在哈佛大学做心理咨询","book4.jpg","岳晓东"),
                new Book(5,"红书","book5.jpg","[瑞士] 荣格 C. G. JUNG "),
                new Book(6,"摆脱不安：告别过度依赖","book1.jpg","[日] 加藤谛三"),
                new Book(7,"关于人生，莎士比亚的神回复","book2.jpg","林楸燕 倪志昇"),
                new Book(8,"社会心理学","book3.jpg","戴维·迈尔斯"),
                new Book(9,"登天的感觉：我在哈佛大学做心理咨询","book4.jpg","岳晓东"),
                new Book(10,"红书","book5.jpg","[瑞士] 荣格 C. G. JUNG ")
        };
        bookList = Arrays.asList(books);

        //获得全局变量
        ServletContext servletContext = sce.getServletContext();
        //设置全局变量属性，将用户和图书列表数据计入，整个应用可以共享
        servletContext.setAttribute("userList",userList);
        servletContext.setAttribute("bookList",bookList);

    }
    /*
    销毁方法
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //tomcat停止
        System.out.println("容器销毁");
    }
}
