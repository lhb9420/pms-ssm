<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>考勤列表</title>
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
          <cite>考勤信息</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="${ctx }/attendance/list" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="demoTable">
        时间：
        <div class="layui-input-inline">
            <input type="date" id="date" name="day"/>
        </div>
        员工姓名：
        <div class="layui-inline">
            <input class="layui-input" name="name" id="name" autocomplete="off">
        </div>
        <button class="layui-btn layui-btn-normal" data-type="reload">搜索</button>
    </div>

    <table class="layui-hide" id="LAY_table_user" lay-filter="attendance"></table>
</div>
</body>
<script>
    layui.use('table', function () {
        var table = layui.table;
        //方法级渲染
        table.render({
            elem: '#LAY_table_user'
            , url: '${ctx }/attendance/table'
            , limit: 5
            , limits: [5, 10, 20]
            , cols: [[
                {field: 'name', title: '姓名', sort: true}
                , {field: 'day', title: '时间', sort: true}
                , {field: 'record1', title: '上午上班时间', sort: true}
                , {field: 'record2', title: '上午下班时间', sort: true}
                , {field: 'record3', title: '下午上班时间', sort: true}
                , {field: 'record4', title: '下午下班时间', sort: true}
            ]]
            , id: 'testReload'
            , page: true
        });
        var $ = layui.$, active = {
            reload: function () {
                var idNode = $('#date');
                var name = $('#name');
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        day: idNode.val(),
                        name: name.val()
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