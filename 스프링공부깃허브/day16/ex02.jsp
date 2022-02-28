<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<fieldset>
	<legend><b>파일 업로드</b></legend>
	<form method="POST" enctype="multipart/form-data">
		<p><input type="file" name="uploadFile"></p>
		<p><input type="text" name="memo" placeholder="설명"></p>
		<p><input type="submit" value="전송"></p>
	</form>
</fieldset>
</body>
</html>