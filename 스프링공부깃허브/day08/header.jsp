<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board (day08)</title>
<style>
	div, span, h1, h2, h3, h4, h5, h6, body, header, section {
		margin: 0;
		padding: 0;
	}
	body {
		width: 100%;
		padding: 20px 0;
	}
	h1 {
		padding-left: 20px;
	}
	section {
		min-width: 800px;
		max-width: 1400px;
		margin: 10px auto;
		padding: 20px;
		box-sizing: border-box;
	}
	a {
		text-decoration: none;	/* 글자 꾸밈 요소 (밑줄) 을 제거한다 */
		color: inherit;			/* 글자색상은 상위 요소에서 상속해주는 값을 사용한다 (기본 : 검정) */
	}
	a:hover {
		text-decoration: underline;	/* a태그에 마우스를 올리면 밑줄 상태로 변경한다 */
	}
	table {
		border-collapse: collapse;
		width: 100%;
	}
	thead > tr {
		background-color: lightgrey;
		color: black;
		font-size: 19px;
		font-weight: bold;
		text-align: center;
	}
	tbody > tr > td:first-child {
		text-align: center; 
	}
	tbody > tr > td:nth-child(2) {
		width: 50%;
	}
	tbody > tr > td:nth-child(2) > a {
		display: block;
		margin: 0;
		width: 100%;
		height: auto;
	}
	tbody > tr {
		height: 35px;
		border-bottom: 1px solid black;
	}
	pre {
		font-family: '나눔고딕';
		font-size: 20px;
		min-height: 500px;
		text-align: left;
		padding-left: 10px;
	}
	.sb {
		box-sizing: border-box;
		margin: 20px auto;
		display: flex;
		width: 100%;
		justify-content: space-between;
	}
	input[type="button"],
	button {
		background-color: lightgrey;
		color: black;
		font-size: 17px;
		border: 0;
		border-radius: 20px;
		width: 120px;
		height: 40px;
		font-weight: bold;
		transition-duration: 0.5s;
		cursor: pointer;
	}
	input[type="button"]:hover,
	button:hover {
		background-color: black;
		transition-duration: 0.5s;
		color: white;
	}
	
	/*board*/
	form[method="POST"] table > tbody > tr {
		border: 0;
	}
	form[method="POST"] table > tbody > tr > th {
		text-align: left;
	}
	form[method="POST"] input[type="text"] {
		all: unset;
		padding: 10px;
		font-size: 18px;
		border: 0;
		width: 50%;
		border-bottom: 2px solid black;
	}
	form[method="POST"] textarea {
		min-height: 500px;
		width: 100%;
		resize: none;
		box-sizing: border-box;
		padding: 20px;
		font-family: '나눔고딕';
		font-size: 17px;
		margin: 20px auto;
	}
	
	
</style>
</head>
<body>

<h1><a href="${cpath }/">day08 - 간단 게시판 만들기</a></h1>
<hr>
