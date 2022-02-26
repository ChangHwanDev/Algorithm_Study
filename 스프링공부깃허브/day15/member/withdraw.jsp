<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<h2>회원 탈퇴</h2>
	<fieldset>
		<legend><strong>경고</strong></legend>
		<ul>
			<li>탈퇴를 진행하면 기존에 작성된 모든 내용이 사라지고 복구할 수 없습니다</li>
			<li>탈퇴 사실을 번복하고 싶어도 처리할 수 없습니다</li>
			<li>탈퇴에 의해 발생하는 모든 손해에 대해 본 사이트는 책임을 지지 않습니다</li>
		</ul>
		<h4>위 내용을 잘 확인하시고 동의하시면 아래 항목을 빠짐없이 작성해주세요</h4>
		<form method="POST">
			<p>인증코드 : <input type="text" name="authCode" placeholder="${authCode }"></p>
			<p>비밀번호 : <input type="password" name="userpw" placeholder="비밀번호"></p>
			<p><input type="submit" value="탈퇴"></p>
		</form>
	</fieldset>

</main>

</body>
</html>