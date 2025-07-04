import java.sql.*;

public class StudentJDBCApp {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "your_password"; // Replace with your MySQL password

        try {
            // 1. Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish connection
            Connection con = DriverManager.getConnection(url, username, password);

            // 3. Create Statement object
            Statement stmt = con.createStatement();

            // a. Create Student Table
            String createTable = "CREATE TABLE IF NOT EXISTS Student (" +
                                 "RollNo INT PRIMARY KEY, " +
                                 "Name VARCHAR(50), " +
                                 "Address VARCHAR(100))";
            stmt.executeUpdate(createTable);
            System.out.println("Student table created successfully.");

            // a. Insert few records
            stmt.executeUpdate("INSERT INTO Student VALUES (1, 'John', 'Hyderabad')");
            stmt.executeUpdate("INSERT INTO Student VALUES (2, 'Alice', 'Mumbai')");
            stmt.executeUpdate("INSERT INTO Student VALUES (3, 'Bob', 'Chennai')");
            System.out.println("Initial records inserted.");

            // b. Display content of table
            System.out.println("\n--- Initial Records ---");
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM Student");
            while (rs1.next()) {
                System.out.println(rs1.getInt("RollNo") + ", " +
                                   rs1.getString("Name") + ", " +
                                   rs1.getString("Address"));
            }

            // c. Insert Two More Records
            stmt.executeUpdate("INSERT INTO Student VALUES (4, 'David', 'Delhi')");
            stmt.executeUpdate("INSERT INTO Student VALUES (5, 'Eva', 'Bangalore')");
            System.out.println("\nTwo more records inserted.");

            // d. Update One Record
            stmt.executeUpdate("UPDATE Student SET Address='Pune' WHERE RollNo=2");
            System.out.println("\nRecord updated where RollNo=2.");

            // e. Delete One Record
            stmt.executeUpdate("DELETE FROM Student WHERE RollNo=1");
            System.out.println("\nRecord deleted where RollNo=1.");

            // f. Display final records
            System.out.println("\n--- Final Records ---");
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM Student");
            while (rs2.next()) {
                System.out.println(rs2.getInt("RollNo") + ", " +
                                   rs2.getString("Name") + ", " +
                                   rs2.getString("Address"));
            }

            // Close resources
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
