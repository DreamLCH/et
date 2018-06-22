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
<title><s:message code="brandStatistics"></s:message></title>


<script src="JS/echarts.min.js"></script>


<style>
* {
	margin: 0;
	padding: 0;
	font-family: 宋体;
}


#statement {
	width: 770px;
	height: 400px;
	position: absolute;
	left: 50%;
	margin-left: -300px;
	margin-top: 100px
}


#query_div {
	width: 770px;
	height: 50px;
	position: absolute;
	left: 50%;
	margin-left: -300px;
	margin-top: 50px
}


#brand {
	height: 27px;
	width: 70px;
}


#year {
	height: 27px;
	width: 70px;
}


#query {
	width: 80px;
	height: 32px;
	background: #1E90FF;
	color: #FFFFFF;
	font-size: 18px;
	margin-left: 300px;
	border: 1px #1E90FF solid;
}


#table_div {
	width: 770px;
	margin-top: 530px;
	position: absolute;
	left: 50%;
	margin-left: -300px;
}
</style>
<script>
	$(function() {
		//调用函数发送请求查询所有手机品牌，此函数放在JS文件下面的ajax.js文件里面
		setupOption("/query/brand", "brand");
		callPostChart();
	});
	
	
	
	
	function callPostChart(){
		var brand = $("#brand").val();
		var year = $("#year").val();


		//如果值为空则设置默认值
		if (brand == null || brand == "") {
			brand = "华为";
		}
		if (year == null || year == "") {
			year = "2018";
		}
		//将获取到的参数拼接好
		var param = "&brand=" + brand + "&year=" + year;
		
		var dataUrl = "/query/statisticsData?"+param;
		
		$.getJSON(dataUrl, function(jsObject) {
			postChart(jsObject);
		});
	}


	function postChart(jsObject) {
		var statement = echarts.init(document.getElementById('statement'));
		var tempSeries = [];
		var type = [];
		for (var key in jsObject) {
			type.push(key);
			
			var list = jsObject[key];
			var datas;
			
			for(var value in list){
				datas = list[value];
			}
			
			var arr=[];
			for(var ins in datas){
				arr.push(datas[ins]);
			}
			
			var temp={name:key, type:'line',data:arr}
			tempSeries.push(temp);
			
		}
		
		
		var option = {
			title : {
				text : '<s:message code="brandStatistics"></s:message>'
			},
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				data : type
			},
			grid : {
				left : '3%',
				right : '4%',
				bottom : '3%',
				containLabel : true
			},
			toolbox : {
				feature : {
					saveAsImage : {}
				}
			},
			xAxis : {
				type : 'category',
				boundaryGap : false,
				data : [ '<s:message code="January"></s:message>',
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
						'<s:message code="December"></s:message>' ]
			},
			yAxis : {
				type : 'value'
			},
			series : tempSeries
		};
		statement.setOption(option);
	}


	/*
	在发送的ajax请求里面添加额外的参数
	*/
	function rewriteTheParameters(params){
		var year = $("#year").val();
		var brand = $("#brand").val();
		return {
			limit:params.params,
			offset:params.offset,
			year:year,
			brand:brand
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
		&nbsp
		<s:message code="brand"></s:message>
		：<select name="brand" id="brand" onchange="theTrigger();">
		</select>&nbsp
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
			data-url="/query/brandStatistics"
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
				<tr>
					<th data-field="brand" data-align="center"><s:message code="brandName"></s:message></th>
					<th data-field="s_date" data-align="center"><s:message code="sellDate"></s:message></th>
					<th data-field="s_type" data-align="center"><s:message code="phoneType"></s:message></th>
					<th data-field="size" data-align="center"><s:message code="specification"></s:message></th>
					<th data-field="number" data-align="center"><s:message code="sales"></s:message></th>
					<th data-field="sales" data-align="center"><s:message code="theSalesAmount"></s:message></th>
					<th data-field="price" data-align="center"><s:message code="salesUnitPrice"></s:message></th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
</body>
</html>