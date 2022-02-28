<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<fieldset>
	<legend><b>업로드 결과</b></legend>
	<p>메모 : ${memo }</p>
	<p>파일 : 
		<c:choose>
			<c:when test="${img }">
				<img src="${cpath }/upload1/${fileName}" width="200px">
			</c:when>
			<c:otherwise>
				<a href="${cpath }/upload1/${fileName}"><button>다운로드</button></a>
			</c:otherwise>
		</c:choose>
	</p>
</fieldset>

</body>
</html>