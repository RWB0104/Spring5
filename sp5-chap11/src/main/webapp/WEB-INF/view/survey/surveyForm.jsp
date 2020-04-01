<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<title>설문조사</title>
	
	<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet" />
	
	<style type="text/css">
		* {
			font-family: "Noto Sans KR", "Malgun Gothic", sans-serif;
		}
	</style>
</head>

<body>
	<h2>설문조사</h2>
	
	<form method="POST">
		<c:forEach var="q" items="${questions}" varStatus="status">
			<p>
				${status.index + 1}.${q.title}<br />
				
				<c:if test="${q.choice}">
					<c:forEach var="option" items="${q.options}">
						<label>
							<input type="radio" name="responses[${status.index}]" value="${option}" /> ${option}
						</label>
					</c:forEach>
				</c:if>
				
				<c:if test="${!q.choice}">
					<input type="text" name="responses[${status.index}]" />
				</c:if>
			</p>
		</c:forEach>
		
		<p>
			<label>
				응답자 위치:<br />
				<input type="text" name="res.location" />
			</label>
		</p>
		
		<p>
			<label>
				응답자 나이:<br />
				<input type="text" name="res.age" />
			</label>
		</p>
		
		<input type="submit" value="전송" />
	</form>
</body>

</html>