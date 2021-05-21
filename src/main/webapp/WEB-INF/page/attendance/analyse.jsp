<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>考勤分析</title>
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
    <script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>
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
          <cite>考勤分析</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="${ctx }/attendance/analyse_onday" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="demoTable">
        时间：
        <div class="layui-input-inline">
            <input type="date" id="date" name="day" value=""/>
        </div>
        <button class="layui-btn layui-btn-normal" onclick="load()">分析</button>
    </div>
    <fieldset class="layui-elem-field">
        <div class="layui-field-box">
            <div id="attendance" style="text-align:center;width: 100%;height:250px;"></div>
        </div>
    </fieldset>
</div>
</body>
<script type="text/javascript">
    //默认当前时间
    var now = new Date();
    //格式化日，如果小于9，前面补0
    var day = ("0" + now.getDate()).slice(-2);
    //格式化月，如果小于9，前面补0
    var month = ("0" + (now.getMonth() + 1)).slice(-2);
    //拼装完整日期格式
    var today = now.getFullYear() + "-" + (month) + "-" + (day);
    document.getElementById("date").value = (today);

    //or  $("#date").val(today);
    function load() {
        var myChart1 = echarts.init(document.getElementById('attendance'));
        var nameNode = $("#date").val();
        $.ajax({
            contentType: "application/json",
            type: "GET",
            url: "${ctx}/index/attendance_analyse?date=" + nameNode,
            dataType: "json",
            success: function (data1) {
                myChart1.setOption({
                    legend: {},
                    tooltip: {},
                    dataset: {
                        dimensions: ['product', '实到', '应到', '缺勤'],
                        source: data1.data
                    },
                    xAxis: {type: 'category'},
                    yAxis: {},
                    series: [
                        {type: 'bar'},
                        {type: 'bar'},
                        {type: 'bar'}
                    ]
                })
            }
        });
    }
</script>
</html>