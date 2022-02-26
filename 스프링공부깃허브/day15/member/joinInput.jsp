<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h2>회원 가입 정보 입력</h2>

<form method="POST">
	<div class="sb">
		<strong>ID</strong>
		<div>
			<input type="text" name="userid" placeholder="사용할 ID 입력" required autofocus>
		</div>
	</div>
	<div class="sb">	
		<strong>Password</strong>
		<div>
			<input type="password" name="userpw" placeholder="Password" required>
		</div>
	</div>
	<div class="sb">			
		<strong>이름</strong>
		<div>
			<input type="text" name="username" placeholder="이름을 입력하세요" required>
		</div>
	</div>
	<div class="sb">	
		<strong>E-Mail</strong>
		<div>
			<input type="email" name="email" placeholder="이메일 주소 입력하세요" required>
		</div>
	</div>
	<div class="sb">	
		<strong>생년월일</strong>
		<div>
			<input type="date" name="birth" required>
		</div>
	</div>
	<div class="sb">	
		<strong>성별</strong>
		<div>
			<select name="gender">
				<option value="남성">남성</option>
				<option value="여성">여성</option>
				<option value="선택안함">선택안함</option>
			</select>
		</div>
	</div>
	<input type="submit" value="가입신청">
</form>

</body>
</html>