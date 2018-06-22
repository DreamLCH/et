<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib tagdir="/WEB-INF/tags" prefix="my" %>
<!-- 导入导航栏 -->
<%@ include file="navigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:message code="sellAdd"></s:message></title>
<style>
* {
	margin: 0;
	padding: 0;
	font-family: 宋体;
}

#ha_div {
	width: 400px;
	height: 520px;
	margin: -275px -210px;
	position: absolute;
	top: 50%;
	left: 50%;
	box-shadow: 1px 1px 5px #333333;
}

h1 {
	width: 400px;
	height: 80px;
	text-align: center;
	line-height: 80px
}

p {
	margin-top: 25px;
	margin-left: 50px;
	width: 550px;
}

.p_style {
	width: 200px;
	height: 28px;
}

.s_style {
	width: 200px;
	height: 30px;
}

#register {
	width: 90px;
	height: 35px;
	margin-left: 80px;
	background: #1E90FF;
	color: #FFFFFF;
	font-size: 18px;
	border: 2px #1E90FF solid;
}

#reset {
	width: 90px;
	height: 35px;
	margin-top: 50px;
	margin-left: 50px;
	background: #1E90FF;
	color: #FFFFFF;
	font-size: 18px;
	border: 2px #1E90FF solid;
}

.errors {
	color: red;
}
</style>
<script>

	/*
	失焦事件，但input框失去焦点的时候发送ajax请求去数据库判断输入的唯一列值是否存在
	*/
	function change(val) {
		var city = document.getElementById('city');
		city.options.length = 0;
		<c:forEach var="map" items="${requestScope.phoneMap }">
		if (val == "${pageScope.map.key}") {
			<c:forEach var="list" items="${pageScope.map.value}">
			var opt = document.createElement("option");
			opt.innerHTML = "${pageScope.list.getType()}";
			city.appendChild(opt);
			</c:forEach>
		}
		</c:forEach>
	}
</script>
</head>
<body>
	<div id="ha_div">
		<form:form method="post" action="/add/sell" modelAttribute="sell">
			<h1>
				<s:message code="sellAdd"></s:message>
			</h1>
			<p>
				<s:message code="retailerName"></s:message>
				：
				<form:select path="name" class="s_style">
					<c:forEach var="map" items="${requestScope.retailerName}">
						<option value="${pageScope.map.name }">${pageScope.map.name }</option>
					</c:forEach>
				</form:select>
				<form:errors path="name" cssClass="errors"></form:errors>
			</p>
			<p>
				<s:message code="sellBrand"></s:message>
				： <select name="brand" class="s_style" id="private"
					onchange="change(this.value);" required>
					<option>请选择</option>
					<c:forEach var="map" items="${requestScope.phoneMap }">
						<option value="${pageScope.map.key }">${pageScope.map.key }</option>
					</c:forEach>
				</select>
				<form:errors path="brand"></form:errors>
			</p>
			<p>
				<s:message code="sellPhoneType"></s:message>
				： <select name="type" class="s_style" id="city" required></select>
				<form:errors path="type" cssClass="errors"></form:errors>
			</p>
			<p>
				<s:message code="sellDate"></s:message>
				： <input type="date" name="date" class="p_style" >
				<form:errors path="date" cssClass="errors"></form:errors>
			</p>
			<p>
				<s:message code="sellAmount"></s:message>
				：
				<form:input path="number" class="p_style" />
				<form:errors path="number" cssClass="errors"></form:errors>
			</p>
			<input type="submit" value="<s:message code="entering"></s:message>"
				id="register">
			<input type="reset" value="<s:message code="reset"></s:message>"
				id="reset">
				
			<my:token></my:token>
		</form:form>
	</div>
</body>
</html>