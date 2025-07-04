<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<body>
<%
    // 1. Cookie
    String userFromCookie = null;
    Cookie[] cks = request.getCookies();
    if (cks != null) {
        for (Cookie ck : cks) {
            if (ck.getName().equals("username")) {
                userFromCookie = ck.getValue();
                break;
            }
        }
    }

    // 2. HttpSession
    HttpSession session = request.getSession(false);
    String userFromSession = (session != null) ? (String) session.getAttribute("username") : null;

    // 3. URL Rewriting
    String userFromURL = request.getParameter("user");
%>

<h2>Welcome <%= userFromURL %> (via URL Rewriting)</h2>
<h3>From Session: <%= userFromSession %></h3>
<h3>From Cookie: <%= userFromCookie %></h3>

<a href="logout.jsp">Logout</a>
</body>
</html>
