<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="shortcut icon" href="${ctx}/logo.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${ctx}/css/font.css">
    <link rel="stylesheet" href="${ctx}/css/xadmin.css">
</head>
<body>
<div class="x-body layui-anim layui-anim-up">
    <blockquote class="layui-elem-quote">欢迎你：
        <span class="x-red">${sessionScope.user_session.username }</span>
        <div id="datetime">
            <script>
                setInterval("document.getElementById('datetime').innerHTML=new Date().toLocaleString();", 0);
            </script>
        </div>
    </blockquote>
    <fieldset class="layui-elem-field">
        <legend>今日考勤分析</legend>
        <div class="layui-field-box">
            <div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <div class="layui-carousel x-admin-carousel x-admin-backlog" lay-anim="" lay-indicator="inside"
                             lay-arrow="none" style="width: 100%; height: 90px;">
                            <div carousel-item="">
                                <ul class="layui-row layui-col-space10 layui-this">

                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </fieldset>
    <fieldset class="layui-elem-field">
        <legend>系统信息</legend>
        <div class="layui-field-box">
            <table class="layui-table">
                <tbody>
                <tr>
                    <th>系统版本</th>
                    <td>2.0</td>
                </tr>
                <tr>
                    <th>操作系统</th>
                    <td>Windows</td>
                </tr>
                <tr>
                    <th>服务器</th>
                    <td>Tomcat 8.0</td>
                </tr>
                <tr>
                    <th>Java版本</th>
                    <td>1.8.0</td>
                </tr>
                <tr>
                    <th>MySQL版本</th>
                    <td>8.0</td>
                </tr>
                <tr>
                    <th>开发平台</th>
                    <td>IDEA</td>
                </tr>
                </tbody>
            </table>
        </div>
    </fieldset>
</div>
<script>
    var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
</body>
</html>