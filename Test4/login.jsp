<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>HTTP表单认证的登录页面</h2>
<fieldset>
<legend>用户登录</legend>
<form action="j_security_check" style="background:url(img/a.jpg)">
用户名：<input type="text" name="j_username"/>
<br />
密&nbsp;&nbsp;码：<input type="password" name="j_password" />
<br />
<input type="submit" name="登录" />
</form>
</fieldset>
</body>
</html>