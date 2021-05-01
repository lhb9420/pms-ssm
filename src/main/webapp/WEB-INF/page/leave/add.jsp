<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
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
          <cite>申请请假</cite></a>
      </span>
  </div>
    <div class="x-body">
        <form class="layui-form" method="POST" id="deptForm"  action="${ctx}/leave/add">

          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>请假时间
              </label>
              <div class="layui-input-inline">
                  <input type="date" id="date" name="leave_date" value="${leave.leave_date }" />
              </div>
          </div>
          <div class="layui-form-item layui-form-text">
                    <label for="desc" class="layui-form-label">
                     <span class="x-red">*</span> 原因
                    </label>
                    <div class="layui-input-block">
                        <textarea placeholder="请输入内容" id="content" name="reason" class="layui-textarea">${leave.reason }</textarea>
                    </div>
                </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <input type="submit" value=" 提交" class="layui-btn" lay-filter="add" lay-submit=""/>
                 
          </div>
      </form>
    </div>
    <script>
        //默认为当前时间
        var now = new Date();
        //格式化日，如果小于9，前面补0
        var day = ("0" + now.getDate()).slice(-2);
        //格式化月，如果小于9，前面补0
        var month = ("0" + (now.getMonth() + 1)).slice(-2);
        //拼装完整日期格式
        var today = now.getFullYear()+"-"+(month)+"-"+(day) ;
        document.getElementById("date").value=(today);
    </script>
  </body>

</html>