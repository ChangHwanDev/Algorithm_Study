<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<section>
<form method="POST">
	<table>
		<tr>
			<th><input type="text" 
					   name="writer" 
					   placeholder="작성자"
					   value="${dto.writer }" 
					   required></th>
		</tr>
		<tr>
			<th><input type="text" 
					   name="title" 
					   placeholder="제목"
					   value="${dto.title }" 
					   required></th>
		</tr>
		<tr>
			<td>
				<textarea name="content" 
						  placeholder="바르고 고운말을 씁시다" 
						  required>${dto.content }</textarea>
			</td>
		</tr>
	</table>

	<div class="sb">
		<div>
			<!--  <button>작성취소</button> -->
			<a href="${cpath }/board">
				<input type="button" value="작성취소">
			</a>
			<!-- form 태그 내부의 button 태그는 submit(제출)을 수행한다 -->
			<!-- <input type="button">은 submit을 수행하지 않는다 -->
		</div>
		<div>
			<button>작성완료</button>
		</div>
	</div>

</form>

</section>

</body>
</html>