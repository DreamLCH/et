<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登录</title>
<style>
	*{margin: 0; padding: 0;}	
	body{ background: url(img/login.jpg) no-repeat fixed;background-size:100% 1000px; font-size:18px;}
	#div1{ background: rgba(255,255,255,.0);margin:50px auto; height:250px; width:350px; box-shadow:1px 1px 5px #333333; padding-top:50px; font-weight:600; position:relative}
	#names{ margin-left:55px; margin-top:10px;}
	#id{ height:20px;}
	#password{ margin-left:55px; margin-top:20px;}
	#pass{ height:20px; margin-top:10px}
	#login{ height:30px; width:90px; margin-left:130px; margin-top:30px; background: #6CF;}
	#testing{margin-top:30px; margin-left:55px}
	#tes{ height:20px; width:50px;}
	#refresh{color:blue}
	#h1{ height:50px; width:100%; text-align:center; margin-top:200px;}
</style>
<script>
	window.onload=function(){
	
		var span=document.getElementsByTagName('span')[0]
		var button=document.getElementById('login')
		var input=document.getElementById('tes')
		var button2=document.getElementById('refresh')
	
		function yangzheng(){
				var num=parseInt(Math.random()*8999+1000)
				span.innerHTML=num
				button.onclick=function(){
					var inputs=input.value;
					if(inputs==num){
						return true
					}else{
						alert('验证码输入错误！')
						return false
					}
				}
		}
		
		button2.onclick=function(){
			yangzheng();
		}
		
		yangzheng();
	}
</script>
</head>
<body>
	<h1 id="h1">手机销售平台</h1>
		<div id="div1">
			<form method="post" action="loginServlet">
				<p id="names">账号：<input type="text" name="name" id="id" placeholder="请输入ID"></p> 
				<p id="password">密码：<input type="password" name="password" id="pass" placeholder="请输入密码"></p>
				<p id="testing">请输入验证码：<input type="text" name="tes" id="tes" required> <span></span> <span id="refresh">刷新</span></p> 
				<input type="submit" value="登录" id="login">
			</form>
		</div>
</body>
</html>