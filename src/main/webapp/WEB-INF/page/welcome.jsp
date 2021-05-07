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
        <legend>部门员工统计</legend>
        <div class="layui-field-box">
            <div id="enployee_count" style="text-align:center;width: 100%;height:250px;"></div>
        </div>
    </fieldset>
    <fieldset class="layui-elem-field">
        <legend>今日考勤分析</legend>
        <div class="layui-field-box">
            <div id="attendance" style="text-align:center;width: 100%;height:250px;"></div>
        </div>
    </fieldset>
</div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('enployee_count'));
    $.ajax({
        contentType: "application/json",
        type: "GET",
        url: "${ctx}/index/employee_count",
        dataType: "json",
        success: function (data) {
            myChart.setOption({
                tooltip: {
                    trigger: 'item'
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                },
                series: [
                    {
                        name: '部门员工',
                        type: 'pie',    // 设置图表类型为饼图
                        radius: '55%',  // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
                        data: data.data,
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            })
        }
    });
</script>
<script type="text/javascript">
    var myChart1 = echarts.init(document.getElementById('attendance'));
    $.ajax({
        contentType: "application/json",
        type: "GET",
        url: "${ctx}/index/attendance_analyse",
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
</script>
</body>
</html>