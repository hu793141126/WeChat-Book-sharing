<%--
  Created by IntelliJ IDEA.
  User: huxiaohua
  Date: 2018/7/25
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="com.mibook.top.wx.*,java.util.*,javax.servlet.http.HttpSession"
%>
<%
    Map<String, String> ret = new HashMap<String, String>();
    HttpServletRequest httpRequest = (HttpServletRequest)request;
    String url="http://"+request.getServerName()+":"+request.getServerPort()+httpRequest.getContextPath()+httpRequest.getServletPath()+"?"+(httpRequest.getQueryString());
    ret = JsSignUtil.sign(url);
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0,viewport-fit=cover">
    <title>图书共享</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="CSS/jssdkcss.css">
</head>
<body>
<!--
<div style=" position:absolute;float: none; width:100%; height:40%;margin: auto;top: 0;bottom: 0;left: 0;right: 0;text-align: center">
    <div style="float: left;margin-left: 10%;width: 40%;height: 100%">
        <a href="" id="scanQRCode1">
            <img src="images/saoma.png"  style="width: 38%;height: 30%;">
            <p>扫码分享</p>
        </a>
    </div>
    <div style="float: right;margin-right: 10%;width: 40%;height: 100%">
        <a href="">
            <img src="images/hand.png" id="handshare" style="width: 38%;height: 30%;">
            <p>手动上传</p>
        </a>
    </div>
</div>
<div style="position: fixed;bottom: 0;margin-bottom: 8%;margin-left: 45%">
    <a href="index.jsp" style="text-align:center;">
        <img src="images/back.png" style="text-align:center;width: 15%;height:10%">
    </a>
</div>
-->
<h3 id="menu-scan">微信扫一扫</h3>
<span class="desc">调起微信扫一扫接口</span>
<a class="btn btn_primary" id="scanQRCode0"> <img src="images/saoma.png" id="scanQRCode1" style="width: 38%;height: 30%;">
    <p>扫码分享</p></a>
<div style="float: right;margin-right: 10%;width: 40%;height: 100%">
<a class="btn btn_primary" id="scanQRCode1"> <img src="images/hand.png" id="handshare" style="width: 38%;height: 30%;">
    <p>手动上传</p></a>
</div>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script>
    wx.config({
        debug: false,
        appId: '<%=ret.get("appId")%>',
        timestamp: '<%=ret.get("timestamp")%>',
        nonceStr: '<%=ret.get("nonceStr")%>',
        signature: '<%=ret.get("signature")%>',
        jsApiList: [
            'checkJsApi',
            'scanQRCode'
        ]
    });
</script>
<script>
    // 1 判断当前版本是否支持指定 JS 接口，支持批量判断
    wx.checkJsApi({
        jsApiList: [
            'scanQRCode'
        ],
        success: function (res) {
            alert(JSON.stringify(res));
        }
    });
    // 9 微信原生接口
    // 9.1.1 扫描二维码并返回结果
    document.querySelector('#scanQRCode0').onclick = function () {
        wx.scanQRCode();
    };
    // 9.1.2 扫描二维码并返回结果
    document.querySelector('#scanQRCode1').onclick = function () {
        wx.scanQRCode({
            needResult: 1,
            desc: 'scanQRCode desc',
            success: function (res) {
                alert(JSON.stringify(res));
            }
        });
    };

</script>
</body>
</html>
