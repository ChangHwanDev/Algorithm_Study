<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="cpath" value="${pageContext.request.contextPath }" />

<section>
	<!-- board.jsp 에 있던 table과 div를 가져와서 section에 넣기 -->
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${list }">
				<tr>
					<td>${dto.idx }</td>
					<%-- <a href="${cpath}/board?idx=${dto.idx}">${dto.title}</a> --%>
					<td><a href="${cpath }/board/${dto.idx}?page=${page}&type=${param.type}&search=${param.search}">${dto.title }</a></td>
					<td>${dto.writer }</td>
					<td><fmt:formatDate value="${dto.writeDate }"
							pattern="yyyy-MM-dd HH:mm" /></td>
					<td>${dto.viewCount }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div class="sb">
		<div class="searchForm">
		<!-- 
			form 태그의 action 속성이 생략되면 현재 주소로 요청을 새로 보낸다
			만약 action속성이 지정되어 있다면 지정된 주소로 요청을 새로 보낸다
		 -->
			<form action="${cpath }/board">
				<select name="type">
					<option ${param.type == 'title' ? 'selected' : '' } value="title">제목으로 검색</option>
					<option ${param.type == 'writer' ? 'selected' : '' } value="writer">작성자로 검색</option>
					<option ${param.type == 'content' ? 'selected' : '' } value="content">내용으로 검색</option>
				</select> <input type="search" name="search" value="${param.search }" placeholder="검색어를 입력하세요">
				<input type="hidden" name="page" value="1">
				<!-- 검색어를 입력받으면 검색 내용에 관련된 목록을 1페이지부터 보여준다 -->
				<input type="submit" value="검색">
			</form>
		</div>
		<div class="writeBtn">
			<a href="${cpath }/board/write"><button>작성</button></a>
		</div>
	</div>
	<div class="sb">
		<div>
		<c:if test="${begin != 1  }">
		<span><a href="${cpath }/board?page=${begin - 1}&type=${param.type}&search=${param.search}">[이전]</a>
			</span></c:if>
			<c:forEach var="i" begin="${begin }" end="${end }">
				<span class="${page == i ? 'currentPage' : '' }" }><a href="${cpath }/board?page=${i}&type=${param.type}&search=${param.search}"> [${i }] </a></span>
			</c:forEach>
			<c:if test="${end != pageCount }">
			<span><a href="${cpath }/board?page=${end + 1}&type=${param.type}&search=${param.search}">[다음]</a>
			</span></c:if>
		</div>
	</div>
</section>


</body>
</html>