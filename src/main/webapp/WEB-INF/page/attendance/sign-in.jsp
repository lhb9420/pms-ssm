<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>签到</title>
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
          <cite>签到</cite></a>
      </span>
</div>
<div class="x-body">
    <script>
        Date.prototype.format = function (fmt) {
            var o = {
                "y+": this.getFullYear, //年
                "M+": this.getMonth() + 1, //月份
                "d+": this.getDate(), //日
                "h+": this.getHours(), //小时
                "m+": this.getMinutes(), //分
                "s+": this.getSeconds() //秒
            };
            if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
            for (var k in o)
                if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
            return fmt;
        }
        setInterval("document.getElementById('dateTime').innerHTML = (new Date()).format('yyyy-MM-dd hh:mm:ss');", 1);
    </script>
    <div class="div-a" id="dateTime" align="center" style="font-size:30px;font-weight: bold"></div>
    <div class="div-b" align="center" style="font-size:20px;font-weight: bold;margin-top: 40px">
        <b>温馨提示：签到为上班时间前一个小时之内，签退为下班时间后一个小时之内</b>
    </div>

    <hr>
    <div style="text-align: center;margin-top: 40px">
        <div class="layui-inline">

            <table class="layui-table" align="center">
                <colgroup>
                    <col width="170">
                    <col width="170">
                    <col width="170">
                </colgroup>
                <thead>
                <tr>
                    <th>上午（9:00-12:00）</th>
                    <th>下午（14:00-18:00）</th>
                    <th>加班（20:00-22:00）</th>
                </tr>
                </thead>
                <tb>
                    <td class="td-manage">
                        <a title="签到" onclick="time_range('8:00','9:00')">
                            <i class="layui-icon">&#x1005;</i>
                        </a>
                        <a title="签退" onclick="time_range('12:00','13:00')">
                            <i class="layui-icon">&#x1007;</i>
                        </a>
                    </td>
                    <td class="td-manage">
                        <a title="签到" onclick="time_range('13:00','14:00')">
                            <i class="layui-icon">&#x1005;</i>
                        </a>
                        <a title="签退" onclick="time_range('18:00','19:00')">
                            <i class="layui-icon">&#x1007;</i>
                        </a>
                    </td>
                    <td class="td-manage">
                        <a title="签到" onclick="time_range('19:00','20:00')">
                            <i class="layui-icon">&#x1005;</i>
                        </a>
                        <a title="签退" onclick="time_range('22:00','23:00')">
                            <i class="layui-icon">&#x1007;</i>
                        </a>
                    </td>
                </tb>
            </table>
        </div>
    </div>
</div>
<script>
    //时间范围判断
    var time_range = function (beginTime, endTime) {
        var strb = beginTime.split(":");
        if (strb.length != 2) {
            return false;
        }

        var stre = endTime.split(":");
        if (stre.length != 2) {
            return false;
        }

        var b = new Date();
        var e = new Date();
        var n = new Date();

        b.setHours(strb[0]);
        b.setMinutes(strb[1]);
        e.setHours(stre[0]);
        e.setMinutes(stre[1]);

        if (n.getTime() - b.getTime() > 0 && n.getTime() - e.getTime() < 0) {
            layer.msg('签到成功!', {icon: 1, time: 1000});
            $.get("${ctx}/attendance/sign");
            return true;
        } else {
            layer.msg('签到失败!（已逾期或未到时间）', {icon: 2, time: 1000});
            return false;
        }
    }
</script>
</body>
</html>