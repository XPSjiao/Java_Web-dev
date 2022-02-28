<%@ page import="com.bo.entity.Book" %><%--
  Created by IntelliJ IDEA.
  User: 焦恒鑫
  Date: 2022/2/24
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书详情页面</title>
    <link rel="stylesheet" href="{pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body>
<%
    Book book = (Book) request.getAttribute("book");
    pageContext.setAttribute("book",book);
%>
<div id="top">
    <jsp:include page="top.jsp"/>
</div>

<div id="search">
    <h2>读书时刻</h2>
    <input type="text" placeholder="书名、作者、ISBN" class="search-input">
    <div class="search-btn">
        <img src="${pageContext.request.contextPath}/images/search.png" alt="">
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-8">
            <h3>${book.name}</h3>
            <hr>
            <div class="col-6">
                <img src="images${book.cover}" alt="">

            </div>
            <div class="col-4">
                <p>${book.author}</p>
            </div>
        </div>
    </div>
    <div class="col-4">
        <h3>热门标签</h3>
        <hr>
    </div>
</div>
</body>
</html>
