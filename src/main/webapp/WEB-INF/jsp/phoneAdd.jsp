<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>手机录入</title>
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
		<form method="post" action="AddPhoneServlet">
			<h1>手机录入</h1>
			<p>手机型号：<input type="text" name="type" class="p_style" placeholder="请输入手机型号" required></p>
			<p>品牌：<select name="brand" class="p_style">
             	<option>华为</option>
                <option>三星</option>
                <option>小米</option>
                <option>魅族</option>
                <option>苹果</option>
                <option>vivo</option>
                <option>OPPO</option>
                <option>酷派</option>
                <option>中兴</option>
             </select></p>
             <p>价格：<input type="text" name="price" placeholder="请输入价格" class="p_style" required></p>
             <p>颜色：<select name="colour" class="p_style">
             	<option>白色</option>
                <option>黑色</option>
                <option>粉色</option>
                <option>蓝色</option>
                <option>咖啡色</option>
                <option>土豪金</option>
                <option>玫瑰金</option>
             </select></p>
             <p>分辨率/尺寸：<select name="size" class="p_style">
             	<option>1920*1080</option>
                <option>1600*900</option>
                <option>1280*720</option>
             </select></p>
             <p>生产日期：<input type="date" name="date" class="p_style" required></p>
             <p>手机描述：<input type="text" name="describe" placeholder="请输入描述" class="p_style" required></p>
             <input type="submit" value="注册" id="register">
             <input type="reset" value="重置" id="reset">
		</form>
	</div>
</body>
</html>