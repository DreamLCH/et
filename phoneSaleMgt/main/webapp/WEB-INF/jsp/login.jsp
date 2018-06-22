<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:message code="login"></s:message></title>
<style>
* {
	margin: 0;
	padding: 0;
}

body {
	background: url(img/login_picture.jpg) no-repeat fixed;
	background-size: 100% 1000px;
	font-size: 18px;
}

#div1 {
	background: rgba(255, 255, 255, .0);
	margin: 50px auto;
	height: 250px;
	width: 350px;
	box-shadow: 1px 1px 5px #333333;
	padding-top: 50px;
	font-weight: 600;
	position: relative
}

#names {
	margin-left: 55px;
	margin-top: 10px;
	width: 450px;
}

#id {
	height: 20px;
}

#password {
	margin-left: 55px;
	margin-top: 20px;
	width: 450px;
}

#pass {
	height: 20px;
	margin-top: 10px
}

#login {
	height: 30px;
	width: 90px;
	margin-left: 130px;
	margin-top: 30px;
	background: #6CF;
}

#testing {
	margin-top: 30px;
	margin-left: 55px
}

#tes {
	height: 20px;
	width: 50px;
}

#refresh {
	color: blue
}

#h1 {
	height: 50px;
	width: 100%;
	text-align: center;
	margin-top: 200px;
}

.error {
	color: red;
}
</style>
<script>
	window.onload = function() {

		var span = document.getElementById('verification')
		var button = document.getElementById('login')
		var input = document.getElementById('tes')
		var button2 = document.getElementById('refresh')

		function yangzheng() {
			var num = parseInt(Math.random() * 8999 + 1000)
			span.innerHTML = num
			button.onclick = function() {
				var inputs = input.value;
				if (inputs == num) {
					return true
				} else {
					alert('验证码输入错误！')
					return false
				}
			}
		}

		button2.onclick = function() {
			yangzheng();
		}

		yangzheng();
	}
</script>
</head>
<body>
	<h1 id="h1">
		<s:message code="MobilePhoneSalesPlatform"></s:message>
	</h1>
	<div id="div1">
		<form:form method="post" action="/userlogin" modelAttribute="user">
			<p id="names">
				<s:message code="userName"></s:message>
				：
				<form:input path="name" id="id" />
				<form:errors path="name" class="error"></form:errors>
			</p>
			<p id="password">
				<s:message code="password"></s:message>
				：
				<form:password path="password" id="pass" />
				<form:errors path="password" class="error"></form:errors>
			</p>
			<p id="testing">
				<s:message code="verificationCode"></s:message>
				： <input type="text" name="tes" id="tes" required> <span
					id="verification"></span> <span id="refresh"> <s:message
						code="theRefresh"></s:message>
				</span>
			</p>
			<input type="submit" value="<s:message code="login"></s:message>"
				id="login">
		</form:form>
	</div>
</body>
</html>