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
<title>按品牌统计</title>
<script src="JS/echarts.min.js"></script>

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>

<style>
	*{margin: 0; padding: 0; font-family:宋体;}
	#statement{ width:700px; height:400px; position: absolute; left:50%; margin-left:-300px; margin-top:100px}
	#query_div{ width:700px; height:50px; position: absolute; left:50%; margin-left:-300px; margin-top:50px}
	#brand{height:27px; width:70px;}
	#year{height:27px; width:70px;}
	#query{width:80px; height:32px; background:#1E90FF; color:#FFFFFF; font-size:18px; margin-left:300px; border:1px #1E90FF solid;}
	#table_div{width:700px; margin-top:530px; position: absolute;left:50%; margin-left:-300px; }
	#p{height:60px; width:715px; text-align:center; margin-top:10px}
	
</style>
<script>
$(function(){  
    postChart();  
}); 
function postChart(){ 
 	var statement = echarts.init(document.getElementById('statement')); 
 	var type = [];
 	<c:forEach var="sellmap" items="${requestScope.sellMap }">
		type.push('${sellmap.key}');
	</c:forEach>
	var option = {
		    title: {
		        text: '按品牌统计'
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
		    	Map sellmap = (Map)request.getAttribute("sellMap");
		    	Set<String> temp= sellmap.keySet();
		    	Iterator<String> iter =  temp.iterator();
		    	while(iter.hasNext()){
		    		String key=iter.next();
		    		ArrayList array = (ArrayList)sellmap.get(key);
		    		Map map = (Map)array.get(0);
		    	%>
			        {
			            name:'<%=key%>',
			            type:'line',
			            stack: '总量',
			            data:[<%for(int i=1; i<13; i++){%>
			            	<%=map.get(i+"")%>,
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
		<form method="post" action="BrandStatisticsServlet">
			&nbsp
			品牌：<select name="brand" id="brand">
					<c:forEach var="brand" items="${requestScope.phoneBrand }">
		             	<option >${brand }</option>
		            </c:forEach> 
				</select>&nbsp
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
				<th width="110">品牌名称</th>
				<th width="110">销售日期</th>
				<th width="110">手机型号</th>
				<th width="110">规格</th>
				<th width="90">销售量</th>
				<th width="90">销售额</th>
				<th width="90">销售单价</th>
			</tr>
			<c:forEach var="list" items="${ requestScope.list}" >
				<tr bgcolor="#FFFFFF" height=30 align="center">
					<td>${pageScope.list.get(1).getName() }</td>
					<td>${pageScope.list.get(1).getDate() }</td>
			 		<td>${pageScope.list.get(1).getType() }</td>
					<td>${pageScope.list.get(0).getSize() }</td>
					<td>${pageScope.list.get(1).getNumber() }</td>
					<td>${pageScope.list.get(1).getNumber()*pageScope.list.get(0).getPrice() }</td>
					<td>${pageScope.list.get(0).getPrice() }</td>
				</tr>
			</c:forEach>
		</table>
		<p id="p">一共${requestScope.sellNumber}条数据   每页显示5条   共${requestScope.pagination}页  当前页第${requestScope.num}页
			<a href="BrandStatisticsServlet?behavior=first">首页</a>
			<a href="BrandStatisticsServlet?behavior=up">上一页</a>
			<a href="BrandStatisticsServlet?behavior=next">下一页</a>
			<a href="BrandStatisticsServlet?behavior=last">尾页</a>
		</p>
	</div>
</body>
</html>