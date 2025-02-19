package com.bridglabz.json.practice_problem.java_list_into_json_array;
import com.fasterxml.jackson.databind.*;
import java.util.*;
public class ListToJSONArray {
    public static void main(String[] args) {
        try{
            ObjectMapper mapper=new ObjectMapper();
            List<Car>cars=Arrays.asList(new Car("BMW","M5","2022"),new Car("TATA","HARRIER","2023"),new Car("AUDI","Audi A4","2024"));
            String jsonArray=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cars);
            System.out.println(jsonArray);
        }
        catch (Exception e){
            e.getMessage();
        }
    }
}
