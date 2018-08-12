<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018-07-24
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>附近书圈</title>
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
    <script src="http://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
<div data-role="page" id="index">
    <div data-role="header" data-position="fixed">
        <h1>附近书圈</h1>
    </div>
    <div role="main" class="ui-content">
        <ul data-role="listview" data-inset="true">
            <li >
                <a href="#index2">
                    <img style="border-radius: 50%;" src="images/touxiang.jpg"/>
                    <h3>书圈名</h3>
                    <p>44444444444444444444444444444</p>
                </a>
            </li>
        </ul>
    </div>
    <div data-role="footer" data-position="fixed">
    </div>
</div>
<div data-role="page" id="index2">
    <div data-role="header" data-position="fixed">
        <h1>书圈主页</h1>
    </div>
    <div role="main" class="ui-content">
        <ul data-role="listview" data-inset="true">
            <li style="background-color: #EBEBEB">
                    <img style="border-radius: 50%;" src="images/touxiang.jpg"/>
                    <h3>书圈名</h3>
                    <p>圈主：</p>
            </li>
        </ul>
        <div>
        <h3 style="text-align: center">图书简介</h3>
        <div class="ui-shadow ui-corner-all" style="width: 100%;background-color: #EBEBEB">
            <p style="word-wrap: break-word;word-break: break-all;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;响应式设计一般用于适配用户各种移动设备。 我们只需要使用一个简单的类名，jQuery Mobile 就能根据屏幕的尺寸自动调整页面内容。 响应式表格让页面内容在移动端和桌面设备上能够很好的适配。 响应式表格有两种类型： reflow(回流) 与 列切换。</p>
        </div>
        </div>
        <ul data-role="listview" data-inset="true">
            <li >
                <h6 style="text-align: center">书圈成员</h6>
                <a href="">
                    <div>
                        <img class="ui-btn-inline " style="border-radius: 50%;margin: 10px" src="images/icon_tabbar.png"/>
                        <img class="ui-btn-inline " style="border-radius: 50%;margin: 10px" src="images/icon_tabbar.png"/>
                        <img class="ui-btn-inline " style="border-radius: 50%;margin: 10px" src="images/icon_tabbar.png"/>
                    </div>
                </a>
            </li>
            <li >
                <h6 style="text-align: center">书圈书籍</h6>
                <a href="">
                    <div>
                        <img class="ui-btn-inline " style="width: 62px;height: 80px;margin: 10px" src="images/dulala.jpg"/>
                        <img class="ui-btn-inline " style="width: 62px;height: 80px;margin: 10px" src="images/dulala.jpg"/>
                        <img class="ui-btn-inline " style="width: 62px;height: 80px;margin: 10px" src="images/dulala.jpg"/>
                    </div>
                </a>
            </li>
        </ul>
    </div>
    <div data-role="footer" data-position="fixed">
        <div data-role="navbar">
            <ul>
                <li>
                    <a href="#index" data-icon="plus" style="background-color: #EBEBEB">加入书圈</a>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
