<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018-07-24
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String userid=request.getParameter("userid");
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>分享图书</title>
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
    <script src="http://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
<div data-role="page" id="index2">
    <div data-role="header" data-position="fixed">
        <h1>手动分享</h1>
    </div>
    <div role="main" class="ui-content">
        <form method="get" action="HandShareServlet?userid=<%=userid%>">
            <div class="ui-field-contain">
                <label for="isbn">ISBN码：</label>
                <input type="text" name="handisbn" id="isbn"placeholder="请输入书本后面的ISBN码"/>
            </div>
            <input type="submit" data-inline="true" value="上传">
        </form>

    </div>
    <div data-role="footer" data-position="fixed">
    </div>
</div>
</body>
</html>
