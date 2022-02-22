<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day12 - member</title>
<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/style.css">
</head>
<body>

<header>
	<h1><a href="${cpath }">day11 - member</a></h1>
	<div class="info">
		<c:if test="${not empty login }">
			${login.username } (${login.userid })
		</c:if>
	</div>
	<c:set var="loginURL" value="${empty login ? 'login' : 'logout' }" />
	<c:set var="loginMenu" value="${empty login ? '로그인' : '로그아웃' }" />
	<nav>
		<ul>
			<li><a href="${cpath }/member/memberList">회원 목록</a></li>
			<li><a href="${cpath }/member/${loginURL}">${loginMenu }</a></li>
			<li><a href="${cpath }/member/join">회원 가입</a></li>
			<li><a href="${cpath }/member/mypage">마이페이지</a></li>
			<li><a href="${cpath }/member/withdraw">탈퇴</a></li>
		</ul>
	</nav>
</header>

<main>