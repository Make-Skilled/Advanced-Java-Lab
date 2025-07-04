import java.sql.*;

public class UpdatableResultSetDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "your_password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE
            );

            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");

            while (rs.next()) {
                if (rs.getInt("EmpID") == 101) {
                    rs.updateDouble("Salary", 60000.0);
                    rs.updateRow();
                    System.out.println("Updated salary for EmpID 101.");
                }
            }

            rs.beforeFirst();
            System.out.println("--- Updated Employee Records ---");
            while (rs.next()) {
                System.out.println(rs.getInt("EmpID") + ", " +
                                   rs.getString("Name") + ", " +
                                   rs.getDouble("Salary"));
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
