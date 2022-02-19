<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<section>

<table>
	<tr>
		<th>${dto.idx }</th>
		<th>${dto.writer }</th>
		<th>조회수 : ${dto.viewCount }</th>
		<th><fmt:formatDate value="${dto.writeDate }"
							pattern="yyyy-MM-dd HH:mm" /></th>
	</tr>
	<tr>
		<th>${dto.title }</th>
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
		<a href="${cpath }/board/modify/${dto.idx}">
			<button>수정</button></a>
		
		<a href="${cpath }/board/delete/${dto.idx }">
			<button>즉시 삭제</button></a>
		
		<button id="deleteBtn" data-idx="${dto.idx }">script 삭제</button>
	</div>
</div>

</section>

<jsp:include page="list.jsp" />

<script>
	// 버튼을 클릭하면 작동하는 이벤트 함수
	function deleteBoard(event) {
		const idx = event.target.dataset.idx	// 클릭된 버튼의 data-idx값 불러오기
		const flag = confirm(idx + '번 글을 삭제하시겠습니까?')	// 물어보기
		if(flag) {	// 확인이면 true, 취소면 false
			location.href = '${cpath}/board/delete/' + idx
			// a 태그와 마찬가지로 페이지 이동 (get방식 요청)
		}
	}
	// 문서에서 deleteBtn이라는 id를 가지는 요소를 클릭하면 deleteBoard 함수가 실행되게 연결
	document.getElementById('deleteBtn').onclick = deleteBoard
	
</script>

</body>
</html>