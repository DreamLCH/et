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
<title>按区域统计</title>
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
		type.push('${list.get("area")}');
	</c:forEach>
	var weatherIcons = {
		    'Sunny': './data/asset/img/weather/sunny_128.png',
		    'Cloudy': './data/asset/img/weather/cloudy_128.png',
		    'Showers': './data/asset/img/weather/showers_128.png'
		};

	var option = {
		    title: {
		        text: '区域销量统计',
		        subtext: '虚构数据',
		        left: 'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        // orient: 'vertical',
		        // top: 'middle',
		        bottom: 10,
		        left: 'center',
		        data: type
		    },
		    series : [
		        {
		            type: 'pie',
		            radius : '65%',
		            center: ['50%', '50%'],
		            selectedMode: 'single',
		            data:[
		                {
		                    
		                    label: {
		                        normal: {
		                            formatter: [
		                                '{title|{b}}{abg|}',
		                                '  {weatherHead|天气}{valueHead|天数}{rateHead|占比}',
		                                '{hr|}',
		                                '  {Sunny|}{value|202}{rate|55.3%}',
		                                '  {Cloudy|}{value|142}{rate|38.9%}',
		                                '  {Showers|}{value|21}{rate|5.8%}'
		                            ].join('\n'),
		                            backgroundColor: '#eee',
		                            borderColor: '#777',
		                            borderWidth: 1,
		                            borderRadius: 4,
		                            rich: {
		                                title: {
		                                    color: '#eee',
		                                    align: 'center'
		                                },
		                                abg: {
		                                    backgroundColor: '#333',
		                                    width: '100%',
		                                    align: 'right',
		                                    height: 25,
		                                    borderRadius: [4, 4, 0, 0]
		                                },
		                                Sunny: {
		                                    height: 30,
		                                    align: 'left',
		                                    backgroundColor: {
		                                        image: weatherIcons.Sunny
		                                    }
		                                },
		                                Cloudy: {
		                                    height: 30,
		                                    align: 'left',
		                                    backgroundColor: {
		                                        image: weatherIcons.Cloudy
		                                    }
		                                },
		                                Showers: {
		                                    height: 30,
		                                    align: 'left',
		                                    backgroundColor: {
		                                        image: weatherIcons.Showers
		                                    }
		                                },
		                                weatherHead: {
		                                    color: '#333',
		                                    height: 24,
		                                    align: 'left'
		                                },
		                                hr: {
		                                    borderColor: '#777',
		                                    width: '100%',
		                                    borderWidth: 0.5,
		                                    height: 0
		                                },
		                                value: {
		                                    width: 20,
		                                    padding: [0, 20, 0, 30],
		                                    align: 'left'
		                                },
		                                valueHead: {
		                                    color: '#333',
		                                    width: 20,
		                                    padding: [0, 20, 0, 30],
		                                    align: 'center'
		                                },
		                                rate: {
		                                    width: 40,
		                                    align: 'right',
		                                    padding: [0, 10, 0, 0]
		                                },
		                                rateHead: {
		                                    color: '#333',
		                                    width: 40,
		                                    align: 'center',
		                                    padding: [0, 10, 0, 0]
		                                }
		                            }
		                        }
		                    }
		                },
		                <c:forEach var="list" items="${requestScope.list }">
		                	{value:${list.get("gross")}, name: '${list.get("area")}'},
		                </c:forEach>
		            ],
		            itemStyle: {
		                emphasis: {
		                    shadowBlur: 10,
		                    shadowOffsetX: 0,
		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		                }
		            }
		        }
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
		<form method="post" action="AreaStatisticsServlet">
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
				<th width="110">区域</th>
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
				<th width="70">累计</th>
			</tr>
			<c:forEach var="list" items="${ requestScope.list}" >
				<tr bgcolor="#FFFFFF" height=30 align="center">
					<td>${pageScope.list.get("area")}</td>
					<td>${pageScope.list.get("1")}</td>
					<td>${pageScope.list.get("2")}</td>
					<td>${pageScope.list.get("3")}</td>
					<td>${pageScope.list.get("4")}</td>
					<td>${pageScope.list.get("5")}</td>
					<td>${pageScope.list.get("6")}</td>
					<td>${pageScope.list.get("7")}</td>
					<td>${pageScope.list.get("8")}</td>
					<td>${pageScope.list.get("9")}</td>
					<td>${pageScope.list.get("10")}</td>
					<td>${pageScope.list.get("11")}</td>
					<td>${pageScope.list.get("12")}</td>
					<td>${pageScope.list.get("gross")}</td>
				</tr>
			</c:forEach>
		</table>
		<p id="p">一共${requestScope.sellNumber}条数据   每页显示5条   共${requestScope.pagination}页  当前页第${requestScope.num}页
			<a href="AreaStatisticsServlet?&date=${requestScope.date}">首页</a>
			<a href="AreaStatisticsServlet?&date=${requestScope.date}">上一页</a>
			<a href="AreaStatisticsServlet?&date=${requestScope.date}">下一页</a>
			<a href="AreaStatisticsServlet?&date=${requestScope.date}">尾页</a>
		</p>
	</div>
</body>
</html>