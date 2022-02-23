<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>


	<h2>로그인</h2>
<fieldset>
	<form method="POST">
		<p><input type="text" name="userid" placeholder="ID" autofocus required></p>
		<p><input type="password" name="userpw" placeholder="Password" required></p>
		<p><input type="submit" value="로그인"></p>
	</form>
</fieldset>
<br>
<p>
	<a href="${cpath }/member/forgotId">ID가 기억나지 않습니다</a>
	</p>
<p>
	<a href="${cpath }/member/forgotPassword">비밀번호를 분실했습니다</a>
	</p>
</main>

</body>
</html>