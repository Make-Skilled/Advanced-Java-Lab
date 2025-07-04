<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Result</title></head>
<body>
<%
    String n1 = request.getParameter("num1");
    String n2 = request.getParameter("num2");
    
    int a = Integer.parseInt(n1);
    int b = Integer.parseInt(n2);
    int sum = a + b;
%>

<h2>The sum of <%= a %> and <%= b %> is: <%= sum %></h2>
</body>
</html>
