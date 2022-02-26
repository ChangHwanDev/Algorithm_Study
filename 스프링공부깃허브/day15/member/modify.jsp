<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h2>회원 정보</h2>

<form method="POST">
	<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<td>ID</td>
			<td>${dto.userid }</td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="userpw" placeholder="새로운 비밀번호 입력"></td>
		</tr>
		<tr>
			<td>사용자 이름</td>
			<td><input type="text" name="username" value="${dto.username }"></td>
		</tr>
		<tr>
			<td>E-mail</td>
			<td><input type="email" name="email" value="${dto.email }"></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><input type="date" name="birth" value="${dto.birth }"></td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<select name="gender">
					<option ${dto.gender == '남성' ? 'selected' : '' }>남성</option>
					<option ${dto.gender == '여성' ? 'selected' : '' }>여성</option>
					<option ${dto.gender == '선택안함' ? 'selected' : '' }>선택안함</option>
				</select>
			</td>
		</tr>
	</table>
<p>
	<button>정보 수정 완료</button>
</p>
<input type="hidden" name="userid" value="${dto.userid }">
</form>

</main>
</body>
</html>