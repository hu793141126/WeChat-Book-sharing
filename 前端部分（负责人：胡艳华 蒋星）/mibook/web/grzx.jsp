<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018-07-23
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.mibook.top.model.User" %>
<%@ page import="com.mibook.top.wx.OauthUtil" %>
<%@ page import="com.mibook.top.model.UserAchieve" %>
<%
    String userid=request.getParameter("userid");
    User user=UserAchieve.getUserbyid(userid);

%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>个人中心</title>
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
    <script src="http://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>
<style>
    *{
        margin: 0px;
        padding: 0px;
    }
</style>
<body>
<div data-role="page" id="index2">
    <div data-role="header" data-position="fixed">
        <h1>个人中心</h1>
    </div>
    <div role="main" class="ui-content">
        <ul data-role="listview" data-inset="true">
            <li >
                <a href="#">
                    <img style="border-radius: 50%;margin: 10px" src="<%=user.getUserHP()%>"/>
                    <h3><%=user.getUserName()%></h3>
                    <p><%=user.getUserSex()%></p>
                    <p><%=user.getUserSgin()%></p>
                </a>
            </li>
        </ul>
        <div class="ui-shadow ui-corner-all" style="text-align: center;">
            <a href="#anylink"  class="ui-btn ui-icon-search ui-btn-icon-top ui-btn-inline ui-mini " style="border: 0px">我的分享</a>
            <a href="#anylink" class="ui-btn ui-icon-search ui-btn-icon-top ui-btn-inline ui-mini "style="border: 0px">我的借阅</a>
            <a href="#anylink" class="ui-btn ui-icon-search ui-btn-icon-top ui-btn-inline ui-mini "style="border: 0px">诚信值</a>
            <a href="#anylink" class="ui-btn ui-icon-location ui-btn-icon-top ui-btn-inline ui-mini "style="border: 0px">我的地址</a>
            <a href="#anylink" class="ui-btn ui-icon-search ui-icon-heart ui-btn-icon-top ui-btn-inline ui-mini  "style="border: 0px">我的收藏</a>
        </div>
        <ul data-role="listview" data-inset="true">
            <li >
                <h6 style="text-align: center">我管理的书圈：</h6>
                <a href="">
                    <div>
                        <img class="ui-btn-inline " style="border-radius: 50%;margin: 10px" src="images/icon_tabbar.png"/>
                        <img class="ui-btn-inline " style="border-radius: 50%;margin: 10px" src="images/icon_tabbar.png"/>
                        <img class="ui-btn-inline " style="border-radius: 50%;margin: 10px" src="images/icon_tabbar.png"/>
                    </div>
                </a>
            </li>
        </ul>
        <ul data-role="listview" data-inset="true">
            <li >
                <h6 style="text-align: center">我加入的书圈：</h6>
                <a href="">
                    <div>
                        <img class="ui-btn-inline " style="border-radius: 50%;margin: 10px" src="images/icon_tabbar.png"/>
                        <img class="ui-btn-inline " style="border-radius: 50%;margin: 10px" src="images/icon_tabbar.png"/>
                        <img class="ui-btn-inline " style="border-radius: 50%;margin: 10px" src="images/icon_tabbar.png"/>
                    </div>
                </a>
            </li>
        </ul>
    </div>
    <div data-role="footer" data-position="fixed">
    </div>
</div>
</body>
</html>
