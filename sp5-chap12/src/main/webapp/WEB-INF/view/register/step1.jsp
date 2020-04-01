<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<title>
		<spring:message code="member.register" />
	</title>
	
	<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet" />
	
	<style type="text/css">
		* {
			font-family: "Noto Sans KR", "Malgun Gothic", sans-serif;
		}
	</style>
</head>

<body>
	<h2>
		<spring:message code="term" />
	</h2>
	
	<p>약관 내용</p>
	
	<form action="step2" method="POST">
		<label>
			<input type="checkbox" name="agree" value="true" />
			<spring:message code="term.agree" />
		</label>
		
		<input type="submit" value="<spring:message code="next.btn" />" />
	</form>
</body>

</html>