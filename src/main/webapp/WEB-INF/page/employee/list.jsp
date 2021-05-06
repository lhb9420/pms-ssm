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
          <cite>员工列表</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="${ctx }/employee/list" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="demoTable" action="${ctx }/employee/table">
        名字：
        <div class="layui-inline">
            <input class="layui-input" name="userName" id="userName" autocomplete="off">
        </div>
        <button class="layui-btn layui-btn-normal" data-type="reload">搜索</button>
    </div>

    <table id="employee" lay-filter="test"></table>
</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
    layui.use('table', function () {
        var table = layui.table;
        table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
            if (layEvent === 'del') { //删除
                layer.confirm('确定删除该员工信息吗？', function (index) {
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    $.get("${ctx}/employee/delete?id=" + data.id);//向服务端发送删除指令
                    layer.close(index);
                    //向服务端发送删除指令
                });
            } else if (layEvent === 'edit') { //编辑
                //do something
                layer.open({
                    type: 2,
                    shadeClose: true,
                    /* area: ['380px', '90%'],*/
                    area: ['600px', '480px'],
                    content: "${ctx}/employee/add?id=" + data.id,
                });

            }
        });
        //方法级渲染
        table.render({
            elem: '#employee'
            , url: '${ctx }/employee/table'
            , limit: 5
            , limits: [5, 10, 20]
            , parseDate: function (reult) {


            }
            , cols: [[
                {checkbox: true, fixed: true}
                , {field: 'name', title: '姓名', width: 80, sort: true}
                , {field: 'login_name', title: '登录名', width: 60, sort: true}
                , {field: 'password', title: '密码', width: 60, sort: true}
                , {field: 'sex', title: '性别', width: 50, sort: true}
                , {field: 'education', title: '学历', width: 60, sort: true}
                , {field: 'email', title: '邮箱', width: 170, sort: true}
                , {field: 'phone', title: '手机', sort: true}
                , {field: 'address', title: '联系地址', sort: true}
                , {
                    field: 'job', title: '职位', sort: true, templet: function (date) {
                        return date.job.name
                    }
                }
                , {
                    field: 'dept', title: '部门', width: 80, sort: true, templet: function (date) {
                        return date.dept.name
                    }
                }
                , {
                    fixed: 'right', title: '操作', width: 150, align: 'center',
                    toolbar: '#barDemo'
                }
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
</body>

</html>