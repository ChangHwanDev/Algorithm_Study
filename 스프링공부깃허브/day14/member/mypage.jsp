<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h2>회원 정보</h2>

<table border="1" cellpadding="10" cellspacing="0">
	<tr>
		<td>ID</td><td>${dto.userid }</td>
	</tr>
	<tr>
		<td>Password</td><td>********</td>
	</tr>
	<tr>
		<td>사용자 이름</td><td>${dto.username }</td>
	</tr>
	<tr>
		<td>E-mail</td><td>${dto.email }</td>
	</tr>
	<tr>
		<td>생년월일</td><td>${dto.birth }</td>
	</tr>
	<tr>
		<td>성별</td><td>${dto.gender }</td>
	</tr>
</table>

<p>
	<a href="${cpath }/member/modify"><button>정보 수정</button></a>

</p>

</main>
</body>
</html>