<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: cyan">
<div style="margin: 10%;">
<%@include file="header.html" %>
<h1> Withdraw screen..... </h1>
<form action="withdrawServlet" method="post">
Enter amount to withdraw: <input type="text" name="withdrawAmount"><br/>
<input type="submit" value="Deposit"> &nbsp; &nbsp; <input type="reset" value="Reset">


</form>

</div>



</body>
</html>