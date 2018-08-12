<%@ page import="com.mibook.top.model.Book" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018-07-20
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         import="com.mibook.top.model.Book,java.util.*,com.mibook.top.wx.JsSignUtil"
         language="java"
%>
<%@ page import="com.mibook.top.wx.OauthUtil" %>
<%@ page import="com.mibook.top.model.User" %>
<%@ page import="com.mibook.top.model.UserAchieve" %>

<%
    /*
    主页书籍获取测试
    Book book=(Book)request.getAttribute("book");
    */
    //通过openid获取用户信息  openid初识由php微信服务器重定向得到 之后通过在页面地址尾部加参数get得到
    String userid = request.getParameter("userid");
    //通过微信openid获取的用户信息对象

    //数据库插入用户 如果用户微信id存在则不插入，否则插入新用户
    //通过微信id获取用户对象的userID

    //初始化微信js端口的url
    Map<String, String> ret = new HashMap<String, String>();
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    String url = "http://" + request.getServerName() + ":" + request.getServerPort() + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());
    //得到微信js签名资源
    ret = JsSignUtil.sign(url);

    //初识化地址
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

    String address = request.getParameter("address");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>图书共享</title>
    <link rel="stylesheet" href="./CSS/weui.css"/>
    <link rel="stylesheet" href="./CSS/style.css"/>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
    <script src="http://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#myCarousel').carousel({interval: 3000});//每隔5秒自动轮播
        });
    </script>
</head>
<body style="height: 100%">

<div data-role="page">
    <div role="main" class="ui-content">
        <!--轮播图 -->
        <div id="myCarousel" class="carousel slide">
            <!-- 轮播（Carousel）指标 -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <!-- 轮播（Carousel）项目 -->
            <div class="carousel">
                <p>最新资讯：</p>
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="./images/banner1.png" alt="First slide" style="height: 200px">
                    </div>
                    <div class="item">
                        <img src="./images/banner2.png" alt="Second slide" style="height: 200px">
                    </div>
                    <div class="item">
                        <img src="./images/banner3.png" alt="Third slide" style="height: 200px">
                    </div>
                </div>
            </div>
        </div>
        <div>
        </div>
        <hr/>
        <!--书友功能-->
        <div>
            <div class="carousel">
                <p>亲爱的书友：</p>
                <div style="text-align: center">
                    <a href="bookshare.jsp?userid=<%=userid%>" class="ui-btn ui-btn-inline ui-shadow ui-corner-all">我要共享</a>
                    <a href="jyts.jsp?userid=<%=userid%>" class="ui-btn ui-btn-inline ui-shadow ui-corner-all">我要还书</a>
                </div>
                <br/>
                <p>注：您的每次分享都将为您的共享等级加分噢！</p>
            </div>
        </div>

        <hr/>
        <!--书圈和会友点-->
        <div>
            <div class="carousel">
                <span>附近书圈：</span>
                <a href="javascript:;" style="float: right">更多></a>

            </div>
            <br/>
            <div class="carousel" style="text-align: center;width: 100%;height: 100px">
                <a href="javascript:;" style="float: left;margin-right: 10%;width: 10%">
                    <img src="./images/icon_tabbar.png" alt="">
                    <p class="weui-tabbar__label">计算机书圈</p>
                </a>
                <a href="javascript:;" style="float: left;margin-right: 10%;width: 10%;">
                    <img src="./images/icon_tabbar.png" alt="">
                    <p class="weui-tabbar__label">文学书圈</p>
                </a>
                <a href="javascript:;" style="float: left;margin-right: 10%;width: 10%">
                    <img src="./images/icon_tabbar.png" alt="">
                    <p class="weui-tabbar__label">文学书圈</p>
                </a>
                <a href="javascript:;" style="float: left;margin-right: 10%;width: 10%">
                    <img src="./images/icon_tabbar.png" alt="">
                    <p class="weui-tabbar__label">文学书圈</p>
                </a>
                <a href="javascript:;" style="float: left;margin-right: 10%;width: 10%">
                    <img src="./images/icon_tabbar.png" alt="">
                    <p class="weui-tabbar__label">科幻书圈</p>
                </a>
            </div>

            <div class="carousel">
                <span>附近会友点：</span>
                <a href="javascript:;" style="float: right">更多></a>

            </div>
            <br/>
            <div class="carousel" style="text-align: center;width: 100%;height: 100px">
                <a href="javascript:;" style="float: left;margin-right: 10%;width: 10%">
                    <img src="./images/icon_tabbar.png" alt="">
                    <p class="weui-tabbar__label">西湖</p>
                </a>
                <a href="javascript:;" style="float: left;margin-right: 10%;width: 10%">
                    <img src="./images/icon_tabbar.png" alt="">
                    <p class="weui-tabbar__label">泰山</p>
                </a>
                <a href="javascript:;" style="float: left;margin-right: 10%;width: 10%">
                    <img src="./images/icon_tabbar.png" alt="">
                    <p class="weui-tabbar__label">雨湖</p>
                </a>
                <a href="javascript:;" style="float: left;margin-right: 10%;width: 10%">
                    <img src="./images/icon_tabbar.png" alt="">
                    <p class="weui-tabbar__label">樱花园</p>
                </a>
                <a href="javascript:;" style="float: left;margin-right: 10%;width: 10%">
                    <img src="./images/icon_tabbar.png" alt="">
                    <p class="weui-tabbar__label">东门</p>
                </a>
            </div>
        </div>

    </div>
    <!--底部导航栏 -->
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
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript">
    <%
    if(address==null){
    %>
    $(document).ready(function () {
        wx.config({
            debug: false,
            appId: '<%=ret.get("appId")%>',
            timestamp: '<%=ret.get("timestamp")%>',
            nonceStr: '<%=ret.get("nonceStr")%>',
            signature: '<%=ret.get("signature")%>',
            jsApiList: ['checkJsApi', 'getLocation']
        });//end_config
        wx.error(function (res) {
            alert("出错了：" + res.errMsg);
        });
        ;

        wx.ready(function () {
            wx.checkJsApi({
                jsApiList: ['getLocation']
            });
            //获取位置信息
            wx.getLocation({
                type: 'gcj02', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
                success: function (res) {
                    var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
                    var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
                    var speed = res.speed; // 速度，以米/每秒计
                    var accuracy = res.accuracy; // 位置精度
                    var url = "http://www.corsproxy.com/api.map.baidu.com/geocoder/v2/?ak=nR6QbTKUEKCIwagbSRbGs5kADlzsapjA&output=json&coordtype=gcjo211"
                    alert("经度:" + latitude + "纬度：" + longitude);
                    var obj = eval(res);
                    location.href = "<%=basePath%>LocationServlet?lat=" + obj.latitude + "&lng=" + obj.longitude + "&userid=<%=userid%>";
                }
            });
        });//end_ready
    });
    <%
    }else{
    %>
        alert("<%=address%>"+"<%=userid%>");
    <%
    }
    %>
</script>

</body>
</html>