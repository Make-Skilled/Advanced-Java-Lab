<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Include Demo</title></head>
<body>
    <h2>This is the Main JSP Page</h2>
    
    <jsp:include page="included.jsp" />
    
    <p>Back in the main JSP after including.</p>
</body>
</html>
