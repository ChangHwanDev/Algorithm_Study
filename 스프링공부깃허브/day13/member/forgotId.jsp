<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<fieldset>
<h4>이메일 주소와 생년월일을 입력해주세요</h4>
	<form method="POST">
		<p><input type="email" name="email" placeholder="가입 시 입력했던이메일 주소"></p>
		<p><input type="date" name="birth" ></p>
		<p><input type="submit" value="ID 찾기"></p>
	</form>
</fieldset>

</main>
</body>
</html>