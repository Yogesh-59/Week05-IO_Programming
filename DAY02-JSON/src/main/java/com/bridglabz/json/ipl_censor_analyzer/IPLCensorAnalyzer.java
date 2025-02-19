package com.bridglabz.json.ipl_censor_analyzer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import java.util.*;
import java.io.*;
public class IPLCensorAnalyzer {
    public static void main(String[] args) {
        String jsonFilePath="C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY02-JSON\\src\\main\\java\\com\\bridglabz\\json\\ipl_censor_analyzer\\input.json";
        String jsonoutputFile="C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming";

        String csvFilePath="C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY02-JSON\\src\\main\\java\\com\\bridglabz\\json\\ipl_censor_analyzer\\input1.csv";
        String csvOutputFile="C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming";
        try{
          ProcessJsonFile json=new ProcessJsonFile(jsonFilePath,jsonoutputFile);
          json.processJsonFile();
          ProcessCsvFile csv=new ProcessCsvFile(csvFilePath,csvOutputFile);
          csv.processCsvFile();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
