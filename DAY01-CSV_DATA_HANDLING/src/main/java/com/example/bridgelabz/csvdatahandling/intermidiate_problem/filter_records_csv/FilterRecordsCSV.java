package com.example.bridgelabz.csvdatahandling.intermidiate_problem.filter_records_csv;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
public class FilterRecordsCSV {
    public static void main(String[] args) {
        String filePath="C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY01-CSV_DATA_HANDLING\\src\\main\\java\\com\\example\\bridgelabz\\csvdatahandling\\intermidiate_problem\\filter_records_csv\\student_data.csv";
        String csvSplit=",";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            String header=br.readLine();
            while((line=br.readLine())!=null){
                String[] student=line.split(csvSplit);
                double marks=Double.parseDouble(student[3]);
                if(marks > 80) {
                    // Print the qualifying student record
                    System.out.println(line);
                }
            }
        }
        catch(Exception e){
            e.getStackTrace();
        }
    }
}
