<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<title>
		<spring:message code="change.pwd.title" />
	</title>
	
	<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet" />
	
	<style type="text/css">
		* {
			font-family: "Noto Sans KR", "Malgun Gothic", sans-serif;
		}
	</style>
</head>

<body>
	<form:form>
		<p>
			<label>
				<spring:message code="currentPassword" />:<br />
				<form:input path="currentPassword" />
				<form:errors path="currentPassword" />
			</label>
		</p>
		
		<p>
			<label>
				<spring:message code="newPassword" />:<br />
				<form:input path="newPassword" />
				<form:errors path="newPassword" />
			</label>
		</p>
		
		<input type="submit" value="<spring:message code="change.btn" />" />
	</form:form>
</body>

</html>