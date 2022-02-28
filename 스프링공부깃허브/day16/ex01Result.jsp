<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>



<fieldset>
	<legend>전송 결과</legend>
	
	<c:choose>
		<c:when test="${img }">	<!-- 이미지이면 -->
			<img src="${cpath }/upload1/${fileName}" width="200px">	<!-- 이미지 태그 -->
		</c:when>
		<c:otherwise>			<!-- 아니면 -->
			<a href="${cpath }/upload1/${fileName}">클릭</a>	<!-- 링크 -->
		</c:otherwise>
	</c:choose>
</fieldset>

</body>
</html>