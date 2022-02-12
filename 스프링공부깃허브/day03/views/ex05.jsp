<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<section>
	<h2>회원 가입 예제 (커맨드 객체 활용)</h2>
	<form method="POST">
		<p>
			<input type="text" name="userid" placeholder="ID" required>
		</p>
		<p>
			<input type="password" name="userpw" placeholder="Password" required>
		</p>
		<p>
			<input type="text" name="username" placeholder="사용자 이름" required>
		</p>
		<p>
			<input type="email" name="email" placeholder="foo@bar.com" required>
		</p>
		<p>
			<input type="date" name="birth" required>
		</p>
		<p>
			<input type="submit" value="가입신청">
		</p>
	</form>
</section>
</body>
</html>