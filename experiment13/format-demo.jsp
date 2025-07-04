<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*" %>
<html>
<head><title>JSTL Format Tag Demo</title></head>
<body>

<h2>JSTL Format Tag Examples</h2>

<!-- Format Number -->
<fmt:formatNumber value="1234567.89" type="currency" />

<br>

<!-- Format Date -->
<%
    Date today = new Date();
    pageContext.setAttribute("today", today);
%>
<p>Today is: <fmt:formatDate value="${today}" pattern="dd-MM-yyyy" /></p>

<!-- Format Date and Time -->
<p>Current time: <fmt:formatDate value="${today}" type="both" /></p>

</body>
</html>
