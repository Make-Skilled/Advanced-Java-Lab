import java.sql.*;

public class ScrollableResultSetDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "your_password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
            );

            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");

            System.out.println("--- Forward Traversal ---");
            while (rs.next()) {
                System.out.println(rs.getInt("EmpID") + ", " +
                                   rs.getString("Name") + ", " +
                                   rs.getDouble("Salary"));
            }

            System.out.println("--- Backward Traversal ---");
            while (rs.previous()) {
                System.out.println(rs.getInt("EmpID") + ", " +
                                   rs.getString("Name") + ", " +
                                   rs.getDouble("Salary"));
            }

            System.out.println("--- First Record ---");
            rs.first();
            System.out.println(rs.getInt("EmpID") + ", " + rs.getString("Name"));

            System.out.println("--- Last Record ---");
            rs.last();
            System.out.println(rs.getInt("EmpID") + ", " + rs.getString("Name"));

            System.out.println("--- 2nd Record using absolute ---");
            rs.absolute(2);
            System.out.println(rs.getInt("EmpID") + ", " + rs.getString("Name"));

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
