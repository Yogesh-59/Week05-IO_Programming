package com.bridglabz.json.hands_on_practice_problem.csv_to_json;
import java.util.*;
import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
public class CsvToJsonConverter {
    public static void main(String[] args) {
      String filePath="C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY02-JSON\\src\\main\\java\\com\\bridglabz\\json\\hands_on_practice_problem\\csv_to_json\\input.csv";
      try {
          CSVReader reader = new CSVReader(new FileReader(filePath));
          List<String[]>data=reader.readAll();
          String[] header=data.get(0);
          List<Map<String,String>> jsonData=new ArrayList<>();
          for(int i=1;i<data.size();++i){
              String []row=data.get(i);
              Map<String, String> rowMap = new HashMap<>();
              for (int j = 0; j < header.length; j++) {
                  rowMap.put(header[j], row[j]);
              }
              jsonData.add(rowMap);
          }
          ObjectMapper object=new ObjectMapper();
          String jsonString=object.writerWithDefaultPrettyPrinter().writeValueAsString(jsonData);
          System.out.println(jsonString);
      }
      catch(Exception e){
          e.printStackTrace();
      }
    }
}
