<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>

<h1><a href="${cpath }">파일 업로드</a></h1>
<hr>

<nav>
	<ul>
		<li><a href="${cpath }/ex01">ex01 - 파일 업로드 기초</a></li>
		<li><a href="${cpath }/ex02">ex02 - 파일 업로드 기초 (Service)</a></li>
		<li><a href="${cpath }/ex03">ex03 - 파일 업로드 기초 (DTO)</a></li>
	</ul>
</nav>

