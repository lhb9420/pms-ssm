<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>员工列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="shortcut icon" href="${ctx}/logo.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${ctx}/css/font.css">
    <link rel="stylesheet" href="${ctx}/css/xadmin.css">
    <link rel="stylesheet" href="${ctx}/lib/layui/css/layui.css" media="all">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a>
          <cite>工资信息</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="${ctx }/salary/list1" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="demoTable" action="${ctx }/salary/table">
    </div>
    <table id="salary" lay-filter="test"></table>

</div>
<script>
    layui.use('table', function () {
        var table = layui.table;
        //方法级渲染
        table.render({
            elem: '#salary'
            , url: '${ctx }/salary/table1'
            , limit: 5
            , limits: [5, 10, 20]
            , cols: [[
                {checkbox: true, fixed: true}
                , {field: 'name', title: '姓名', sort: true}
                , {field: 'month', title: '月份', sort: true}
                , {field: 'base_salary', title: '基本工资', sort: true}
                , {field: 'overtime_salary', title: '加班工资', sort: true}
                , {field: 'bonus', title: '奖金', sort: true}
                , {field: 'total', title: '总额', sort: true}
            ]]
            , id: 'testReload'
            , page: true
        });
        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');// type='reload'
            active[type] ? active[type].call(this) : '';
        });
    });

</script>
<script>var _hmt = _hmt || [];
(function () {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>
</body>

</html>