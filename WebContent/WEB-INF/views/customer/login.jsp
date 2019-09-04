<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>은행 관리 시스템</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<div>
	<h2>로그인</h2>
	<form action=""></form>
	
	<form id = "login_form" action = "<%=request.getContextPath()%>/member.do?action=login">
		아이디<input type = "text"  name = "id"/><br/>
		비밀번호<input type = "text"  name = "pwd"/><br/>
		<input type = "submit" id = "btn" value = "전송">
	</form>
</div>
<script>

$('#login_form').submit(function(){
	alert('테스트 맥락 5 !!');
});
</script>
</body>
</html>