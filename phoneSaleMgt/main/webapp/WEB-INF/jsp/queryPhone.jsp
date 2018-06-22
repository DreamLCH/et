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
	

<title><s:message code="phoneQuery"></s:message></title>
<style>
* {
	margin: 0;
	padding: 0;
	font-family: 宋体;
}

#q_div {
	height: 500px;
	width: 780px;
	position: absolute;
	left: 50%;
	margin-top: 120px;
	margin-left: -300px;
}
.div{
	background: red;
}

</style>

<script type="text/javascript">
	
	/*
		创建一个删除按钮，并将按钮绑定点击事件，传入this.tr行的id值
	*/
	function actionFormatrer(value, row, index, field) {
		return "<button class='btn btn-info' onclick='clickDelete(\""
				+ value + "\")' >删除</button>"
	}
	
	
	/*
		删除按钮绑定的点击事件，发送一个ajax请求去数据库删除数据，之后再刷新本页面
	*/
	function clickDelete(value){
		$.getJSON("/delete/phone?id="+value,function(data){
			alert("删除成功。");
			window.location.reload();
		});
	}
	
	
</script>

</head>
<body>
	<div id="q_div">
		<table 
			class="table table-hover" 
			data-classes="table table-hover"
			data-toggle="table" 
			data-url="/query/phone/get" 
			data-id-field="id"
			data-page-list="[3, 5, 10]"
			data-page-size="5"
			data-data-field="result"
			data-show-columns="true" 
			data-pagination="true"
			data-side-pagination="server" 
			data-search="true"
			data-search-align="left" 
			data-striped="true"
		>
			<thead>
				<tr>
					<th data-field="t_id" data-align="center"><s:message code="number"></s:message></th>
					<th data-field="t_type" data-align="center"><s:message code="phoneType"></s:message></th>
					<th data-field="price" data-align="center"><s:message code="phonePrice"></s:message></th>
					<th data-field="colour" data-align="center"><s:message code="phoneColour"></s:message></th>
					<th data-field="size" data-align="center"><s:message code="Size"></s:message></th>
					<th data-field="t_date" data-align="center"><s:message code="theDateOfProduction"></s:message></th>
					<th data-field="t_id" data-formatter="actionFormatrer" data-align="center"><s:message code="operation"></s:message></th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
</body>
</html>