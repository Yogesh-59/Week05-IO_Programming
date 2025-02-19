package com.example.bridgelabz.csvdatahandling.advance_problem.csv_data_into_java_objects;
import java.io.*;
import java.util.*;
public class CSVDataIntoJavaObjects {
    public static void main(String[] args) {
      String filePath="C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY01-CSV_DATA_HANDLING\\src\\main\\java\\com\\example\\bridgelabz\\csvdatahandling\\advance_problem\\csv_data_into_java_objects\\student.csv";
      String line;
      String csvSplit=",";
      List<Student> student=new ArrayList<>();
      try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
          br.readLine();
          while((line=br.readLine())!=null){
              String []stu=line.split(csvSplit);
              int id=Integer.parseInt(stu[0]);
              String name=stu[1];
              int age=Integer.parseInt(stu[2]);
              double marks=Double.parseDouble(stu[3]);

              Student student1=new Student(id,name,age,marks);
              student.add(student1);

          }
          System.out.println("List of Students");
          for(Student s:student){
              System.out.println(s);
          }
      }
      catch(Exception e){
          e.getStackTrace();
      }
    }
}
