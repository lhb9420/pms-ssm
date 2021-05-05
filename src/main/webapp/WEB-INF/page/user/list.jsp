<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>用户信息</title>
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
          <cite>用户信息</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="${ctx }/user/list"
       title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="demoTable" action="${ctx }/user/table">
        名字：
        <div class="layui-inline">
            <input class="layui-input" name="userName" id="userName" autocomplete="off">
        </div>
        <button class="layui-btn layui-btn-normal" data-type="reload">搜索</button>
    </div>

    <table id="user" lay-filter="test"></table>
</div>
</body>
<script>
    layui.use('table', function () {
        var table = layui.table;
        //方法级渲染
        table.render({
            elem: '#user'
            , url: '${ctx }/user/table'
            , limit: 5
            , limits: [5, 10, 20]
            , cols: [[
                {checkbox: true, fixed: true}
                , {field: 'username', title: '姓名', width: 120, sort: true}
                , {field: 'loginname', title: '登录名', width: 120, sort: true}
                , {field: 'password', title: '密码', width: 200, sort: true}
                , {field: 'create_date', title: '创建时间', width: 250, sort: true}
                , {field: 'status', title: '身份（1：普通员工 2：部门经理 3：人事部用户）', sort: true}
            ]]
            , id: 'testReload'
            , page: true
        });
        var $ = layui.$, active = {
            reload: function () {
                var nameNode = $("#userName");
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        userName: nameNode.val()
                    }
                });
            }
        };
        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');// type='reload'
            active[type] ? active[type].call(this) : '';
        });
    });

</script>
</html>