<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<fieldset>
	<legend><b>파일 업로드 (DTO)</b></legend>
	<form method="POST" enctype="multipart/form-data">
		<p><input type="file" name="uploadFile"></p>
		<p><input type="text" name="memo" placeholder="설명"></p>
		<p><input type="submit" value="전송"></p>
	</form>
</fieldset>

<div style="display: flex; 
			width: 1000px;
			margin: auto; 
			padding: 10px; 
			flex-flow: wrap; 
			align-items: center"> 
	<c:forEach var="fileName" items="${arr }">
		<div style="margin: 10px;
					box-shadow: 10px 10px 10px grey">
			<img src="${cpath }/upload1/${fileName}" width="100px">
		</div>
	</c:forEach>
</div>


</body>
</html>