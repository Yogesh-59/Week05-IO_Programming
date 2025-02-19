package com.bridglabz.json.hands_on_practice_problem.database_to_json;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseToJsonWithPojo {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/MySql";
        String username = "Deepraj";
        String password = "deepraj@cg";

        try {
            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query to fetch records
            String query = "SELECT * FROM employees";
            ResultSet resultSet = statement.executeQuery(query);

            // Convert ResultSet to a list of Employee objects
            List<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String department = resultSet.getString("department");
                double salary = resultSet.getDouble("salary");
                employees.add(new Employee(id, name, email, department, salary));
            }

            // Close the database resources
            resultSet.close();
            statement.close();
            connection.close();

            // Create an ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            // Convert the list of Employee objects to JSON
            String jsonString = mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(employees);

            // Print the JSON report
            System.out.println(jsonString);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
