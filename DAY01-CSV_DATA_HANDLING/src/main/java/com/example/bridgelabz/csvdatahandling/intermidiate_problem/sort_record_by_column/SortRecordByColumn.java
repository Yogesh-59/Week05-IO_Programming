package com.example.bridgelabz.csvdatahandling.intermidiate_problem.sort_record_by_column;
import java.io.*;
import java.util.*;
public class SortRecordByColumn {
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY01-CSV_DATA_HANDLING\\src\\main\\java\\com\\example\\bridgelabz\\csvdatahandling\\intermidiate_problem\\sort_record_by_column\\employee.csv";
        String line;
        String csvSplitBy = ",";
        List<String[]> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String header = br.readLine();
            System.out.println(header);
            while ((line = br.readLine()) != null) {
                String[] employee = line.split(csvSplitBy);
                employees.add(employee);
            }
            employees.sort(new Comparator<String[]>() {
                @Override
                public int compare(String[] emp1, String[] emp2) {
                    double salary1 = Double.parseDouble(emp1[3]);
                    double salary2 = Double.parseDouble(emp2[3]);
                    return Double.compare(salary2, salary1);
                }
            });
            System.out.println("Top 5 Highest-Paid Employees:");
            for (int i = 0; i < Math.min(5, employees.size()); i++) {
                String[] employee = employees.get(i);
                System.out.printf("ID: %s, Name: %s, Department: %s, Salary: %.2f%n",
                        employee[0], employee[1], employee[2], Double.parseDouble(employee[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
