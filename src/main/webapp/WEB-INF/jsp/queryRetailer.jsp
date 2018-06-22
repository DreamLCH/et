<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>销售商查询</title>
<style>
	*{margin: 0; padding: 0; font-family:宋体;}
	#q_div{height:500px; width:715px; position: absolute; left:50%; margin-top:200px; margin-left:-300px;}
	#keyword{height:22px; width:100px}
	#query{width:80px; height:32px; background:#1E90FF; color:#FFFFFF; font-size:18px; margin-left:50px;}
	#table{margin-top:20px}
	#area{height:27px; width:70px;}
	#p{height:20px; width:715px; text-align:center; margin-top:10px}
</style>
</head>
<body>
	<c:import url="navigation" var="na"></c:import>
	${pageScope.na}
	<div id="q_div">
		<form method="get" action="QueryRetailerServlet">
			查询关键字：<input type="text" name="keyword" id="keyword" value="${requestScope.keyword}">&nbsp
			区域：<select name="area" id="area">
					<option ></option>
					<c:forEach var="aList" items="${requestScope.areaList }">
	             		<option >${pageScope.aList }</option>
	             	</c:forEach> 
				</select>
			<input type="submit" value="查询" id="query" name="behavior">
			<table border="0" align="center" cellspacing="1" cellpadding="0"  bgcolor="#999999" id="table">
				<tr bgcolor="#FFFFFF" height=45>
					<th width="75">编号</th>
					<th width="110">销售商名称</th>
					<th width="80">所属区域</th>
					<th width="75">负责人</th>
					<th width="120">联系电话</th>
					<th width="130">联系地址</th>
					<th width="75">操作</th>
				</tr>
				<c:forEach var="list" items="${requestScope.retailerList }">
					<tr bgcolor="#FFFFFF" height=30 align="center">
						<td>${ pageScope.list.getId()}</td>
						<td>${ pageScope.list.getName()}</td>
						<td>${ pageScope.list.getArea()}</td>
						<td>${ pageScope.list.getPrincipal()}</td>
						<td>${ pageScope.list.getPhone()}</td>
						<td>${ pageScope.list.getAddress()}</td>
						<td></td>
					</tr>
				</c:forEach>
			</table>
			<p id="p">一共${requestScope.retailerNumber}条数据   每页显示5条   共${requestScope.pagination}页  当前页第${requestScope.num}页
				<a href="QueryRetailerServlet?behavior=first">首页</a>
				<a href="QueryRetailerServlet?behavior=up">上一页</a>
				<a href="QueryRetailerServlet?behavior=next">下一页</a>
				<a href="QueryRetailerServlet?behavior=last">尾页</a>
			</p>
		</form>
	</div>
</body>
</html>