<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>JSTL SQL Tag Demo</title></head>
<body>

<h2>JSTL SQL Tag Example</h2>

<!-- Set Data Source -->
<sql:setDataSource var="ds" driver="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/college"
    user="root"  password="root" />

<!-- Insert Student Record -->
<sql:update dataSource="${ds}">
    INSERT INTO student (rollno, name, address)
    VALUES (101, 'Madhu', 'Hyderabad')
</sql:update>

<!-- Select Student Records -->
<sql:query dataSource="${ds}" var="result">
    SELECT * FROM student
</sql:query>

<!-- Display Student Records -->
<table border="1">
<tr><th>Roll No</th><th>Name</th><th>Address</th></tr>
<c:forEach var="row" items="${result.rows}">
  <tr>
    <td>${row.rollno}</td>
    <td>${row.name}</td>
    <td>${row.address}</td>
  </tr>
</c:forEach>
</table>

</body>
</html>
