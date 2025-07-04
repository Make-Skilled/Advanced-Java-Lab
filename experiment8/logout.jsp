<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%
    session = request.getSession(false);
    if (session != null) {
        session.invalidate();
    }
    Cookie ck = new Cookie("username", "");
    ck.setMaxAge(0);
    response.addCookie(ck);
%>
<h2>You have successfully logged out!</h2>
<a href="login.html">Login Again</a>
