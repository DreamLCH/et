<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>按月份统计</title>
<script src="JS/echarts.min.js"></script>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script>

$(function(){  
    postChart();  
}); 

function postChart(){
	
	var app = echarts.init(document.getElementById('statement'));
	var temp = [];
	<c:forEach var="arrayList" items="${ requestScope.list}" >
		temp.push('${arrayList}');
	</c:forEach>
	var posList = [
	    'left', 'right', 'top', 'bottom',
	    'inside',
	    'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
	    'insideTopLeft', 'insideTopRight', 'insideBottomLeft', 'insideBottomRight'
	];

	app.configParameters = {
	    rotate: {
	        min: -90,
	        max: 90
	    },
	    align: {
	        options: {
	            left: 'left',
	            center: 'center',
	            right: 'right'
	        }
	    },
	    verticalAlign: {
	        options: {
	            top: 'top',
	            middle: 'middle',
	            bottom: 'bottom'
	        }
	    },
	    position: {
	        options: echarts.util.reduce(posList, function (map, pos) {
	            map[pos] = pos;
	            return map;
	        }, {})
	    },
	    distance: {
	        min: 0,
	        max: 100
	    }
	};

	app.config = {
	    rotate: 90,
	    align: 'left',
	    verticalAlign: 'middle',
	    position: 'insideBottom',
	    distance: 15,
	    onChange: function () {
	        var labelOption = {
	            normal: {
	                rotate: app.config.rotate,
	                align: app.config.align,
	                verticalAlign: app.config.verticalAlign,
	                position: app.config.position,
	                distance: app.config.distance
	            }
	        };
	        myChart.setOption({
	            series: [{
	                label: labelOption
	            }, {
	                label: labelOption
	            }, {
	                label: labelOption
	            }, {
	                label: labelOption
	            }]
	        });
	    }
	};


	var labelOption = {
	    normal: {
	        show: true,
	        position: app.config.position,
	        distance: app.config.distance,
	        align: app.config.align,
	        verticalAlign: app.config.verticalAlign,
	        rotate: app.config.rotate,
	        formatter: '{c}  {name|{a}}',
	        fontSize: 16,
	        rich: {
	            name: {
	                textBorderColor: '#fff'
	            }
	        }
	    }
	};

var option = {
	    color: ['#003366', '#006699', '#4cabce', '#e5323e'],
	    tooltip: {
	        trigger: 'axis',
	        axisPointer: {
	            type: 'shadow'
	        }
	    },
	    legend: {
	        data: temp
	    },
	    toolbox: {
	        show: true,
	        orient: 'vertical',
	        left: 'right',
	        top: 'center',
	        feature: {
	            mark: {show: true},
	            dataView: {show: true, readOnly: false},
	            magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
	            restore: {show: true},
	            saveAsImage: {show: true}
	        }
	    },
	    calculable: true,
	    xAxis: [
	        {
	            type: 'category',
	            axisTick: {show: false},
	            data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月' , '9月', '10月', '11月' , '12月']
	        }
	    ],
	    yAxis: [
	        {
	            type: 'value'
	        }
	    ],
	    series: [
	    	<c:forEach var="arrayList" items="${ requestScope.sellList}" >
	    		<c:forEach var="map" items="${ arrayList}" >
		        {
		            name: '${map.key}',
		            type: 'bar',
		            barGap: 0,
		            label: labelOption,
		            data: [
		            	<c:forEach var="list" items="${ map.value}" >
		            		${list},
		            	 </c:forEach>
		            ]
		        },
		        </c:forEach>
	        </c:forEach>
	    ]
	};
	app.setOption(option);
}
</script>

<style>
	*{margin: 0; padding: 0; font-family:宋体;}
	#statement{ width:1000px; height:400px; position: absolute; left:50%; margin-left:-400px; margin-top:100px}
	#query_div{ width:700px; height:50px; position: absolute; left:50%; margin-left:-300px; margin-top:50px}
	#year{height:27px; width:70px;}
	#query{width:80px; height:32px; background:#1E90FF; color:#FFFFFF; font-size:18px; margin-left:300px; border:1px #1E90FF solid;}
	#table_div{width:700px; margin-top:530px; position: absolute;left:50%; margin-left:-300px; }
	
</style>
</head>
<body>
	<c:import url="navigation" var="na"></c:import>
	${pageScope.na}
	<div id="query_div">
		<form method="post" action="YearStatistics">
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
				<th width="110">销售月份</th>
				<c:forEach var="arrayList" items="${ requestScope.list}" >
					<th width="90">${ arrayList}</th>
				</c:forEach>
			</tr>
			<c:forEach begin="1" end="12" var="i" step="1">
				<tr bgcolor="#FFFFFF" height=30 align="center">
					<td >${requestScope.year}-${i }</td>
					<c:forEach var="list" items="${ requestScope.sellList}">
						<c:forEach var="map" items="${list}">
							<td>${map.value.get(i-1)}</td>
						</c:forEach>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>