package com.bridglabz.json.practice_problem.validate_json_file;
import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
public class ValidateJSONFile {
    public static void main(String[] args) {
        String filePath="C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY02-JSON\\src\\main\\java\\com\\bridglabz\\json\\practice_problem\\validate_json_file\\student.json";
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(new File(filePath));
            if(node.has("name") && node.has("age") && node.has("email")){
                System.out.println("JSON file is valid");
            }
            else{
                System.out.println("JSON file field is missing");
            }
        }
        catch(Exception e){
            System.out.println("Invalid JSON format");
            e.printStackTrace();
        }
    }
}
