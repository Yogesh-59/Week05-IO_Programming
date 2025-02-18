package com.example.bridgelabz.csvdatahandling.basic_problem.read_and_count_rows;
import java.io.*;
public class ReadAndCountRows {
    public static void main(String[] args) {
        String filePath="C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY01-CSV_DATA_HANDLING\\src\\main\\java\\com\\example\\bridgelabz\\csvdatahandling\\basic_problem\\read_and_count_rows\\input.csv";
        String line;
        int count=0;
        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            while((line=br.readLine())!=null){
                count++;
            }
            System.out.println("Total number of Rows is: "+count);
        }
        catch(Exception e){
            e.getStackTrace();
        }
    }
}
