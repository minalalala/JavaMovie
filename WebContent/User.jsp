<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5" import="java.util.HashMap"%>
<%@ page import="main.tbl_view.UserView" %>
<%
UserView userview = (UserView)request.getAttribute("userdata");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>�ӤH���</title>
<style type="text/css">
      fieldset {
	    width:400px;
		border:#000 3px double;
      }	
    </style>
</head>
<body>
	<h1>�ӤH���</h1>
    <form name="userdata" method="post" action="">
      <fieldset>
        <legend style='color:blue'>�ӤH���</legend>
        *�b�� �G<input type="text" name="id" size=20 readonly="readonly" value=<%=userview.getUserId()%>><p>
        *�K�X �G<input type="password" name="pw" size=20 readonly="readonly" value=<%=userview.getPassword() %>><p>
        *�m�W�G<input type="text" name="name" size=20 readonly="readonly" value=<%=userview.getName() %>><p> 
        *�a�}�G<input type="text" name="address" size=35 readonly="readonly" value=<%=userview.getAddress() %>><p>
        *�q�ܡG<input type="text" name="phone" size=20 readonly="readonly" value=<%=userview.getPhone() %>><p>
        *�q�l�H�c�G<input type="text" name="email" size=30 readonly="readonly" value=<%=userview.getEmail() %>><p>
        *�X�ͦ~���G<input type="date" name="birthday" size=20 readonly="readonly" value=<%=userview.getBirthday() %>><p>

      </fieldset>
    </form>
</body>
</html>