package com.example.bridgelabz.csvdatahandling.intermidiate_problem.modify_csv_file;
import java.io.*;
public class ModifyCSVFile {
    public static void main(String[] args) {
            String inputFile = "C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY01-CSV_DATA_HANDLING\\src\\main\\java\\com\\example\\bridgelabz\\csvdatahandling\\intermidiate_problem\\modify_csv_file\\inputFile.csv";
        String outputFile = "C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY01-CSV_DATA_HANDLING\\src\\main\\java\\com\\example\\bridgelabz\\csvdatahandling\\intermidiate_problem\\modify_csv_file\\outputFile.csv";
        String line;
        String csvSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             FileWriter writer = new FileWriter(outputFile)) {
            //String header = br.readLine();
            writer.append("\n");
            while ((line = br.readLine()) != null) {
                String[] employee = line.split(csvSplitBy);
                String department = employee[2];
                double salary = Double.parseDouble(employee[3]);
                if (department.equalsIgnoreCase("IT")) {
                    salary *= 45;
                }
                employee[3] = String.format("%.2f", salary);
                String updatedLine = String.join(csvSplitBy, employee);

                // Write the updated line to the new CSV file
                writer.append(updatedLine).append("\n");
            }
            System.out.println("Updated records saved to: " + outputFile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
