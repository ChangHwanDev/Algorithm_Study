<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<a href="${cpath }/board"><button>게시판 입장</button></a>

<section>

<h3>게시판 만들기 계획</h3>

<ol>
	<li>
		<details>
			<summary>데이터 모델링</summary>
			<ul>
				<li>어떤 형식의 데이터를 다루는지 결정한다</li>
				<li>데이터(게시글)의 형식이 결정되면 DB에 테이블을 작성한다</li>
				<li>DB 테이블 구조에 맞는 DTO를 만들어둔다</li>
				<li>항상 속성(field)과 기능(function, method)을 구분해야 한다</li>
			</ul>
			<table>
				<tr>
					<th>컬럼 이름</th>
					<th>자료형</th>
					<th>제약 조건</th>
					<th>설명</th>
				</tr>
				<tr>
					<td>idx</td>
					<td>number</td>
					<td>primary key</td>
					<td>게시글 번호, 자동으로 증가하기 위해 oracle DB 의 sequence를 사용할 예정</td>
				</tr>
				<tr>
					<td>title</td>
					<td>varchar2(100)</td>
					<td>not null</td>
					<td>게시글 제목, 빈 값을 저장할 수 없다, 크기 100 byte (한글 50자)</td>
				</tr>
				<tr>
					<td>writer</td>
					<td>varchar2(50)</td>
					<td>not null</td>
					<td>게시글 작성자, 빈 값을 저장할 수 없다, 크기 50 byte (한글 25자)</td>
				</tr>
				<tr>
					<td>content</td>
					<td>varchar2(2000)</td>
					<td>not null</td>
					<td>게시글 내용, 빈 값을 저장할 수 없다, 크기 2000 byte (한글 1000자)</td>
				</tr>
				<tr>
					<td>writeDate</td>
					<td>date</td>
					<td>default sysdate</td>
					<td>게시글 작성날짜, 기본값은 오늘 날짜 현재 시간</td>
				</tr>
				<tr>
					<td>viewCount</td>
					<td>number</td>
					<td>default 0</td>
					<td>게시글 조회수, 기본값은 0</td>
				</tr>
			</table>
			<fieldset>
<pre><!-- 공백, 줄바꿈 등을 모두 처리해주는 태그 -->
	create sequence board_seq
		start with 1
		maxvalue 999999999
		increment by 1
		nocycle
		nocache;

	create table board (
		idx 		number 			default board_seq.nextval primary key,
		title		varchar2(100)	not null,
		writer		varchar2(50)	not null,
		content		varchar2(2000)	not null,
		writeDate	date			default sysdate,
		viewCount	number			default 0				
	);
</pre>
			</fieldset>
		</details>
	</li>
	<li>
		<details>
			<summary>MVC 구조 만들기</summary>
			<ul>
				<li>요청을 발생시킬 수 있는 링크를 만든다</li>
				<li>요청을 받아서 처리하는 컨트롤러를 만든다</li>
				<li>컨트롤러는 서비스를 참조한다</li>
				<li>서비스는 DAO를 참조한다</li>
				<li>DAO는 myBatis형식을 통해 SQL문을 수행한다</li>
				<li>쿼리문 수행결과는 호출의 역순으로 DAO -> Service -> Controller</li>
				<li>컨트롤러에서 데이터를 Model에 추가한다</li>
				<li>JSP를 지정하여 forward를 수행한다</li>
				<li>JSP에서는 EL, JSTL을 이용하여 화면에 출력한다</li>
			</ul>
		</details>
	</li>
</ol>

</section>

</body>
</html>