package com.bridglabz.json.practice_problem.read_json_file;
import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

public class ReadJSONFile {
    public static void main(String[] args) {
        String jsonFilePath="C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY02-JSON\\src\\main\\java\\com\\bridglabz\\json\\practice_problem\\read_json_file\\student.json";
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode=mapper.readTree(new File(jsonFilePath));

            String name=rootNode.get("Name").asText();
            String email=rootNode.get("Email").asText();
            System.out.println("Name: "+name);
            System.out.println("Email: "+email);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
