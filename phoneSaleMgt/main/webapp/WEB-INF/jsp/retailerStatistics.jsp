<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!-- 导入导航栏 -->
<%@ include file="navigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:message code="retailerStatistics"></s:message></title>

<script src="JS/echarts.min.js"></script>
<style>
* {
	margin: 0;
	padding: 0;
	font-family: 宋体;
}

#statement {
	width: 900px;
	height: 400px;
	position: absolute;
	left: 50%;
	margin-left: -300px;
	margin-top: 100px
}

#query_div {
	width: 900px;
	height: 50px;
	position: absolute;
	left: 50%;
	margin-left: -300px;
	margin-top: 50px
}

#year {
	height: 27px;
	width: 70px;
}

#table_div {
	width: 1040px;
	margin-top: 530px;
	position: absolute;
	left: 50%;
	margin-left: -300px;
}
</style>
<script>
	$(function(){ 
		callPostChart();
	}); 
	
	
	function callPostChart(){
		var param = "year=" + $("#year").val();
		
		var url = "/query/retailerStatistics?"+param;
		
		//调用封装好的sendAjax函数，发送请求，此函数放在JS文件下面的ajax.js文件里面
		$.getJSON(url, function(jsObject) {
	
			var obj = jsObject.result;
				
			postChart(obj);
	
		})
	}
	
	function postChart(jsObject){ 
	 	var statement = echarts.init(document.getElementById('statement')); 
	 	var tempSeries = [];
		var type = [];
		
		for(var i=0; i<jsObject.length; i++){
			var obj = jsObject[i];
			
			var name;
			var arr = [];
			for(var key in obj){
				if(key=="0"){
					name=obj[key];
				}else{
					arr.push(obj[key]);
				}
			}
			
			var temp={name:name, type:'line',data:arr}
			tempSeries.push(temp);
		}

		
		var option = {
			    title: {
			        text: '<s:message code="retailerStatistics"></s:message>'
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
			        data: ['<s:message code="January"></s:message>',
			        	'<s:message code="February"></s:message>',
			        	'<s:message code="March"></s:message>',
			        	'<s:message code="April"></s:message>',
			        	'<s:message code="May"></s:message>',
			        	'<s:message code="June"></s:message>',
			        	'<s:message code="July"></s:message>',
			        	'<s:message code="August"></s:message>',
			        	'<s:message code="September"></s:message>',
			        	'<s:message code="October"></s:message>',
			        	'<s:message code="November"></s:message>',
			        	'<s:message code="December"></s:message>']
			    },
			    yAxis: {
			        type: 'value'
			    },
			    series: tempSeries
			};
			statement.setOption(option,true); 
		}
		
		
	
	/*
		在发送的ajax请求里面添加额外的参数
	*/
	function rewriteTheParameters(params){
		var year = $("#year").val();
		return {
			limit:params.params,
			offset:params.offset,
			year:year,
		}
	}
	
	
	/*
	下拉框元素改变触发事件
	*/
	function theTrigger(){
		//刷新table表格里的数据
		$("table").bootstrapTable('refresh');
		//将报表图形重新渲染一遍
		callPostChart();
	}
</script>
</head>
<body>
	<div id="query_div">
		<s:message code="year"></s:message>
		：<select name="year" id="year" onchange="theTrigger();">
			<option>2018</option>
			<option>2017</option>
			<option>2016</option>
		</select>
	</div>
	<div id="statement"></div>
	<div id="table_div">
		<table 
			class="table" 
			data-classes="table table-hover"
			data-toggle="table" 
			data-url="/query/retailerStatistics"
			data-id-field="id"
			data-page-list="[3, 5, 10]"
			data-page-size="5"
			data-data-field="result"
			data-show-columns="true" 
			data-pagination="true"
			data-side-pagination="server"
			data-striped="true"
			data-query-params="rewriteTheParameters"
		>
			<thead>
				<tr bgcolor="#FFFFFF" height=45>
					<th data-field="0" data-align="center"><s:message code="retailer"></s:message></th>
					<th data-field="1" data-align="center"><s:message code="January"></s:message></th>
					<th data-field="2" data-align="center"><s:message code="February"></s:message></th>
					<th data-field="3" data-align="center"><s:message code="March"></s:message></th>
					<th data-field="4" data-align="center"><s:message code="April"></s:message></th>
					<th data-field="5" data-align="center"><s:message code="May"></s:message></th>
					<th data-field="6" data-align="center"><s:message code="June"></s:message></th>
					<th data-field="7" data-align="center"><s:message code="July"></s:message></th>
					<th data-field="8" data-align="center"><s:message code="August"></s:message></th>
					<th data-field="9" data-align="center"><s:message code="September"></s:message></th>
					<th data-field="10" data-align="center"><s:message code="October"></s:message></th>
					<th data-field="11" data-align="center"><s:message code="November"></s:message></th>
					<th data-field="12" data-align="center"><s:message code="December"></s:message></th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
</body>
</html>