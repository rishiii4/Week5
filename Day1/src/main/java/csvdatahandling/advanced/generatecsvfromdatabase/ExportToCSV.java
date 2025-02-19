package csvdatahandling.advanced.generatecsvfromdatabase;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class ExportToCSV {
    public static void main(String[] args) {
        String jdbcURL = "root@localhost:3306";
        String username = "root";
        String password = "1234";
        String csvFile = "employees.csv";

        String query = "SELECT id, name, department, salary FROM employees";

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {

            // Write CSV Header
            writer.write("Employee ID,Name,Department,Salary\n");

            // Write Data Rows
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                writer.write(id + "," + name + "," + department + "," + salary + "\n");
            }

            System.out.println("CSV file generated successfully: " + csvFile);

        } catch (SQLException | IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

