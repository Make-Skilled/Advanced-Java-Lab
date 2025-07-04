<%@ page import="java.sql.*" %>
<html>
<head><title>Student Records</title></head>
<body>
<h2>Student Details from Database</h2>
<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Branch</th>
</tr>
<%
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "your_password");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM students");

        while(rs.next()) {
%>
<tr>
    <td><%= rs.getInt("id") %></td>
    <td><%= rs.getString("name") %></td>
    <td><%= rs.getString("branch") %></td>
</tr>
<%
        }
        con.close();
    } catch(Exception e) {
        out.println("Database Error: " + e.getMessage());
    }
%>
</table>
</body>
</html>
