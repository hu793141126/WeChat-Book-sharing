<%--
  Created by IntelliJ IDEA.
  User: huxiaohua
  Date: 2018/7/20
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.css">
    <script src="https://apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="https://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
    <style type="text/css">
        body{
            width: 100%;
            height: 100%;
        }
        .talk_con{
            width:100%;
            height: 100%;
            border:1px solid #666;
            margin:50px auto 0;
            background:#f9f9f9;
        }
        .talk_show{
            width: 100%;
            height: 100%;
            border:1px solid #666;
            background:#fff;
            margin:10px auto 0;
            overflow:auto;
        }
        .talk_input{
            width:100%;
            height: 100%;
            margin:10px auto 0;
        }
        .whotalk{
            width:80px;
            height:30px;
            float:left;
            outline:none;
        }
        .talk_word{
            width:420px;
            height:26px;
            padding:0px;
            float:left;
            margin-left:10px;
            outline:none;
            text-indent:10px;
        }
        .talk_sub{
            width:56px;
            height:30px;
            float:left;
            margin-left:10px;
        }
        .atalk{
            margin:10px;
        }
        .atalk span{
            display:inline-block;
            background:#0181cc;
            border-radius:10px;
            color:#fff;
            padding:5px 10px;
        }
        .btalk{
            margin:10px;
            text-align:right;
        }
        .btalk span{
            display:inline-block;
            background:#ef8201;
            border-radius:10px;
            color:#fff;
            padding:5px 10px;
        }
    </style>
    <script type="text/javascript">
        window.onload = function(){
            var Words = document.getElementById("words");
            var Who = document.getElementById("who");
            var TalkWords = document.getElementById("talkwords");
            var TalkSub = document.getElementById("talksub");


            TalkSub.onclick = function(){
                //定义空字符串
                var str = "";
                if(TalkWords.value == ""){
                    // 消息为空时弹窗
                    alert("消息不能为空");
                    return;
                }
                if(Who.value == 0){
                    //如果Who.value为0n那么是 A说
                    str = '<div class="atalk"><span>A说 :' + TalkWords.value +'</span></div>';

                }
                else{
                    str = '<div class="btalk"><span>B说 :' + TalkWords.value +'</span></div>' ;
                }
                Words.innerHTML = Words.innerHTML + str;
            }

        }


    </script>
</head>
<body>
<!--消息界面-->
<div data-role="page" id="page">

    <div role="main" class="ui-content" >
        <div  >
            <div id="words" >
                <div class="atalk"><span id="asay">A说：吃饭了吗？</span></div>
                <div class="btalk"><span id="bsay">B说：还没呢，你呢？</span></div>
            </div>
        </div>
    </div>


    <div data-role="footer" data-position="fixed">
            <div style="width: 100%;text-align: center;height: 100%;padding:5%">
            <a  href="#page2" style="text-decoration: none;">点此发送消息</a>
            </div>
    </div>
</div>

<!--发送界面-->
<div data-role="page" id="page2" >

    <div data-role="header" data-position="fixed">
        <div style="width: 100%;text-align: center">
        <a href="#"  style="text-decoration: none;">返回首页</a>
        <div>
    </div>

    <div role="main" class="ui-content" >
        <div>
            <select  id="who">
                <option value="0">A说：</option>
                <option value="1">B说：</option>
            </select>
        </div>
        <textarea id="talkwords"  style="resize: none;height: 100px;max-height: 100px;overflow:scroll;" maxlength="50"></textarea>
        <a  href="#page" class="ui-btn ui-btn-inline ui-corner-all ui-shadow " style="width: 36%;margin-top: 10px" id="talksub">发送消息</a>
    </div>
</div>
</body>
</html>
