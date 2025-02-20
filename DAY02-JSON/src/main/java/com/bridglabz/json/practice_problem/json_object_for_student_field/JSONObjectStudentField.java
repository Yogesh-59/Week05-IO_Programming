package com.bridglabz.json.practice_problem.json_object_for_student_field;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;

public class JSONObjectStudentField {
    public static void main(String[] args) {
        //create a JSON array
        JSONArray array=new JSONArray();
        //create a JSON object for 1st student
        JSONObject student=new JSONObject();
        student.put("name","Deepraj");
        student.put("age","20");
        student.put("subjects",new JSONArray(Arrays.asList("JAVA","DBMS","DSA")));
        array.put(student);
        //create a JSON object for 2st student
        JSONObject student1=new JSONObject();
        student1.put("name","Aryan");
        student1.put("age","20");
        student1.put("subjects",new JSONArray(Arrays.asList("C++","OOPS","DSA")));
        array.put(student1);
        System.out.println(array.toString(4));

    }
}
