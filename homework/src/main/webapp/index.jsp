<%@ page import="java.util.List" %>
<%@ page import="com.example.homework.Book" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>主页</title>
    <style>
        .container{
            width: 80%;
            margin: 0 auto;
            background-color: aquamarine;
            display: flex;
            padding: 10px 10px 10px 10px;
            flex-wrap: wrap;
        }
        .box{
            flex:0 0 20% ;
            height: 280px;
            margin: 5px 5px 5px 5px;
            background-color: cornsilk;

        }
        .box img{
            width: 90%;
            height: 70%;
        }
    </style>
</head>
<body>
<h2>欢迎你</h2>
<%
    String username = (String)session.getAttribute("username");//将username取出来
    if (username != null) {
        pageContext.setAttribute("username",username);
%>
${username}
<%
    }else{
%>
<h3> <a href="${pageContext.request.contextPath}/">去登陆</a></h3>
<%
    }
%>
<hr>
<h2>图书信息</h2>
<%
    List<Book> bookList = (List<Book>) request.getAttribute("bookList");//取出图书信息
    pageContext.setAttribute("size",bookList.size());

    %>
一共${size}本书
<div class="container">
    <%
        for (Book book : bookList){
            pageContext.setAttribute("book",book);
    %>
    <div class = "box">
        <img src = "images/${book.cover}" alt="">
        <p>${book.name}</p>
        <p>${book.name}</p>
    </div>
    <%



        }
    %>
</div>

</body>
</html>