<%@ page import="com.bo.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: 焦恒鑫
  Date: 2022/2/26
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">

</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    pageContext.setAttribute("user",user);
%>
<%--顶部区域，引入共用的top.jsp页面--%>
<div id="top">
    <jsp:include page="top.jsp"/>
</div>

<%--浏览区域--%>
<div class="explore">
    <ul class="nav">
        <li>首页</li>
        <li>浏览发现</li>
        <li>话题广场</li>
        <li>我的豆瓣</li>

    </ul>
    <label>
        <input type="text" placeholder="搜索你感兴趣的内容和人" class="search-input">
    </label>
</div>
<br>

<%--页面主体区域--%>
<div class="container">
    <div class="col-8">
        <div class="info">
            <img src="images/${user.avatar}" alt="" class="profile">
            <h2>${user.nickname}</h2>
        </div>
        <br>
        <div class="item">
            <ul class="nav">
                <li>我的日记</li>
            </ul>
            <p>在豆瓣上写日记，记录自己的生活、想法。</p>
        </div>
        <div class="item">
            <ul class="nav">
                <li>我的相册</li>
            </ul>
            <p>可以有自己的相册来存照片了</p>
        </div>
        <div class="item">
            <ul class="nav">
                <li>我读</li>
            </ul>
            <p>5本想读</p>
        </div>
        <div class="item">
            <ul class="nav">
                <li>留言板</li>
            </ul>
           <label>
               <textarea cols="80" rows="5"></textarea>
           </label>
            <div>
                <input type="button" value="留言">
            </div>
        </div>
    </div>

<%--    右侧1/3区域--%>
    <div class="col-4">
        <div class="top">
            <img src="images/${user.avatar}" alt="">
            <div>
                <p>常居：${user.address}</p>
                <p>账号：${user.account}</p>
                <p>${user.joinDate}加入/p>
            </div>
        </div>
        <br>
        <div class="item">
            <ul class="nav">
                <li>我的广播。。。。。。（全部）</li>
            </ul>
            <br>
            <div class="read">
                <p><a href="">${user.nickname}</a>想读
                    <a href="">做自己想做的</a>
                </p>
                <p style="color: #c8c8c8;">2022年2月22日</p>
            </div>
            <div class="read">
                <p><a href="">${user.nickname}</a>想读
                    <a href="">做自己想做的</a>
                </p>
                <p style="color: #c8c8c8;">2022年2月22日</p>
            </div>
            <div class="read">
                <p><a href="">${user.nickname}</a>想读
                    <a href="">做自己想做的</a>
                </p>
                <p style="color: #c8c8c8;">2022年2月22日</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
