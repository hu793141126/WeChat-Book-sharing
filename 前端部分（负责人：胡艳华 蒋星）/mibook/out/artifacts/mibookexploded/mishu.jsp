<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018-07-21
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mibook.top.model.Book" %>
<%
    String userid=request.getParameter("userid");
    ArrayList<Book> books=(ArrayList<Book>) request.getAttribute("books");
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>觅书发现</title>
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
    <script src="http://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
    <div data-role="page" id="index2">
        <div data-role="header" data-position="fixed">
            <h1>觅书发现</h1>
        </div>

        <div role="main" class="ui-content">
            <!--搜索表单-->
            <form method="post" action="demoform.asp">
                <div class="ui-field-contain">
                    <label for="search"></label>
                    <input type="search" name="search" id="search" placeholder="搜索内容...">
                </div>
            </form>
            <!--筛选排序-->
            <div data-role="controlgroup" data-type="horizontal">
                <a href="#" class="ui-btn">智能排序</a>
                <a href="#" class="ui-btn">上传日期</a>
                <a href="#" class="ui-btn">筛选</a>
            </div>
                <!--图书列表-->
            <ul data-role="listview" data-inset="true">
                <li data-icon="false">
                    <a href="#">
                        <img src="images/dulala.jpg"/>
                        <h3>杜拉拉升职记</h3>
                        <p>作者：</p>
                        <div class="ui-li-aside">
                        <img  src="images/icon_intro.png"/>
                        <p >2km</p>
                        </div>
                    </a>
                    </li>
                <li data-icon="false">
                    <a href="#">
                        <img src="images/dulala.jpg"/>
                        <h3>杜拉拉升职记</h3>
                        <p>作者：</p>
                        <div class="ui-li-aside">
                            <img  src="images/icon_intro.png"/>
                            <p >2km</p>
                        </div>
                    </a>
                </li>
                <li data-icon="false">
                    <a href="#">
                        <img src="images/dulala.jpg"/>
                        <h3>杜拉拉升职记</h3>
                        <p>作者：</p>
                        <div class="ui-li-aside">
                            <img  src="images/icon_intro.png"/>
                            <p >2km</p>
                        </div>
                    </a>
                </li>
            </ul>
        </div>

        <div data-role="footer" data-position="fixed">
        <div data-role="navbar">
            <ul>
                <li><a href="index.jsp?userid=<%=userid%>" data-icon="home">首页</a></li>
                <li><a href="MishuServlet?userid=<%=userid%>" data-icon="heart">觅书</a></li>
                <li><a href="bookshare.jsp?userid=<%=userid%>" data-icon="forward">上传</a></li>
                <li><a href="chat.jsp?userid=<%=userid%>" data-icon="comment">消息</a></li>
                <li><a href="grzx.jsp?userid=<%=userid%>" data-icon="user">个人中心</a></li>
            </ul>
        </div>
    </div>
    </div>

    <div data-role="page" id="index">
        <div data-role="header" data-position="fixed">
            <h1>图书详情</h1>
        </div>

        <div role="main" class="ui-content">
            <ul data-role="listview" data-inset="true">
                <li style="text-align: center"><h3>图书信息</h3></li>
                <li data-icon="false">
                                <img src="images/dulala.jpg" style="margin: 20px"/>
                                <h3>杜拉拉升职记</h3>
                                <p>作者：</p>
                                <p>出版社：</p>
                                <p>归还性质：</p>
                    <div class="ui-li-aside">
                                <p >标签：</p>
                                <p >价格：</p>
                    </div>
                </li>
                <li style="text-align: center"><h3>图书简介</h3></li>
                    <div style="width: 100%;">
                    <p style="word-wrap: break-word;word-break: break-all;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;响应式设计一般用于适配用户各种移动设备。 我们只需要使用一个简单的类名，jQuery Mobile 就能根据屏幕的尺寸自动调整页面内容。 响应式表格让页面内容在移动端和桌面设备上能够很好的适配。 响应式表格有两种类型： reflow(回流) 与 列切换。</p>
                    </div>

                <li style="text-align: center"><h3>书主信息</h3></li>
                <li data-icon="false">
                    <a href="#" class="ui-btn">
                    <img style="border-radius: 50%;margin: 10px" src="images/touxiang.jpg"/>
                    <h3>用户名</h3>
                    <p>性别：</p>
                    <p>个性签名:</p>
                    </a>
                </li>
            </ul>
        </div>
        <div data-role="footer" data-position="fixed">
            <div data-role="navbar">
                <ul>
                    <li><a href="#index" data-icon="comment">留言</a></li>
                    <li><a href="#" data-icon="heart">收藏</a></li>
                    <li><a href="#" data-icon="eye">借阅</a></li>
                </ul>
            </div>
        </div>
    </div>

</body>
</html>
