<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<section>
	<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<th>USERID</th>
			<td>${dto.userid }</td>
		</tr>
		<tr>
			<th>USERPW</th>
			<td>${dto.password}</td>
		</tr>
		<tr>
			<th>USERNAME</th>
			<td>${dto.username }</td>
		</tr>
		<tr>
			<th>EMAIL</th>
			<td>${dto.email }</td>
		</tr>
		<tr>
			<th>BIRTH</th>
			<td>${dto.birth }</td>
		</tr>
	</table>
	</section>
</body>
</html>