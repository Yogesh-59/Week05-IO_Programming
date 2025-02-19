package com.example.bridgelabz.csvdatahandling.advance_problem.detect_duplicates_in_csv_file;
import java.util.*;
import java.io.*;
public class DetectDuplicates {
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY01-CSV_DATA_HANDLING\\src\\main\\java\\com\\example\\bridgelabz\\csvdatahandling\\advance_problem\\detect_duplicates_in_csv_file\\input.csv";
        // Variable to store each line read from the file
        String line;
        // split used in the CSV file comma in this case
        String csvSplitBy = ",";
        // Map to track duplicate IDs and their records
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, String> duplicateRecords = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Read the header row first line and ignore it
            br.readLine();
            // Read the file line by line until the end of the file
            while ((line = br.readLine()) != null) {
                // Split the line into an array of strings using the comma delimiter
                String[] student = line.split(csvSplitBy);
                String id = student[0];
                // Check if the ID already exists in the map
                if (map1.containsKey(id)) {
                    // If it's the first duplicate, add the original record to the duplicates map
                    if (map1.get(id) == 1) {
                        duplicateRecords.put(id, line);
                    }
                    // Add the current duplicate record to the duplicates map
                    duplicateRecords.put(id + " duplicate " + map1.get(id), line);
                    // Increment the count for this ID
                    map1.put(id, map1.get(id) + 1);
                } else {
                    // Add the ID to the map with a count of 1
                    map1.put(id, 1);
                }
            }

            // Print all duplicate records
            if (duplicateRecords.isEmpty()) {
                System.out.println("No duplicate records is found.");
            } else {
                System.out.println("Duplicate Records is found:");
                for (Map.Entry<String, String> entry : duplicateRecords.entrySet()) {
                    System.out.println(entry.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
