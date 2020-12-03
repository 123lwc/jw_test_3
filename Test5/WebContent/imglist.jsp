<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1" cellpadding="0" cellspacing="0" width="50%">
		<caption>图片信息显示</caption>
		<tr>
			<th>原始文件名</th>
			<th>存储文件名</th>
			<th>上传时间</th>
			<th>图片展示</th>
		</tr>
		<c:forEach items="${imglist}" var="st">
			<tr>
				<td>${st.firstName}</td>
				<td>${st.lastName}</td>
				<td>${st.time}</td>
				<td><img src="${path}/upload/${st.img}"></td>
			</tr>
		</c:forEach>
	</table>
	<td colspan="5"><c:if test="${!(page==1)}">
			<a href="ImgList?page=${page-1 }">上一页</a>
		</c:if> <c:forEach var="p" begin="1" end="${pageCount }">
			<a href="ImgList?page=${p}">第${p}页</a>
		</c:forEach> <c:if test="${!(page==pageCount)}">
			<a href="ImgList?page=${page+1 }">下一页</a>
		</c:if></td>

</body>
</html>