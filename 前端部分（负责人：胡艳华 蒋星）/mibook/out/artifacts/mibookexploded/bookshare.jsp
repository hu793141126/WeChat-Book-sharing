<%--
  Created by IntelliJ IDEA.
  User: huxiaohua
  Date: 2018/7/20
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         import="com.mibook.top.wx.*,java.util.*,javax.servlet.http.HttpSession"
%>
<%@ page import="com.mibook.top.model.User" %>
<%
    //初始化用户信息
    String userid=request.getParameter("userid");
    String successflag=null;
    if(request.getParameter("successflag")!=null){
        successflag=request.getParameter("successflag");
    }
    //初始化微信js端口的url
    Map<String, String> ret = new HashMap<String, String>();
    HttpServletRequest httpRequest = (HttpServletRequest)request;
    String url="http://"+request.getServerName()+":"+request.getServerPort()+httpRequest.getContextPath()+httpRequest.getServletPath()+"?"+(httpRequest.getQueryString());
    //得到微信js签名资源
    ret = JsSignUtil.sign(url);
    //初识化手动上传地址
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0,viewport-fit=cover">
    <title>图书共享</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
    <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
<% if("yes".equals(successflag)){ %>
<script>
    alert("图书上传成功");
</script>
<%}%>
<div style=" position:absolute;float: none; width:100%; height:40%;margin: auto;top: 0;bottom: 0;left: 0;right: 0;text-align: center">
    <div style="float: left;margin-left: 10%;width: 40%;height: 100%">
        <a href="javascript:void(0)" id="scanQRCode1">
            <img src="images/saoma.png"  style="width: 38%;height: 30%;">
            <p>扫码分享</p>
        </a>
    </div>
    <div style="float: right;margin-right: 10%;width: 40%;height: 100%">
        <a  href="fxts.jsp?userid=<%=userid%>" id="handshare">
            <img src="images/hand.png"  style="width: 38%;height: 30%;">
            <p>手动上传</p>
        </a>
    </div>
</div>
<div style="position: fixed;bottom: 0;margin-bottom: 8%;margin-left: 45%">
    <a href="index.jsp?userid=<%=userid%>" style="text-align:center;">
        <img src="images/back.png" style="text-align:center;width: 15%;height:10%">
    </a>
</div>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript">
    document.querySelector('#scanQRCode1').onclick = function () {
        wx.config({
            debug: false,
            appId: '<%=ret.get("appId")%>',
            timestamp: '<%=ret.get("timestamp")%>',
            nonceStr: '<%=ret.get("nonceStr")%>',
            signature: '<%=ret.get("signature")%>',
            jsApiList: ['checkJsApi', 'scanQRCode']
        });//end_config
        wx.error(function (res) {
            alert("出错了：" + res.errMsg);
        });;

        wx.ready(function () {
            wx.checkJsApi({
                jsApiList: ['scanQRCode'],
                success: function (res) {
                    if (res.checkResult.scanQRCode != true) {
                        alert('抱歉，当前客户端版本不支持扫一扫');
                    }
                },
            });
            //扫描二维码
        });//end_ready

            wx.scanQRCode({
                needResult: 1,
                desc: 'scanQRCode desc',
                success: function (res) {

                    var obj=eval(res);
                    location.href="<%=basePath%>AjaxurlServlet?isbn="+obj.resultStr+"&userid=<%=userid%>";
                }
            });
        };//end_document_scanQRCode
</script>
</body>
</html>
