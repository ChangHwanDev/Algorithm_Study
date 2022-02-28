<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<fieldset>
	<legend><b>ex01 - 파일 업로드 기초</b></legend>
	<form method="POST" enctype="multipart/form-data">
		<p><input type="file" name="uploadFile" accept="image/*" multiple></p>
		<p><input type="submit" value="전송"></p>
	</form>
	<ul>
		<li>HTTP Method GET은 거의 대부분 문자열 파라미터를 전송하는데에만 사용한다</li>
		<li>파라미터의 크기가 크거나, 문자열로 표현 불가능한 형태라면 POST를 사용한다</li>
		<li>form-data가 파일을 포함한다면, 파일을 여러 단위로 분할하여 전송하도록 지정해야 한다</li>
		<li>multipart/form-data, 파일을 여러 단위로 분할하여 전송</li>
		<li>servlet-context.xml 에서 파일 업로드를 처리하는 스프링 빈(multipartResolver)을 등록해야 한다</li>
		<li>업로드 된 파일을 참조할 수 있도록 resources 태그를 추가 작성하여 경로를 설정한다</li>
		<li>input type="file" 이면 value를 절대 지정할 수 없다</li>
		<li>input type="file" 일때 accept 속성으로 업로드 유형을 지정할 수 있다(강제성은 없음)</li>
		<li>input type="file" 일때 multiple 속성을 부여하면, 여러 파일을 지정할 수 있다</li>
		
	</ul>
</fieldset>

</body>
</html>