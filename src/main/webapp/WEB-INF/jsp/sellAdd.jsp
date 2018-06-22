<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>销售录入</title>
<style>
	*{margin: 0; padding: 0;font-family:宋体;}
	#ha_div{width:400px; height:520px; margin: -275px -210px; position:absolute; top:50%; left:50%; box-shadow:1px 1px 5px #333333;}
	h1{width:400px; height:80px; text-align:center; line-height:80px}
	p{margin-top:25px;  margin-left:50px;}
	.p_style{width:200px; height:28px;}
	#register{width:90px; height:35px; margin-left:80px; background:#1E90FF; color:#FFFFFF; font-size:18px; border:2px #1E90FF solid;}
	#reset{width:90px; height:35px; margin-top:50px; margin-left:50px; background:#1E90FF; color:#FFFFFF; font-size:18px; border:2px #1E90FF solid;}
</style>
<script>

	function change(val){
		var city = document.getElementById('city');
		city.options.length=0;
		<c:forEach var="map" items="${requestScope.phoneMap }">
			if(val=="${pageScope.map.key}"){
				<c:forEach var="list" items="${pageScope.map.value}">
					var opt = document.createElement("option");
					opt.innerHTML="${pageScope.list.getType()}";
					city.appendChild(opt);
				</c:forEach>
			}
		</c:forEach>
	}
	</script>
</head>
<body>
	<c:import url="navigation" var="na"></c:import>
	${pageScope.na}
	<div id="ha_div">
		<form method="post" action="AddSellServlet">
			<h1>手机销售录入</h1>
			<p>销售商名称：<select name="name" class="p_style">
				<c:forEach var="retailer" items="${requestScope.retailerName }">
             		<option>${pageScope.retailer.getName()}</option>
             	</c:forEach>
             </select></p>
             <p>销售品牌：<select name="brand" class="p_style" id="private"  onchange="change(this.value);">
             	<c:forEach var="map" items="${requestScope.phoneMap }">
             		<option value="${pageScope.map.key }">${pageScope.map.key }</option>
             	</c:forEach>
             </select></p>
             <p>销售手机型号：<select name="type" class="p_style" id="city">
             	
             </select></p>
             <p>销售日期：<input type="date" name="date" class="p_style" required></p>
             <p>销售数量：<input type="text" name="number" placeholder="请输入销售数量" class="p_style" required></p>
             <input type="submit" value="录入" id="register">
             <input type="reset" value="重置" id="reset">
		</form>
	</div>
</body>
</html>