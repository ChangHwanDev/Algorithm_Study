<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<table>
	<tr>
		<th>${dto.idx }</th>
		<th>${dto.writer}</th>
		<th>${dto.viewCount }</th>
		<th>${dto.writeDate }</th>
	</tr>
	<tr>
	<th>${dto.title}</th>
	</tr>
	<tr>
	<td>
	<pre>${dto.content }</pre>
	</td>
	</tr>
</table>
<div class="sb">
	<div>
		<a href="${cpath }/board"><button>목록</button></a>
	</div>
		<div>
		<a href="${cpath }/board"><button>수정</button></a>
		<a href="${cpath }/board"><button>삭제</button></a>
	</div>
</div>
</body>
</html>