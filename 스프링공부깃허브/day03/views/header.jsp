<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day03</title>
<style>
	a{
		text-decoration: none;
		color:inherit;
	}
	nav > ul{
		display : flex;
		list-style: none;
		justify-content : space-around;
	}
</style>
</head>
<body>

	<header>
		<h1>
			<a href="${cpath}" />day03</a>
			
		</h1>
		<hr>
		<nav>
			<ul>
				<li><a href="${cpath }/ex01">ex01 (request)</a></li>
				<li><a href="${cpath }/ex02">ex02 (Model)</a></li>
				<li><a href="${cpath }/ex03">ex03 (ModelAndView)</a></li>
				<li><a href="${cpath }/ex04">ex04 (커맨드 객체)</a></li>
				<li><a href="${cpath }/ex05">ex05 (Hash Map)</a></li>
			</ul>
		</nav>
	</header>