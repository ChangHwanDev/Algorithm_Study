<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>코로나 시도 발생 현황</h1>
<hr>

<table border="1" cellpadding="10" cellspacing="0">
	<tr>
		<th>구분</th>
		<th>지역 발생자 수</th>
	</tr>
	<c:forEach var="item" items="${list }">
	<tr>
		<td>${item.gubun }</td><td>${item.localOccCnt }</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>












