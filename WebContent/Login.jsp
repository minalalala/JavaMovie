<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>�n�J�|��</title>
</head>
<style>
	h2{
		color:red;
	}
</style>

<body>
	<form method="post" action="http://localhost:8080/JavaMovie/LoginController">
	<h1>�n�J�|��</h1><p>
	<%
		String msg=(String)request.getAttribute("msg");
		if(msg!=null)
			out.print("<h2>"+"�b���αK�X���~�A�Э��s��J"+"</h2>");
	%>
	�b���G<input type="text" name="USER_ID" size="20" maxlength="12"><p>
	�K�X�G<input type="password" name="PASSWORD" size="20" maxlength="8"><p>
	<input type="submit" value="�n�J">
	<input type="reset" value="����">
	</form>
</body>
</html>