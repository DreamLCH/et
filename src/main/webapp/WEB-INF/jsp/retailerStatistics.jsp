<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>按销售商统计</title>
<script src="JS/echarts.min.js"></script>

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>

<style>
	*{margin: 0; padding: 0; font-family:宋体;}
	#statement{ width:700px; height:400px; position: absolute; left:50%; margin-left:-300px; margin-top:100px}
	#query_div{ width:700px; height:50px; position: absolute; left:50%; margin-left:-300px; margin-top:50px}
	#year{height:27px; width:70px;}
	#query{width:80px; height:32px; background:#1E90FF; color:#FFFFFF; font-size:18px; margin-left:300px; border:1px #1E90FF solid;}
	#table_div{width:1000px; margin-top:530px; position: absolute;left:50%; margin-left:-300px; }
	#p{height:60px; width:950px; text-align:center; margin-top:10px}
	
</style>
<script>
$(function(){  
    postChart();  
}); 
function postChart(){ 
 	var statement = echarts.init(document.getElementById('statement')); 
 	var type = [];
 	<c:forEach var="list" items="${requestScope.list }">
		type.push('${list.get("name")}');
	</c:forEach>
	var option = {
		    title: {
		        text: '按销售商统计'
		    },
		    tooltip: {
		        trigger: 'axis'
		    },
		    legend: {
		        data:type
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    toolbox: {
		        feature: {
		            saveAsImage: {}
		        }
		    },
		    xAxis: {
		        type: 'category',
		        boundaryGap: false,
		        data: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月']
		    },
		    yAxis: {
		        type: 'value'
		    },
		    series: [
		    	<% 
		    	ArrayList arrayList = (ArrayList)request.getAttribute("list");
		    	for(int i=0; i<arrayList.size();i++) {
		    		Map map = (Map)arrayList.get(i);
		    	%>
			        {
			            name:'<%=map.get("name")%>',
			            type:'line',
			            stack: '总量',
			            data:[<%for(int j=1; j<13; j++){%>
			            	<%=map.get(j+"")%>,
			            <%}%>]
			        },
			   <%}%>
		    ]
		};
		statement.setOption(option); 
	}
</script>
</head>
<body>
	<c:import url="navigation" var="na"></c:import>
	${pageScope.na}
	<div id="query_div">
		<form  method="post" action="RetailerStatisticsServlet">
			年份：<select name="year" id="year">
					<option >2016</option>
					<option >2017</option>
					<option >2018</option>
				</select>
			<input type="submit" value="查询" id="query">
		</form>
	</div>
	<div id="statement"></div>
	<div id="table_div">
		<table border="0" align="center" cellspacing="1" cellpadding="0"  bgcolor="#999999" id="table">
			<tr bgcolor="#FFFFFF" height=45>
				<th width="110">销售商</th>
				<th width="70">1月</th>
				<th width="70">2月</th>
				<th width="70">3月</th>
				<th width="70">4月</th>
				<th width="70">5月</th>
				<th width="70">6月</th>
				<th width="70">7月</th>
				<th width="70">8月</th>
				<th width="70">9月</th>
				<th width="70">10月</th>
				<th width="70">11月</th>
				<th width="70">12月</th>
			</tr>
			<c:forEach var="list" items="${ requestScope.list}" >
				<tr bgcolor="#FFFFFF" height=30 align="center">
					<td>${list.get("name")}</td>
					<td>${list.get("1") }</td>
					<td>${list.get("2") }</td>
					<td>${list.get("3") }</td>
					<td>${list.get("4") }</td>
					<td>${list.get("5") }</td>
					<td>${list.get("6") }</td>
					<td>${list.get("7") }</td>
					<td>${list.get("8") }</td>
					<td>${list.get("9") }</td>
					<td>${list.get("10") }</td>
					<td>${list.get("11") }</td>
					<td>${list.get("12") }</td>
				</tr>
			</c:forEach>
		</table>
		<p id="p">一共${requestScope.sellNumber}条数据   每页显示5条   共${requestScope.pagination}页  当前页第${requestScope.num}页
			<a href="RetailerStatisticsServlet?&date=${requestScope.date}">首页</a>
			<a href="RetailerStatisticsServlet?&date=${requestScope.date}">上一页</a>
			<a href="RetailerStatisticsServlet?&date=${requestScope.date}">下一页</a>
			<a href="RetailerStatisticsServlet?&date=${requestScope.date}">尾页</a>
		</p>
	</div>
</body>
</html>