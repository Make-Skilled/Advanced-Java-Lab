<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head><title>JSTL Function Tag Demo</title></head>
<body>

<h2>JSTL Function Tag Examples</h2>

<c:set var="username" value="MadhuParvathaneni" />
<p>Original String: ${username}</p>

<!-- String length -->
<p>Length: ${fn:length(username)}</p>

<!-- Convert to upper case -->
<p>Upper Case: ${fn:toUpperCase(username)}</p>

<!-- Convert to lower case -->
<p>Lower Case: ${fn:toLowerCase(username)}</p>

<!-- Check if string contains -->
<p>Contains 'Parva'? ${fn:contains(username, "Parva")}</p>

<!-- Check if string starts with -->
<p>Starts with 'Madhu'? ${fn:startsWith(username, "Madhu")}</p>

<!-- Substring -->
<p>Substring (0-5): ${fn:substring(username, 0, 5)}</p>

</body>
</html>
