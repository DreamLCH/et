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
<title><s:message code="monthStatistics"></s:message></title>

<script src="JS/echarts.min.js"></script>

<script>
	$(function() {
		queryYearStatistics();
	});

	function postChart(jsObject) {

		var app = echarts.init(document.getElementById('statement'));
		var temp = [];
		var tempSeries = [];
		
		for (var i = 0; i < jsObject.length; i++) {

			var obj = jsObject[i];
			
			for (var key in obj) {
				var value = obj[key];
				temp.push(key);
				
				var datas = {name: key,  type: 'bar', barGap: 0, label: labelOption, data:value}
				tempSeries.push(datas);
			}
		}
		
		var posList = [ 'left', 'right', 'top', 'bottom', 'inside',
				'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
				'insideTopLeft', 'insideTopRight', 'insideBottomLeft',
				'insideBottomRight' ];

		app.configParameters = {
			rotate : {
				min : -90,
				max : 90
			},
			align : {
				options : {
					left : 'left',
					center : 'center',
					right : 'right'
				}
			},
			verticalAlign : {
				options : {
					top : 'top',
					middle : 'middle',
					bottom : 'bottom'
				}
			},
			position : {
				options : echarts.util.reduce(posList, function(map, pos) {
					map[pos] = pos;
					return map;
				}, {})
			},
			distance : {
				min : 0,
				max : 100
			}
		};

		app.config = {
			rotate : 90,
			align : 'left',
			verticalAlign : 'middle',
			position : 'insideBottom',
			distance : 15,
			onChange : function() {
				var labelOption = {
					normal : {
						rotate : app.config.rotate,
						align : app.config.align,
						verticalAlign : app.config.verticalAlign,
						position : app.config.position,
						distance : app.config.distance
					}
				};
				myChart.setOption({
					series : [ {
						label : labelOption
					}, {
						label : labelOption
					}, {
						label : labelOption
					}, {
						label : labelOption
					} ]
				});
			}
		};

		var labelOption = {
			normal : {
				show : true,
				position : app.config.position,
				distance : app.config.distance,
				align : app.config.align,
				verticalAlign : app.config.verticalAlign,
				rotate : app.config.rotate,
				formatter : '{c}  {name|{a}}',
				fontSize : 16,
				rich : {
					name : {
						textBorderColor : '#fff'
					}
				}
			}
		};

		var option = {
			color : [ '#003366', '#006699', '#4cabce', '#e5323e' ],
			tooltip : {
				trigger : 'axis',
				axisPointer : {
					type : 'shadow'
				}
			},
			legend : {
				data : temp
			},
			toolbox : {
				show : true,
				orient : 'vertical',
				left : 'right',
				top : 'center',
				feature : {
					mark : {
						show : true
					},
					dataView : {
						show : true,
						readOnly : false
					},
					magicType : {
						show : true,
						type : [ 'line', 'bar', 'stack', 'tiled' ]
					},
					restore : {
						show : true
					},
					saveAsImage : {
						show : true
					}
				}
			},
			calculable : true,
			xAxis : [ {
				type : 'category',
				axisTick : {
					show : false
				},
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
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : tempSeries
		};
		app.setOption(option);
	}
	

	function queryYearStatistics() {


		//将获取到的参数拼接好
		var param = "year=" + $("#year").val();

		var url = "/ajax/yearStatistics?"+param;
		//调用封装好的sendAjax函数，发送请求，此函数放在JS文件下面的ajax.js文件里面
		$.getJSON(url, function(jsObject) {
			
			postChart(jsObject);

			//获取表格里的tbody
			var table = $("#tbody");
			var thead = $("#thead");

			//将tbody里的tr全部清空，不然数据会叠加
			table.html("");

			var arr = [];

			for (var j = 0; j < 13; j++) {
				var tr=$("<tr bgcolor='#FFFFFF' height=30></tr>");
				if(j==0){
					thead.append(tr);
				}else{
					table.append(tr);
				}
				arr.push(tr);
			}

			var th=$("<th width=120>销售月份</th>");
			arr[0].append(th);

			for (var q = 1; q < 13; q++) {
				var td = $("<td>"+$("#year").val()+"-"+q+"</td>");
				arr[q].append(td);
			}

			for (var i = 0; i < jsObject.length; i++) {

				var obj = jsObject[i];

				for ( var key in obj) {
					
					var value = obj[key];
					
					var ths = $("<th width=100>"+key+"</th>");
					arr[0].append(ths);

					for (var k = 0; k < 12; k++) {
						var tds = $("<td>"+value[k]+"</td>");
						arr[k + 1].append(tds);
					}
				}
			}

		})
	}
</script>

<style>
* {
	margin: 0;
	padding: 0;
	font-family: 宋体;
}

#statement {
	width: 1200px;
	height: 400px;
	position: absolute;
	left: 50%;
	margin-left: -400px;
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
	width: 700px;
	margin-top: 530px;
	position: absolute;
	left: 50%;
	margin-left: -300px;
}
</style>
</head>
<body>
	<div id="query_div">
		<s:message code="year"></s:message>
		：<select name="year" id="year">
			<option>2018</option>
			<option>2017</option>
			<option>2016</option>
		</select>
		<button id="query" name="behavior" onclick="queryYearStatistics();">
			<s:message code="query"></s:message>
		</button>
	</div>
	<div id="statement"></div>
	<div id="table_div">
		<table border="0" align="center" cellspacing="1" cellpadding="0"
			bgcolor="#999999" id="table" class="table" data-classes="table table-hover"
			data-toggle="table" >
			<thead id="thead">
			</thead>
			<tbody id="tbody">
			</tbody>
		</table>
	</div>
</body>
</html>