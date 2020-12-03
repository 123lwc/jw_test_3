<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="entity.Worker,java.util.*"
	import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Worker> list = new ArrayList();
		for (int i = 0; i < 25; i++) {
			Worker worker = new Worker();
			worker.setId("1" + i);
			worker.setName("zs" + i);
			if (i % 2 == 0) {
				worker.setSex("男");
				worker.setClub("员工层");
			} else {
				worker.setSex("女");
				worker.setClub("管理层");
			}
			list.add(worker);
		}
		pageContext.setAttribute("workers", list);
	%>
	<c:forEach var="worker" items="${workers }" begin="4" end="14">
	${worker.id }--${worker.name }--${worker.sex }--${worker.club }<br>
	</c:forEach>

</body>
</html>