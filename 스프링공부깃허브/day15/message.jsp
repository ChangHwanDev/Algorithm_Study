<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<%--
		1) HTML 태그로 보여주기
		2) Javascript alert() 함수로 보여주기
		3) Javascript modal 형식으로 보여주기
		4) E-mail로 보내주기	(백엔드에서 이메일로 발송해야함)
 --%>

	<fieldset>
		<h3>${message }</h3>
	</fieldset>

</main>

<script>
	alert('${message}')
</script>

</body>
</html>