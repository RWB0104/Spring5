<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<title>회원 조회</title>
	
	<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet" />
	
	<style type="text/css">
		* {
			font-family: "Noto Sans KR", "Malgun Gothic", sans-serif;
		}
	</style>
</head>

<body>
	<form action="#" th:action="@{/members}" th:object="${cmd}" method="POST">
		<p>
			<label for="from">from</label>
			<input type="text" id="from" th:head="*{from}" />
			<span th:each="err : ${#fields.errors('from')}" th:text="${err}"></span>
			~
			<label for="to">to</label>
			<input type="text" id="to" th:head="*{to}" />
			<span th:each="err : ${#fields.errors('to')}" th:text="${err}"></span>
			
			<input type="submit" value="조회" />
		</p>
	</form>

	<table th:if="${members}">
		<tr>
			<th>아이디</th>
			<th>이메일</th>
			<th>이름</th>
			<th>가입일</th>
		</tr>
		
		<tr th:each="mem : ${members}">
			<td th:text="${mem.id}">id</td>
			<td>
				<a href="#" th:href="@{/members/{memId}(memId=${mem.id})}" th:text="${mem.email}">email</a>
			</td>
			<td th:text="${mem.name}">name</td>
			<td th:text="${#temporals.format(mem.registerDateTime, 'yyyy-MM-dd')}">dateTime</td>
		</tr>
	</table>
</body>

</html>