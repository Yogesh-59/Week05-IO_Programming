package com.example.bridgelabz.csvdatahandling.readcsvfile;
import java.io.*;
public class ReadCSVFile {
    public static void main(String[] args) {
        // Path to the CSV file
        String csvFile="C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY01-CSV_DATA_HANDLING\\src\\main\\java\\com\\example\\bridgelabz\\csvdatahandling\\readcsvfile\\input.csv";
        String line;
        //variable to store each line read from the file
        String csvSplit=",";
        try(BufferedReader br=new BufferedReader(new FileReader(csvFile))){
            // Read the file line by line until the end of the file
            while((line=br.readLine())!=null){
                String []student=line.split(csvSplit);
                String id=student[0];
                String name=student[1];
                int age=Integer.parseInt(student[2]);
                double marks=Double.parseDouble(student[3]);
                // Print the student details in a structured format
                System.out.printf("ID: %s, Name: %s, Age: %d, Marks: %.2f%n", id, name, age, marks);
            }
        }
        catch(Exception e){
            System.out.println(e.getStackTrace());
        }
    }
}
