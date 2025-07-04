<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Simple JSP Page</title></head>
<body>
    <h2>Welcome to JSP!</h2>

    <% 
        String name = "Madhu";
        out.println("<p>Hello, " + name + "!</p>");
    %>

    <p>Today's date is: <%= new java.util.Date() %></p>
</body>
</html>
