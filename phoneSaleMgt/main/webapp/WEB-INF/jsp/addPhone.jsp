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
<title><s:message code="phoneEntering"></s:message></title>
<style>
* {
	margin: 0;
	padding: 0;
	font-family: 宋体;
}

#ha_div {
	width: 470px;
	height: 520px;
	margin: -275px -210px;
	position: absolute;
	top: 50%;
	left: 50%;
	box-shadow: 1px 1px 5px #333333;
}

h1 {
	width: 470px;
	height: 80px;
	text-align: center;
	line-height: 80px;
}

p {
	margin-top: 20px;
	margin-left: 50px;
	width: 950px;
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
	margin-left: 120px;
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

.error {
	color: red;
}
</style>


<script type="text/javascript">
	/*
	失焦事件，但input框失去焦点的时候发送ajax请求去数据库判断输入的唯一列值是否存在
	*/
	$(function(){
		$("#type").focusout(function(){
			var url = "/query/phone/type?type="+$("#type").val();
			$.getJSON(url,function(jsObject){
				if(jsObject.result){
					$("#register").removeAttr("disabled");
					$("#prompt").text("");
				}else{
					$("#prompt").text("你输入的手机型号已存在，无法提交，请修改。");
					$("#register").attr("disabled","disabled");
				}
			})
		});
	})
</script>

</head>
<body>
	<div id="ha_div">
		<form:form method="post" action="/add/phone" modelAttribute="phone">
			<h1>
				<s:message code="phoneEntering"></s:message>
			</h1>
			<p>
				<s:message code="phoneType"></s:message>
				：
				<form:input path="type" class="p_style" id="type"/>
				<form:errors path="type" cssClass="error"></form:errors>
				<span id="prompt" class="error"></span>
			</p>
			<p>
				<s:message code="phoneBrand"></s:message>
				： <select name="brand" class="s_style">
					<option>华为</option>
					<option>三星</option>
					<option>小米</option>
					<option>魅族</option>
					<option>苹果</option>
					<option>vivo</option>
					<option>OPPO</option>
					<option>酷派</option>
					<option>中兴</option>
				</select>
				<form:errors path="brand"></form:errors>
			</p>
			<p>
				<s:message code="phonePrice"></s:message>
				：
				<form:input path="price" class="p_style" />
				<form:errors path="price" cssClass="error"></form:errors>
			</p>
			<p>
				<s:message code="phoneColour"></s:message>
				： <select name="colour" class="s_style">
					<option>白色</option>
					<option>黑色</option>
					<option>粉色</option>
					<option>蓝色</option>
					<option>咖啡色</option>
					<option>土豪金</option>
					<option>玫瑰金</option>
				</select>
				<form:errors path="colour" cssClass="error"></form:errors>
			</p>
			<p>
				<s:message code="Size"></s:message>
				： <select name="size" class="s_style">
					<option>1920*1080</option>
					<option>1600*900</option>
					<option>1280*720</option>
				</select>
				<form:errors path="size" cssClass="error"></form:errors>
			</p>
			<p>
				<s:message code="theDateOfProduction"></s:message>
				： <input type="date" name="date" class="p_style">
				<form:errors path="date" cssClass="error"></form:errors>
			</p>
			<p>
				<s:message code="phoneDescribe"></s:message>
				：
				<form:input path="describe" class="p_style" />
				<form:errors path="describe" cssClass="error"></form:errors>
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