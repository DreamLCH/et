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
<title><s:message code="areaStatistics"></s:message></title>

<script src="JS/echarts.min.js"></script>

<style>
* {
	margin: 0;
	padding: 0;
	font-family: 宋体;
}

#statement {
	width: 700px;
	height: 400px;
	position: absolute;
	left: 50%;
	margin-left: -300px;
	margin-top: 100px
}

#query_div {
	width: 700px;
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
	width: 1000px;
	margin-top: 530px;
	position: absolute;
	left: 50%;
	margin-left: -300px;
}
</style>
<script>
	$(function() {
		callPostChart();
	});

	function callPostChart(){
		var param = "year=" + $("#year").val();
		
		var url = "/query/areaStatistics?"+param;
		
		$.getJSON(url, function(jsObject) {
	
			var obj = jsObject.result;
				
			postChart(obj);
	
		})
	}
	
	function postChart(jsObject) {
		
		
		var statement = echarts.init(document.getElementById('statement'));
		var type = [];
		var datas = [];
		var temp = {

				label : {
					normal : {
						backgroundColor : '#eee',
						borderColor : '#777',
						borderWidth : 1,
						borderRadius : 4,
					}
				}
			};
		
		datas.push(temp);

		for (var i = 0; i < jsObject.length; i++) {

			var obj = jsObject[i];

			for ( var key in obj) {
				var name;
				if (key == "0") {
					name = obj[key];;
				}else if(key == '13'){
					var value = {value : obj[key],name : name}
					datas.push(value);
				}
			}
		}


		var option = {
			title : {
				text : '<s:message code="areaStatistics"></s:message>',
				subtext : '<s:message code="virtualData"></s:message>',
				left : 'center'
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
				orient: 'vertical',
				top: 'middle',
				bottom : 10,
				left : 'center',
				data : type
			},
			series : [ {
				type : 'pie',
				radius : '65%',
				center : [ '50%', '50%' ],
				selectedMode : 'single',
				data : datas,
				itemStyle : {
					emphasis : {
						shadowBlur : 10,
						shadowOffsetX : 0,
						shadowColor : 'rgba(0, 0, 0, 0.5)'
					}
				}
			} ]
		};
		statement.setOption(option);
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
			data-url="/query/areaStatistics"
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
					<th data-field="0" data-align="center"><s:message code="area"></s:message></th>
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
					<th data-field="13" data-align="center"><s:message code="theCumulative"></s:message></th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
</body>
</html>