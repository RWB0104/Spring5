<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<title>메인</title>
	
	<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet" />
	
	<style type="text/css">
		* {
			font-family: "Noto Sans KR", "Malgun Gothic", sans-serif;
		}
	</style>
</head>

<body>
	<c:if test="${empty authInfo}">
		<p>환영합니다.</p>
		<p>
			<a href="<c:url value='/register/step1' />">[회원 가입하기]</a>
			<a href="<c:url value='/login' />">[로그인]</a>
		</p>
	</c:if>
	
	<c:if test="${!empty authInfo}">
		<p>${authInfo.name}님, 환영합니다.</p>
		<p>
			<a href="<c:url value='/edit/changePassword' />">[비밀번호 변경]</a>
			<a href="<c:url value='/logout' />">[로그아웃]</a>
		</p>
	</c:if>
</body>

</html>