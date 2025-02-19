package com.example.bridgelabz.csvdatahandling.advance_problem.validate_csv_data;
import java.io.*;
import java.util.regex.Pattern;

public class ValidateCSVDataBeforeProcessing {
    public static void main(String[] args) {
        String filePath="C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY01-CSV_DATA_HANDLING\\src\\main\\java\\com\\example\\bridgelabz\\csvdatahandling\\advance_problem\\validate_csv_data\\employee.csv";
        String line;
        String csvSplit=",";
        String emailRegex="^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern p= Pattern.compile(emailRegex);
        String phone="^\\d{10}$";
        Pattern pattern=Pattern.compile(phone);
        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            String header=br.readLine();
            System.out.println(header);
            while((line=br.readLine())!=null){
                String[] employee=line.split(csvSplit);
                String email=employee[3];
                String phoneNum=employee[4];
                boolean isEmailValid=p.matcher(email).matches();
                boolean isPhoneValid=pattern.matcher(phone).matches();
                if (!isEmailValid || !isPhoneValid) {
                    System.out.println("Invalid Row: " + line);
                    if (!isEmailValid) {
                        System.out.println("  Error Invalid Email Format - " + email);
                    }
                    if (!isPhoneValid) {
                        System.out.println("  Error Phone Number must be exactly 10 digits - " + phoneNum);
                    }
                }
            }
        }
        catch(Exception e){
           e.getStackTrace();
        }
    }
}
