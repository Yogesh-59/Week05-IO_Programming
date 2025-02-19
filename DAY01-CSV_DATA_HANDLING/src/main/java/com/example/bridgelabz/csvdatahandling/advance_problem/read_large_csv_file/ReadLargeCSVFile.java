package com.example.bridgelabz.csvdatahandling.advance_problem.read_large_csv_file;
import java.io.*;
public class ReadLargeCSVFile {
    static void processBatch(String[] batch, int totalRecordsProcessed) {
        System.out.println("Processing batch of " + batch.length + " lines...");
        for (String line : batch) {
            if (line != null) {
                System.out.println("Processed: " + line);
            }
        }
        System.out.println("Total records processed so far: " + totalRecordsProcessed);
    }
    public static void main(String[] args) {
        String filePath = "C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY01-CSV_DATA_HANDLING\\src\\main\\java\\com\\example\\bridgelabz\\csvdatahandling\\advance_problem\\read_large_csv_file\\input.csv";
        // Variable to store each line read from the file
        String line;
        String csvSplit = ",";

        // Counter track the total number of records processed
        int totalRecordsProcessed = 0;
        // Buffer size for reading lines 100 lines at a time
        int bufferSize = 100;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read the header row first line and ignore it
            br.readLine();
            // using List to temporarily store lines in the current batch
            String[] batch = new String[bufferSize];
            int batchIndex = 0;
            // Read the file line by line until the end of the file
            while ((line = br.readLine()) != null) {
                // Add the current line to the batch
                batch[batchIndex] = line;
                batchIndex++;
                // If the batch is full, process it
                if (batchIndex == bufferSize) {
                    processBatch(batch, totalRecordsProcessed);
                    totalRecordsProcessed += bufferSize;
                    batchIndex = 0; // Reset the batch index
                }
            }
            // Process any remaining lines in the last batch
            if (batchIndex > 0) {
                processBatch(batch, totalRecordsProcessed);
                totalRecordsProcessed += batchIndex;
            }
            System.out.println("Total records processed: " + totalRecordsProcessed);
        } catch (IOException e) {
            // Handle any errors that occur during file reading
            e.printStackTrace();
        }
    }
}
