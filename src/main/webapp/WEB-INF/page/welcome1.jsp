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
    <link rel="stylesheet" href="${ctx}/lib/layui/css/layui.css" media="all">
    <script type="text/javascript" src="${ctx}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>

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
        <legend>公告</legend>
    </fieldset>
    <table class="layui-hide" id="LAY_table_notice" lay-filter="overtime"></table>
</div>
<script type="text/javascript">
    layui.use('table', function () {
        var table = layui.table;
        //方法级渲染
        table.render({
            elem: '#LAY_table_notice'
            , url: '${ctx }/notice/table'
            , cols: [[
                {field: 'title', title: '标题', sort: true}
                , {field: 'content', title: '内容', sort: true}
                , {field: 'create_date', title: '发布时间', sort: true}
                , {field: 'name', title: '发布用户', sort: true}
            ]]
        });
    });
</script>

</body>
</html>