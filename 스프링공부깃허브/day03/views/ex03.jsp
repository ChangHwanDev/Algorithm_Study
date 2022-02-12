<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="header.jsp" %>

<section>
	<h2>이름과 나이를 입력하여 성인/미성년자 판별하기</h2>
	
	<form method="POST">
		<p><input type="text" name="name" placeholder="이름입력" required autofocus></p>
		<p><input type="number" name="age" placeholder="나이 입력" required></p>
		<p><input type="submit" value="전송"></p>
	</form>
</section>

</body>
</html>