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
	<h2>약관</h2>
	<p>약관 내용</p>
	
	<form action="step2" method="POST">
		<label>
			<input type="checkbox" name="agree" value="true" />약관 동의
		</label>
		
		<input type="submit" value="다음 단계" />
	</form>
</body>

</html>