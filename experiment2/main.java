import java.sql.*;

public class StudentPreparedStatementApp {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "your_password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Student (" +
                               "RollNo INT PRIMARY KEY, Name VARCHAR(50), Address VARCHAR(100))");

            String insertSQL = "INSERT INTO Student VALUES (?, ?, ?)";
            PreparedStatement psInsert = con.prepareStatement(insertSQL);

            psInsert.setInt(1, 1);
            psInsert.setString(2, "John");
            psInsert.setString(3, "Hyderabad");
            psInsert.executeUpdate();

            psInsert.setInt(1, 2);
            psInsert.setString(2, "Alice");
            psInsert.setString(3, "Mumbai");
            psInsert.executeUpdate();

            psInsert.setInt(1, 3);
            psInsert.setString(2, "Bob");
            psInsert.setString(3, "Chennai");
            psInsert.executeUpdate();

            System.out.println("--- Initial Records ---");
            PreparedStatement psSelect = con.prepareStatement("SELECT * FROM Student");
            ResultSet rs1 = psSelect.executeQuery();
            while (rs1.next()) {
                System.out.println(rs1.getInt("RollNo") + ", " +
                                   rs1.getString("Name") + ", " +
                                   rs1.getString("Address"));
            }

            psInsert.setInt(1, 4);
            psInsert.setString(2, "David");
            psInsert.setString(3, "Delhi");
            psInsert.executeUpdate();

            psInsert.setInt(1, 5);
            psInsert.setString(2, "Eva");
            psInsert.setString(3, "Bangalore");
            psInsert.executeUpdate();

            String updateSQL = "UPDATE Student SET Address=? WHERE RollNo=?";
            PreparedStatement psUpdate = con.prepareStatement(updateSQL);
            psUpdate.setString(1, "Pune");
            psUpdate.setInt(2, 2);
            psUpdate.executeUpdate();

            String deleteSQL = "DELETE FROM Student WHERE RollNo=?";
            PreparedStatement psDelete = con.prepareStatement(deleteSQL);
            psDelete.setInt(1, 1);
            psDelete.executeUpdate();

            System.out.println("--- Final Records ---");
            ResultSet rs2 = psSelect.executeQuery();
            while (rs2.next()) {
                System.out.println(rs2.getInt("RollNo") + ", " +
                                   rs2.getString("Name") + ", " +
                                   rs2.getString("Address"));
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
