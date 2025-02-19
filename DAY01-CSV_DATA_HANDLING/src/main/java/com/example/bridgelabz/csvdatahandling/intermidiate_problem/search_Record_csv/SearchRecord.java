package com.example.bridgelabz.csvdatahandling.intermidiate_problem.search_Record_csv;
import java.io.*;
import java.util.Scanner;

public class SearchRecord {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String filePath="C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY01-CSV_DATA_HANDLING\\src\\main\\java\\com\\example\\bridgelabz\\csvdatahandling\\intermidiate_problem\\search_Record_csv\\employee.csv";
        String csvSplit=",";
        String line;
        boolean found=false;
        String searchName=sc.next().trim();
        try(BufferedReader br =new BufferedReader(new FileReader(filePath))){
            br.readLine();
            while((line=br.readLine())!=null) {
                String[] employee = line.split(csvSplit);
                String name=employee[1].trim();
                if(name.equalsIgnoreCase(searchName)){
                    found=true;
                    System.out.print(employee[2]+" ");
                    System.out.printf("%s%n",employee[3]);
                }
            }
            if(found){
                System.out.println("Employee name is found");
            }
            else{
                System.out.println("Employee name is not found");
            }
        }
        catch(Exception e){
            System.out.println(e.getStackTrace());
        }
    }
}
