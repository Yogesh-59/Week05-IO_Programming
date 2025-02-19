package com.example.bridgelabz.csvdatahandling.advance_problem.generate_csv_report_from_database;
import java.sql.DriverManager;
import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class DatabaseToCSV {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://192.168.1.100:3306/employees_db";
        String username = "Deepraj";
        String password = "deepraj@cg";
        // Path to the output CSV file
        String csvFile = "C:\\Users\\Public\\employees.csv";

        // SQL query to fetch employee records
        String query = "SELECT employee_id, name, department, salary FROM employees";

        // Try-with-resources to automatically close the Connection, Statement, and FileWriter
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
             FileWriter writer = new FileWriter(csvFile)) {

            // Write the header row to the CSV file
            writer.append("Employee ID,Name,Department,Salary\n");

            // Iterate through the result set and write each record to the CSV file
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                double salary = resultSet.getDouble("salary");

                // Write the record to the CSV file
                writer.append(String.valueOf(employeeId)).append(",");
                writer.append(name).append(",");
                writer.append(department).append(",");
                writer.append(String.valueOf(salary)).append("\n");
            }
            System.out.println("CSV report generated successfully: " + csvFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
