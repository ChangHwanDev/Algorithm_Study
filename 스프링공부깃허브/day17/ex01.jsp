<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>ex01 - 내가 입력한 내용으로 메일 보내기</h3>
<hr>

<fieldset>
	<form method="POST">
		<p><input type="text" name="title" placeholder="제목"></p>
		<p><input type="email" name="src" placeholder="보내는 사람"></p>
		<p><input type="email" name="dst" placeholder="받는 사람"></p>
		<p><textarea style="resize: none; 
							width: 400px; 
							height: 200px"
					 placeholder="내용을 작성하세요"
					 name="content"></textarea>
		<p><input type="submit" value="전송"></p>
	</form>
</fieldset>

</body>
</html>