<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>销售查询</title>
<style>
	*{margin: 0; padding: 0; font-family:宋体;}
	#q_div{height:500px; width:715px; position: absolute; left:50%; margin-top:200px; margin-left:-300px;}
	#retailer{height:27px; width:100px}
	#date{height:27px; width:70px}
	#query{width:80px; height:32px; background:#1E90FF; color:#FFFFFF; font-size:18px; margin-left:30px; border:2px #1E90FF solid;}
	#table{margin-top:20px}
	#brand{height:27px; width:70px;}
	#p{height:20px; width:715px; text-align:center; margin-top:10px}
</style>
</head>
<body>
	<c:import url="navigation" var="na"></c:import>
	${pageScope.na}
	<div id="q_div">
		<form method="post" action="QuerySellServlet">
			销售商：<select name="retailer" id="retailer">
					<option ></option>
					<c:forEach var="retailerName" items="${requestScope.retailerName }">
	             		<option >${retailerName }</option>
	             	</c:forEach> 
				</select>&nbsp
			品牌：<select name="brand" id="brand">
					<option ></option>
					<c:forEach var="brand" items="${requestScope.phoneBrand }">
	             		<option >${brand }</option>
	             	</c:forEach> 
				</select>
			&nbsp
			年份：<select name="date" id="date">
					<option ></option>
					<option >2015</option>
					<option >2016</option>
					<option >2017</option>
					<option >2018</option>
				</select>
			<input type="submit" value="查询" id="query">
			<table border="0" align="center" cellspacing="1" cellpadding="0"  bgcolor="#999999" id="table">
				<tr bgcolor="#FFFFFF" height=45>
					<th width="110">销售日期</th>
					<th width="110">销售商名称</th>
					<th width="90">所属区域</th>
					<th width="90">手机品牌</th>
					<th width="110">手机型号</th>
					<th width="110">销售量</th>
					<th width="75">操作</th>
				</tr>
					<c:forEach var="areaMap" items="${ requestScope.areaMap}" >
						<tr bgcolor="#FFFFFF" height=30 align="center">
							<td>${pageScope.areaMap.value.getDate() }</td>
							<td>${pageScope.areaMap.value.getName() }</td>
							<td>${pageScope.areaMap.key.substring(0,areaMap.key.length()-1)}</td>
							<td>${pageScope.areaMap.value.getBrand() }</td>
							<td>${pageScope.areaMap.value.getType() }</td>
							<td>${pageScope.areaMap.value.getNumber() }</td>
							<td></td>
						</tr>
					</c:forEach>
			</table>
			<p id="p">一共${requestScope.sellNumber}条数据   每页显示5条   共${requestScope.pagination}页  当前页第${requestScope.num}页
				<a href="QuerySellServlet?behavior=first">首页</a>
				<a href="QuerySellServlet?behavior=up">上一页</a>
				<a href="QuerySellServlet?behavior=next">下一页</a>
				<a href="QuerySellServlet?behavior=last">尾页</a>
			</p>
		</form>
	</div>
</body>
</html>