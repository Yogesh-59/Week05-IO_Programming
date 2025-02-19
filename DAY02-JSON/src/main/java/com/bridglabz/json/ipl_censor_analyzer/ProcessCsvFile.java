package com.bridglabz.json.ipl_censor_analyzer;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import java.util.*;
import java.io.*;
public class ProcessCsvFile {
    public String inputFile;
    public String outputFile;
    ProcessCsvFile(String input,String output){
        this.inputFile=input;
        this.outputFile=output;
    }
    public String maskTeamName(String teamName) {
        if (teamName == null || teamName.isEmpty()) {
            return teamName;
        }
        String[] parts = teamName.split(" ");
        if (parts.length > 1) {
            return parts[0] + " ***";
        }
        return teamName;
    }
    public void processCsvFile(){
        try {
            CSVReader reader = new CSVReader(new FileReader(inputFile));
            List<String[]> csvData = reader.readAll();

            // Apply censorship rules
            for (int i = 1; i < csvData.size(); i++) { // Skip header row
                String[] row = csvData.get(i);
                row[1] = maskTeamName(row[1]); // team1
                row[2] = maskTeamName(row[2]); // team2
                row[3] = "REDACTED"; // player_of_match
            }

            // Write the censored CSV to a new file
            CSVWriter writer = new CSVWriter(new FileWriter(outputFile));
            writer.writeAll(csvData);
            writer.close();
            System.out.println("Censored CSV data written to: " + outputFile);
        }
        catch(Exception e){
            e.getMessage();
        }
    }
}
