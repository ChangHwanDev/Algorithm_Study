<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h2>회원 목록</h2>

<table border="1" cellpadding="10" cellspacing="0" width="900px" align="center">
	<tr>
		<th>userid</th>
		<th>userpw</th>
		<th>username</th>
		<th>email</th>
		<th>birth</th>
		<th>gender</th>
	</tr>
	<c:forEach var="dto" items="${list }">
	<tr>
		<th>${dto.userid }</th>
		<th>${dto.userpw }</th>
		<th>${dto.username }</th>
		<th>${dto.email }</th>
		<th>${dto.birth }</th>
		<th>${dto.gender }</th>
	</tr>
	</c:forEach>
</table>

</main>

</body>
</html>