<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<title>회원가입</title>
	
	<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet" />
	
	<style type="text/css">
		* {
			font-family: "Noto Sans KR", "Malgun Gothic", sans-serif;
		}
	</style>
</head>

<body>
	<h2>회원 정보 입력</h2>
	
	<form:form action="step3" modelAttribute="registerRequest">
		<p>
			<label>
				이메일:<br />
				<form:input path="email" />
			</label>
		</p>
		
		<p>
			<label>
				이름:<br />
				<form:input path="name" />
			</label>
		</p>
		
		<p>
			<label>
				비밀번호:<br />
				<form:password path="password" />
			</label>
		</p>
		
		<p>
			<label>
				비밀번호 확인:<br />
				<form:password path="confirmPassword" />
			</label>
		</p>
		
		<input type="submit" value="가입 완료" />
	</form:form>
</body>

</html>