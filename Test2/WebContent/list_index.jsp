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
	<table border="1">
	<tr>
			<td>index</td>
			<td>count</td>
			<td>id</td>
			<td>name</td>
			<td>sex</td>
			<td>club</td>
			<tr/>
		<c:forEach var="worker" items="${workers }" varStatus="sta">
		<tr>
			<c:if test="${sta.first || sta.last}">
				<tr style="background: green;">
			</c:if>
			
			<td>${sta.index }</td>
			<td>${sta.count }</td>
			<td>${worker.id }</td>
			<td>${worker.name }</td>
			<td>${worker.sex }</td>
			<td>${worker.club }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>