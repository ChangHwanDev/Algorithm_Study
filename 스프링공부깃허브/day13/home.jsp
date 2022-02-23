<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h2>대문 페이지</h2>

<table border="1" cellpadding="10" cellspacing="0" width="900px" align="center">
	<tr>
		<th colspan="4">member 테이블 구성</th>
	</tr>
	<tr>
		<th width="10%">컬럼이름</th>
		<th>자료형</th>
		<th>제약조건</th>
		<th>설명</th>
	</tr>
	<tr>
		<td>userid</td>
		<td>varchar2(100)</td>
		<td>primary key (빈 값이지 않고, 다른 줄과 중복을 허용하지 않는 대표 컬럼)</td>
		<td>사용자 ID</td>
	</tr>
	<tr>
		<td>userpw</td>
		<td>varchar2(255)</td>
		<td>not null (빈 값을 허용하지 않는다)</td>
		<td>비밀번호, 중요한 개인정보이므로, Hash처리하여 저장한다</td>
	</tr>
	<tr>
		<td>username</td>
		<td>varchar2(100)</td>
		<td>not null</td>
		<td>사용자 이름</td>
	</tr>
	<tr>
		<td>email</td>
		<td>varchar2(100)</td>
		<td>not null</td>
		<td>이메일 주소</td>
	</tr>
	<tr>
		<td>birth</td>
		<td>date</td>
		<td>not null</td>
		<td>회원 생일</td>
	</tr>
	<tr>
		<td>gender</td>
		<td>varchar2(10)</td>
		<td>check(gender in ('남성', '여성', '선택안함')</td>
		<td>체크 제약조건에 의해 지정된 값 중 하나만 골라서 넣을 수 있다</td>
	</tr>
</table>
<br><br>
<details>
	<summary>SQL</summary>
	<pre>drop table member;

create table member (
    userid      varchar2(100)   primary key,
    userpw      varchar2(255)   not null,
    username    varchar2(100)   not null,
    email       varchar2(100)   not null,
    birth       date            not null,
    gender      varchar2(10)    check(gender in ('남성', '여성', '선택안함'))
);

insert into member values ('test', '1234', '테스트', 'test@itbank.com', '01/02/03', '남성');
insert into member values ('itbank', 'it', '아이티뱅크', 'it@itbank.com', '99/12/25', '여성');

select * from member;</pre>
</details>

</main>
</body>
</html>