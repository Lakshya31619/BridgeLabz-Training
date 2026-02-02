import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DatabaseToCSV {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/companydb";
        String username = "root";
        String password = "password";
        String csvFile = "./io-programming-practice/gcr-codebase/csv-data-handling/csv-from-database/employees_report.csv";
        try (
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = connection.createStatement();
            FileWriter writer = new FileWriter(csvFile)
        ) {
            String sql = "SELECT emp_id, name, department, salary FROM employees";
            ResultSet resultSet = statement.executeQuery(sql);
            writer.append("Employee ID,Name,Department,Salary\n");
            while (resultSet.next()) {
                int id = resultSet.getInt("emp_id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                double salary = resultSet.getDouble("salary");

                writer.append(id + "," + name + "," + department + "," + salary + "\n");
            }
            System.out.println("CSV report generated successfully: " + csvFile);
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("File writing error: " + e.getMessage());
        }
    }
}