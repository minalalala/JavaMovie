<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5" import="java.util.HashMap"%>
<%@ page import="main.tbl_view.UserView" %>
<%UserView userview = (UserView)request.getAttribute("userdata");%>
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
    
    <script language="JavaScript">
      
      function check_Data(element)
      {
 		var re_pw=/[a-zA-Z0-9]{4}/;
 		if(!re_pw.test(element.pw.value)){
 			alert("�K�X�榡���~�A�Э��s��J�A�^��μƦr(����4-8��)");
 			element.pw.focus();
 			return false;
 		}
 		
 		var re_address=/.+/;
 		if(!re_address.test(element.address.value)){
 			alert("�a�}���i���ŭ�");
 			element.address.focus();
 			return false;
 		}
 		
 		var re_phone=/[0][9][0-9]{8}/;
 		if(!re_phone.test(element.phone.value)){
 			alert("������X�榡���~�A�Э��s��J�A�Ʀr����10��");
 			element.phone.focus();
 			return false;
 		}
 		
 		var re_email=/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
 		if(!re_email.test(element.email.value)){
 			alert("�q�l�H�c�榡���~�A�Э��s��J�@��:abc123@gmail.com");
 			element.email.focus();
 			return false;
 		}
 			
 		document.userform.submit();
      }	
      
    </script>
    
</head>
<body>
	<h1>�ӤH���</h1>
    <form name="userdata" method="post" action="">
      <fieldset>
        <legend style='color:blue'>�ӤH���</legend>
        *�b�� �G<input type="text" name="id" size=20 readonly="readonly" value=<%=userview.getUserId()%>><p>
        *�K�X �G<input type="password" name="pw" size=20 value=<%=userview.getPassword() %>><p>
        *�m�W�G<input type="text" name="name" size=20 readonly="readonly" value=<%=userview.getName() %>><p> 
        *�a�}�G<input type="text" name="address" size=35 value=<%=userview.getAddress() %>><p>
        *�q�ܡG<input type="text" name="phone" size=20 value=<%=userview.getPhone() %>><p>
        *�q�l�H�c�G<input type="text" name="email" size=30 value=<%=userview.getEmail() %>><p>
        *�X�ͦ~���G<input type="date" name="birthday" size=20 readonly="readonly" value=<%=userview.getBirthday() %>><p>
			<input type="submit" value="�ק�" onclick="check_Data(userdata)">
      </fieldset>
    </form>
</body>
</html>