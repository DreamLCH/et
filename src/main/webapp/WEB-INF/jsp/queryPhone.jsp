<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>手机查询</title>
<style>
	*{margin: 0; padding: 0; font-family:宋体;}
	#q_div{height:500px; width:715px; position: absolute; left:50%; margin-top:200px; margin-left:-300px;}
	#keyword{height:22px; width:100px}
	#price1{height:22px; width:50px}
	#price2{height:22px; width:50px}
	#query{width:80px; height:32px; background:#1E90FF; color:#FFFFFF; font-size:18px; margin-left:30px; border:1px #1E90FF solid;}
	#table{margin-top:20px}
	#brand{height:27px; width:70px;}
	#p{height:20px; width:715px; text-align:center; margin-top:10px}
</style>
</head>
<body>
	<c:import url="navigation" var="na"></c:import>
	${pageScope.na}
	<div id="q_div">
		<form method="post" action="QueryPhoneServlet">
			查询关键字：<input type="text" name="keyword" id="keyword" value="${requestScope.keyword}">&nbsp
			品牌：<select name="brand" id="brand">
					<option ></option>
					<c:forEach var="list" items="${requestScope.arrayList }">
	             		<option >${list }</option>
	             	</c:forEach> 
				</select>
			&nbsp
			价格：<input type="text" name="price1" id="price1" value="${requestScope.price1}">
			- <input type="text" name="price2" id="price2" value="${requestScope.price2}">
			<input type="submit" value="查询" id="query" name="behavior">
			<table border="0" align="center" cellspacing="1" cellpadding="0"  bgcolor="#999999" id="table">
				<tr bgcolor="#FFFFFF" height=45>
					<th width="75">编号</th>
					<th width="110">手机型号</th>
					<th width="110">销售价格</th>
					<th width="110">颜色</th>
					<th width="110">尺寸/分辨率</th>
					<th width="110">生产日期</th>
					<th width="75">操作</th>
				</tr>
				<c:forEach var="list" items="${requestScope.phoneList }">
					<tr bgcolor="#FFFFFF" height=30 align="center">
						<td>${ pageScope.list.getId()}</td>
						<td>${ pageScope.list.getType()}</td>
						<td>${ pageScope.list.getPrice()}</td>
						<td>${ pageScope.list.getColour()}</td>
						<td>${ pageScope.list.getSize()}</td>
						<td>${ pageScope.list.getDate()}</td>
						<td></td>
					</tr>
				</c:forEach>
			</table>
			<p id="p">一共${requestScope.phoneNumber}条数据   每页显示5条   共${requestScope.pagination}页  当前页第${requestScope.num}页
				<a href="QueryPhoneServlet?behavior=first">首页</a>
				<a href="QueryPhoneServlet?behavior=up">上一页</a>
				<a href="QueryPhoneServlet?behavior=next">下一页</a>
				<a href="QueryPhoneServlet?behavior=last">尾页</a>
			</p>
		</form>
	</div>
</body>
</html>