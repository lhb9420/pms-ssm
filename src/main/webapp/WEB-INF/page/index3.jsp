<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台登录</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <link rel="shortcut icon" href="${ctx}/logo.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${ctx}/css/font.css">
    <link rel="stylesheet" href="${ctx}/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="${ctx}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/js/xadmin.js"></script>

</head>
<body>
<!-- 顶部开始 -->
<div class="container">
    <div class="logo"><a href="./index3.html">人事管理系统</a></div>
    <div class="left_open">
        <i title="展开左侧栏" class="iconfont">&#xe699;</i>
    </div>

    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:">${sessionScope.user_session.username }</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a onclick="x_admin_show('个人信息','${ctx }/user/myupdate')">个人信息</a></dd>
                <dd><a href="${ctx}/user/logout">退出</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item to-index"><a>欢迎登录</a></li>
    </ul>

</div>
<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">
            <li>
                <a href="javascript:">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite>用户管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx }/user/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>用户列表</cite>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:">
                    <i class="iconfont">&#xe723;</i>
                    <cite>部门信息管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx }/dept/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>部门列表</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="${ctx }/dept/add">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>添加部门</cite>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:">
                    <i class="iconfont">&#xe723;</i>
                    <cite>职位管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx }/job/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>职位列表</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="${ctx }/job/add">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>添加职位</cite>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:">
                    <i class="iconfont">&#xe726;</i>
                    <cite>员工信息管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx }/employee/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>员工列表</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="${ctx }/employee/add">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>添加员工</cite>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:">
                    <i class="iconfont">&#xe6b4;</i>
                    <cite>考勤签到管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx }/attendance/sign-in">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>签到</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="${ctx }/attendance/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>考勤记录</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="${ctx }/attendance/analyse_onday">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>考勤分析</cite>
                        </a>
                    </li>
                </ul>
            </li>
            <li class="open">
                <a href="javascript:">
                    <i class="iconfont">&#xe726;</i>
                    <cite>加班管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx }/overtime/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>加班信息</cite>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:">
                    <i class="iconfont">&#xe6ce;</i>
                    <cite>工资管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx }/salary/calculate">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>工资核算</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="${ctx }/salary/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>工资信息</cite>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:">
                    <i class="iconfont">&#xe6b4;</i>
                    <cite>请假审核管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx }/leave/add">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>申请请假</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="${ctx }/leave/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>请假管理</cite>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:">
                    <i class="iconfont">&#xe6ce;</i>
                    <cite>公告管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx }/notice/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>公告查询</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="${ctx }/notice/add">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>添加公告</cite>
                        </a>
                    </li >
                </ul>
            </li>
        </ul>
    </div>
</div>
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='${ctx}/welcome3' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
        </div>
    </div>
</div>
<div class="page-content-bg"></div>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->
<!-- 底部开始 -->
<div class="footer">
    <div class="copyright">天行健，君子以自强不息。</div>
</div>
<!-- 底部结束 -->

</body>
</html>