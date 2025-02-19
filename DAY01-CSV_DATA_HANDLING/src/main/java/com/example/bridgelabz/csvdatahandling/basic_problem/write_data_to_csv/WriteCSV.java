package com.example.bridgelabz.csvdatahandling.basic_problem.write_data_to_csv;
import java.io.*;
public class WriteCSV {
    public static void main(String[] args) {
        String filePath="employee.csv";
        String csvSplit=",";
        try(FileWriter writer=new FileWriter(filePath)){
            writer.append("ID,Name,Depratment,Salary\n");
            writer.append("7,Deepraj,IT,27500.90\n");
            writer.append("2,Aryan,IT,33200.70\n");
            writer.append("4,Bipin,IT,45890.90\n");
            writer.append("25,Yogesh,IT,98980.70\n");
            writer.append("10,Rishi,EC,65400.20\n");
            System.out.println("CSV file created successfully: " + filePath);
        }
        catch(Exception e){
          e.getStackTrace();
        }
    }
}
