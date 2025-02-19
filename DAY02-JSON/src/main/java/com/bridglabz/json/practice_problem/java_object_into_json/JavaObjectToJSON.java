package com.bridglabz.json.practice_problem.java_object_into_json;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaObjectToJSON {
    public static void main(String[] args) {
        try {
            // Create a Car object
            Car car = new Car("BMW", "BMWi7", 2025);

            // Create an ObjectMapper instance
            ObjectMapper mapper = new ObjectMapper();

            // Convert the Car object to JSON
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(car);

            // Print the JSON string
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}