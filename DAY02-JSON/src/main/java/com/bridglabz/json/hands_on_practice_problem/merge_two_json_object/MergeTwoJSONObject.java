package com.bridglabz.json.hands_on_practice_problem.merge_two_json_object;
import com.fasterxml.jackson.databind.*;
import java.util.*;
import java.io.*;
public class MergeTwoJSONObject {
    public static void main(String[] args) {
        String jsonFilePath="C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY02-JSON\\src\\main\\java\\com\\bridglabz\\json\\hands_on_practice_problem\\merge_two_json_object\\student.json";
        String jsonFilePath1="C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY02-JSON\\src\\main\\java\\com\\bridglabz\\json\\hands_on_practice_problem\\merge_two_json_object\\contact.json";
        try{
            ObjectMapper mapper=new ObjectMapper();
            Map<String,Object> student=mapper.readValue(new File(jsonFilePath),HashMap.class);
            Map<String,Object> contact=mapper.readValue(new File(jsonFilePath1),HashMap.class);
            String outputJsonFile="C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY02-JSON\\src\\main\\java\\com\\bridglabz\\json\\hands_on_practice_problem\\merge_two_json_object\\output.json";
            student.putAll(contact);
            File outputFile=new File("outputJsonFile");
            mapper.writerWithDefaultPrettyPrinter().writeValue(outputFile,student);
            System.out.println("merged json file is: "+outputFile.getAbsolutePath());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
