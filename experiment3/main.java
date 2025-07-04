import java.sql.*;

public class EmployeeCallableApp {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "your_password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            // a. Call procedure to insert employee
            CallableStatement csInsert = con.prepareCall("{call InsertEmployee(?, ?, ?)}");
            csInsert.setInt(1, 101);
            csInsert.setString(2, "Rahul");
            csInsert.setDouble(3, 50000);
            csInsert.execute();
            System.out.println("Inserted employee record.");

            // b. Call procedure to get salary
            CallableStatement csSalary = con.prepareCall("{call GetSalary(?, ?)}");
            csSalary.setInt(1, 101);
            csSalary.registerOutParameter(2, Types.DOUBLE);
            csSalary.execute();

            double salary = csSalary.getDouble(2);
            System.out.println("Salary of employee 101 is: " + salary);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
