package com.bridglabz.json.hands_on_practice_problem.parse_json_and_filter;
import com.fasterxml.jackson.databind.*;
import java.io.*;
import java.util.*;
public class FilterJsonByAge {
    public static void main(String[] args) {
        String jsonFilePath="C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY02-JSON\\src\\main\\java\\com\\bridglabz\\json\\hands_on_practice_problem\\parse_json_and_filter\\student.csv";
        try{
            ObjectMapper mapper=new ObjectMapper();
            JsonNode node=mapper.readTree(new File(jsonFilePath));
            List<JsonNode> record=new ArrayList<>();
            for(JsonNode temp:node){
                if(temp.get("age").asInt()>25){
                    record.add(temp);
                }
            }
            String result=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(record);
            System.out.println(result);
        }
        catch(Exception e){
            e.getMessage();
        }
    }
}
