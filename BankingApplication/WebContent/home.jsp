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
<h3><a href="checkBalanceServlet">1. Check Balance</a></h3>
<h3><a href="deposit.jsp">2. Deposit</a></h3>
<h3><a href="withdraw.jsp">3. Withdraw</a></h3>
<h3><a href="transfer.jsp">4. Transfer</a></h3>
<h3><a href="exitServlet">5. Exit</a></h3>
<%@include file="footer.html" %>
</div>



</body>
</html>