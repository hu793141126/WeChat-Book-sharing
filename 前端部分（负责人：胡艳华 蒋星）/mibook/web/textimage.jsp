<%--
  Created by IntelliJ IDEA.
  User: huxiaohua
  Date: 2018/7/27
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
</head>
<body>
<script>
    var url="http://api.map.baidu.com/geocoder/v2/?ak=nR6QbTKUEKCIwagbSRbGs5kADlzsapjA&output=json&coordtype=gcjo211&location=22.539968,113.954980"

    $(function($) {

        $.ajax(url, {
            data: {},
            dataType: 'jsonp',
            crossDomain: true,
            success: function (data) {
                if (data && data.resultcode == '200') {
                    alert(data.formatted_address);
                }
            }
        })
    });
</script>
</body>
</html>
