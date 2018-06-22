<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<!-- 外部引入文件所需代码 -->
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<base href="<%=basePath%>">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/bootstrap-table/bootstrap-table.css">
<link rel="stylesheet" href="assets/examples.css">
<script src="assets/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/bootstrap-table/bootstrap-table.js"></script>
<script src="assets/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

<!-- 引入ajax.js文件，里面封装了函数 -->
<script src="JS/ajax.js"></script>
<style>
* {
	margin: 0;
	padding: 0;
}

#navigation_div {
	width: 350px;
	height: 550px;
	margin: -275px 0;
	position: absolute;
	top: 50%;
}

#navigation_div ul {
	list-style: none;
}

#navigation_div li {
	width: 180px;
	height: 30px;
	text-align: center;
	line-height: 30px;
	margin: 0 85px;
	border-radius: 25px;
	box-shadow: 1px 1px 1px #333333;
}

#navigation_div a {
	text-decoration: none;
	color: #000;
}

.head {
	height: 40px;
	line-height: 40px;
	margin-top: 5px;
	background: #1E90FF;
	color: #FFFFFF;
	border-radius: 25px;
}

.lis:after {
	content: "";
	background: red;
	width: 180px;
	height: 30px;
	display: none;
	margin-top: -30px;
	box-shadow: 1px 1px 1px #333333;
	border-radius: 25px;
	background: #87CEEB;
	color: #FFFFFF;
}

.lis:hover:after {
	display: block;
}

#Chinese {
	width: 80px;
	height: 30px;
	background: #1E90FF;
	text-align: center;
	line-height: 30px;
	font-weight: 600;
	color: #FFF;
	position: absolute;
	left: 100px;
	top: -100px;
	box-shadow: 1px 1px 1px #333333;
}

#English {
	width: 80px;
	height: 30px;
	background: #228B22;
	text-align: center;
	line-height: 30px;
	font-weight: 600;
	color: #FFF;
	position: absolute;
	left: 180px;
	top: -100px;
	box-shadow: 1px 1px 1px #333333;
}
</style>
<div id="navigation_div">
	<a href="/mid?locale=zh_CN"><div id="Chinese">中文</div></a> <a
		href="/mid?locale=en_US"><div id="English">English</div></a>
	<ul>
		<li class="head"><s:message code="phoneManage"></s:message></li>
		<a href="/jsp/add/phone"><li class="lis"><s:message
					code="phoneAdd"></s:message></li></a>
		<a href="/query/phone"><li class="lis"><s:message
					code="phoneQuery"></s:message></li></a>
	</ul>
	<ul>
		<li class="head"><s:message code="retailerManage"></s:message></li>
		<a href="/jsp/add/retailer"><li class="lis"><s:message
					code="retailerAdd"></s:message></li></a>
		<a href="/query/retailer"><li class="lis"><s:message
					code="retailerQuery"></s:message></li></a>
	</ul>
	<ul>
		<li class="head"><s:message code="sellManage"></s:message></li>
		<a href="/query/addSellDate"><li class="lis"><s:message
					code="sellAdd"></s:message></li></a>
		<a href="/query/sell"><li class="lis"><s:message
					code="sellQuery"></s:message></li></a>
	</ul>
	<ul>
		<li class="head"><s:message code="sellStatistics"></s:message></li>
		<a href="/brandStatistics"><li class="lis"><s:message
					code="brandStatistics"></s:message></li></a>
		<a href="/yearStatistics"><li class="lis"><s:message
					code="monthStatistics"></s:message></li></a>
		<a href="/retailerStatistics"><li class="lis"><s:message
					code="retailerStatistics"></s:message></li></a>
		<a href="/areaStatistics"><li class="lis"><s:message
					code="areaStatistics"></s:message></li></a>
	</ul>
</div>