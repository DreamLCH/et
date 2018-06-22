<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@	taglib tagdir="/WEB-INF/tags" prefix="my" %>
<!-- 导入导航栏 -->
<%@ include file="navigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:message code="retailerAdd"></s:message></title>
<style>
* {
	margin: 0;
	padding: 0;
	font-family: 宋体;
}

#ha_div {
	width: 460px;
	height: 520px;
	margin: -275px -210px;
	position: absolute;
	top: 50%;
	left: 50%;
	box-shadow: 1px 1px 5px #333333;
}

h1 {
	width: 460px;
	height: 80px;
	text-align: center;
	line-height: 80px
}

p {
	margin-top: 20px;
	margin-left: 50px;
	width: 750px;
}

.p_style {
	width: 200px;
	height: 25px;
}

.s_style {
	width: 200px;
	height: 30px;
}

#register {
	width: 90px;
	height: 35px;
	margin-left: 110px;
	background: #1E90FF;
	color: #FFFFFF;
	font-size: 18px;
	border: 2px #1E90FF solid;
}

#reset {
	width: 90px;
	height: 35px;
	margin-top: 30px;
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

<script type="text/javascript">
	/*
	失焦事件，但input框失去焦点的时候发送ajax请求去数据库判断输入的唯一列值是否存在
	*/
	$(function(){
		$("#name").focusout(function(){
			var url = "/query/retailer/name?name="+$("#name").val();
			$.getJSON(url,function(jsObject){
				if(jsObject.result){
					$("#register").removeAttr("disabled");
					$("#prompt").text("");
				}else{
					$("#prompt").text("你输入的销售商名称已存在，无法提交，请修改。");
					$("#register").attr("disabled","disabled");
				}
			})
		});
	})
</script>
</head>
<body>
	<div id="ha_div">
		<form:form method="post" action="/add/retailer"
			modelAttribute="retailer">
			<h1>
				<s:message code="retailerAdd"></s:message>
			</h1>
			<p>
				<s:message code="retailerName"></s:message>
				：
				<form:input path="name" class="p_style" id="name"/>
				<form:errors path="name" cssClass="errors"></form:errors>
				<span id="prompt" class="errors"></span>
			</p>
			<p>
				<s:message code="area"></s:message>
				： <select name="area" class="s_style">
					<option>湖南</option>
					<option>湖北</option>
					<option>广东</option>
					<option>广西</option>
					<option>河南</option>
					<option>河北</option>
					<option>北京</option>
					<option>上海</option>
					<option>福建</option>
				</select>
				<form:errors path="area" cssClass="errors"></form:errors>
			</p>
			<p>
				<s:message code="sellPrincipal"></s:message>
				：
				<form:input path="principal" class="p_style" />
				<form:errors path="principal" cssClass="errors"></form:errors>
			</p>
			<p>
				<s:message code="principalPhone"></s:message>
				：
				<form:input path="phone" class="p_style" />
				<form:errors path="phone" cssClass="errors"></form:errors>
			</p>
			<p>
				<s:message code="principalIdCard"></s:message>
				：
				<form:input path="identity" class="p_style" />
				<form:errors path="identity" cssClass="errors"></form:errors>
			</p>
			<p>
				<s:message code="contactAddress"></s:message>
				：
				<form:input path="address" class="p_style" />
				<form:errors path="address" cssClass="errors"></form:errors>
			</p>
			<p>
				<s:message code="zipCodeNumber"></s:message>
				：
				<form:input path="postcode" class="p_style" />
				<form:errors path="postcode" cssClass="errors"></form:errors>
			</p>
			<input type="submit" value="<s:message code="register"></s:message>"
				id="register">
			<input type="reset" value="<s:message code="reset"></s:message>"
				id="reset">
				
			<my:token></my:token>
		</form:form>
	</div>
</body>
</html>