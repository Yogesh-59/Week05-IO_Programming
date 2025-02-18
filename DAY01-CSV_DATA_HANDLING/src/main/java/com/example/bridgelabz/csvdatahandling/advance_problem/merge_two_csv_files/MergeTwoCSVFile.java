package com.example.bridgelabz.csvdatahandling.advance_problem.merge_two_csv_files;
import java.util.*;
import java.io.*;
public class MergeTwoCSVFile {
    public static void main(String[] args) {
        String filePath1="C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY01-CSV_DATA_HANDLING\\src\\main\\java\\com\\example\\bridgelabz\\csvdatahandling\\advance_problem\\merge_two_csv_files\\student1.csv";
        String filePath2="C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY01-CSV_DATA_HANDLING\\src\\main\\java\\com\\example\\bridgelabz\\csvdatahandling\\advance_problem\\merge_two_csv_files\\students2.csv";
        String line;
        String csvSplit=",";
        String mergeFile="Desktop";
        Map<Integer,Student> map=new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath1))) {
            // Read the header row first line and ignore it
            br.readLine();
            while ((line = br.readLine()) != null) {
                // Split the line into an array of strings using the comma delimiter
                String[] studentData = line.split(csvSplit);
                // Extract the student details
                int id = Integer.parseInt(studentData[0]);
                String name = studentData[1];
                int age = Integer.parseInt(studentData[2]);
                // Create a Student object with default marks and grade
                Student student = new Student(id, name, age, 0.0, "");
                map.put(id, student);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader(filePath2))) {
            // Read the header row (first line) and ignore it
            br.readLine();
            while ((line = br.readLine()) != null) {
                // Split the line into an array of strings using the comma delimiter
                String[] studentData = line.split(csvSplit);

                // Extract the student details
                int id = Integer.parseInt(studentData[0]);
                double marks = Double.parseDouble(studentData[1]);
                String grade = studentData[2];

                // Update the corresponding student in the map
                if (map.containsKey(id)) {
                    Student student = map.get(id);
                    student = new Student(id, student.getName(), student.getAge(), marks, grade);
                    map.put(id, student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (FileWriter writer = new FileWriter(mergeFile)) {
            // Write the header row
            writer.append("ID,Name,Age,Marks,Grade\n");

            // Write each student's details to the file
            for (Student student : map.values()) {
                writer.append(student.toString()).append("\n");
            }
            System.out.println("Merged data saved to: " + mergeFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
