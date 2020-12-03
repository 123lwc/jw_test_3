<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.security.Principal"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String remoteUser = request.getRemoteUser();
	boolean isAdmin = request.isUserInRole("tomcat");
	request.setAttribute("remoteUser", remoteUser);
	request.setAttribute("isAdmin", isAdmin);
	Principal  p = request.getUserPrincipal();
%>
欢迎你：${remoteUser}<br />
您拥有以下权限：<br />
个人中心页面
</body>
</html>