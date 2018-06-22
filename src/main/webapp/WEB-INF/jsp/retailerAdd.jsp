<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>销售商添加</title>
<style>
	*{margin: 0; padding: 0;font-family:宋体;}
	#ha_div{width:400px; height:520px; margin: -275px -210px; position:absolute; top:50%; left:50%; box-shadow:1px 1px 5px #333333;}
	h1{width:400px; height:80px; text-align:center; line-height:80px}
	p{margin-top:20px;  margin-left:50px;}
	.p_style{width:200px; height:25px;}
	#register{width:90px; height:35px; margin-left:80px; background:#1E90FF; color:#FFFFFF; font-size:18px; border:2px #1E90FF solid;}
	#reset{width:90px; height:35px; margin-top:30px; margin-left:50px; background:#1E90FF; color:#FFFFFF; font-size:18px; border:2px #1E90FF solid;}
</style>
</head>
<body>
	<c:import url="navigation" var="na"></c:import>
	${pageScope.na}
	<div id="ha_div">
		<form method="post" action="AddRetailerServlet">
			<h1>销售商添加</h1>
			<p>销售商名称：<input type="text" name="name" class="p_style" placeholder="请输入销售商名称" required></p>
			<p>区域：<select name="area" class="p_style">
             	<option>湖南</option>
                <option>湖北</option>
                <option>广东</option>
                <option>广西</option>
                <option>河南</option>
                <option>河北</option>
                <option>北京</option>
                <option>上海</option>
                <option>福建</option>
             </select></p>
             <p>销售负责人：<input type="text" name="principal" placeholder="请输入销售负责人" class="p_style" required></p>
             <p>负责人电话：<input type="text" name="phone" placeholder="请输入负责人电话" class="p_style" required></p>
             <p>负责人身份证：<input type="text" name="identity" placeholder="请输入负责人身份证" class="p_style" required></p>
             <p>联系地址：<input type="text" name="address" class="p_style" placeholder="请输入联系地址" required></p>
             <p>邮编号码：<input type="text" name="postcode" placeholder="请输入邮编号码" class="p_style" required></p>
             <input type="submit" value="注册" id="register">
             <input type="reset" value="重置" id="reset">
		</form>
	</div>
</body>
</html>