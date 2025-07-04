<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>JSTL Core Tag Demo</title></head>
<body>

<h2>JSTL Core Tag Examples</h2>

<!-- Set & Output -->
<c:set var="name" value="Madhu" />
<p>Hello <c:out value="${name}" />!</p>

<!-- Conditional Rendering -->
<c:if test="${name == 'Madhu'}">
  <p>Welcome, Madhu!</p>
</c:if>

<!-- Choose/When/Otherwise -->
<c:set var="role" value="admin" />
<c:choose>
  <c:when test="${role == 'admin'}">
    <p>You have administrative privileges.</p>
  </c:when>
  <c:otherwise>
    <p>You are a guest user.</p>
  </c:otherwise>
</c:choose>

<!-- Looping -->
<c:set var="colors" value="${['Red', 'Green', 'Blue']}" />
<ul>
  <c:forEach var="color" items="${colors}">
    <li>${color}</li>
  </c:forEach>
</ul>

</body>
</html>
