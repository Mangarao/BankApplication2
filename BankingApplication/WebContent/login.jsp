<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function validateForm(){
	var ui = document.loginForm.userId.value;
	if(ui.trim()==''){
		alert("User id can't be blank.. ");
		return false;
	}
	var pwd = document.loginForm.password.value;
	if(pwd==''){
		alert("Password can't be blank.. ");
		return false;
	}
	
	if(pwd.length<6){
		alert("Password Should be min 6 characters.. ");
		return false;
	}
	
	return true;
	
}


</script>
</head>
<body style="background-color: cyan">
<div style="margin: 10%;">
<%@include file="header.html" %>
<form name="loginForm" action="loginServlet" method="post" style="text-align: center">
<span style="color: red">*</span>User id: <input type="text" name="userId"/> <br/> <br/>
<span style="color: red">*</span>Password: <input type="password" name="password"/> <br/><br/>
<input type="submit" value="Login" onclick="return validateForm();"/> &nbsp; &nbsp; <input type="reset" value="Reset">
</form>
<%@include file="footer.html" %>
</div>



</body>
</html>