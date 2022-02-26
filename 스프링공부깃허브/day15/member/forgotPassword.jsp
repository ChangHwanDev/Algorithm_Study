<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h2>신규 비밀번호 발급</h2>
<fieldset>
	<h4>가입 시 입력했던 ID와 이메일 주소와 생년월일을 정확하게 입력해주세요</h4>
	<form method="POST">
		<p><input type="text" name="userid" placeholder="ID"></p>
		<p><input type="email" name="email" placeholder="이메일 주소"></p>
		<p><input type="date" name="birth"></p>
		<p><input type="submit" value="발급"></p>
	</form>
</fieldset>

</main>

</body>
</html>