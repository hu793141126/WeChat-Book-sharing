<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018-07-23
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         import="java.util.*,com.mibook.top.model.Book"
         language="java" %>
<%@ page import="com.mibook.top.model.User" %>
<%@ page import="com.mibook.top.wx.OauthUtil" %>
<%
    Book book = (Book) request.getAttribute("book");
    String userid=request.getParameter("userid");
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="referrer" content="no-referrer">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>上传详情</title>
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
    <script src="http://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
<div data-role="page" id="index2">
    <div data-role="header" data-position="fixed">
        <h1>上传详情</h1>
    </div>
    <div role="main" class="ui-content">

        <ul data-role="listview" data-inset="true">
            <li style="text-align: center"><h3>图书信息</h3></li>
            <li data-icon="false">
                <img src="<%=book.getBookPicture()%>" style="margin: 20px"/>
                <h3><%=book.getBookName()%>
                </h3>
                <p>作者：<%=book.getBookConcern()%>
                </p>
                <p>出版社：<%=book.getBookConcern()%>
                </p>
                <p>出版时间：<%=book.getBookData()%>
                </p>
            </li>
            <li style="text-align: center"><h3>书籍简介</h3></li>
            <textarea disabled="disabled"><%=book.getBookAbstract()%></textarea>
            <form method="get" action="ScxqServlet?userid=<%=userid%>">
            <li style="text-align: center"><h3>个人阅读心得</h3></li>
            <textarea name="booknote"><%=book.getBookisbn()%></textarea>
            <li style="text-align: center"><h3>分享类型</h3></li>
            <li>
                    <input  type="hidden"  name="bookisbn" value="<%=book.getBookisbn()%>">
                    <fieldset data-role="controlgroup">
                        <label for="male">需要归还</label>
                        <input type="radio" name="need" id="male" value="需要归还" checked>
                        <label for="female">无需归还</label>
                        <input type="radio" name="noneed" id="female" value="无需归还">
                    </fieldset>
            </li>
            <li style="text-align: center">
                <input type="submit" data-inline="true" value="确认分享">
            </li>
            </form>
        </ul>
    </div>
    <div data-role="footer" data-position="fixed">

    </div>
</div>
</body>
</html>
