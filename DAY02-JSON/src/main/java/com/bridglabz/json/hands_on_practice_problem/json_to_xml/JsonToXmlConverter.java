package com.bridglabz.json.hands_on_practice_problem.json_to_xml;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.util.*;
public class JsonToXmlConverter {
    public static void main(String[] args) {
        try{
            Address address=new Address("Bhopal","India");
            List<String> list=List.of("Travelling","Swimming","Reading");
            Student student=new Student("Deepraj","deepraj@cg.com",20,address,list);
            XmlMapper mapper=new XmlMapper();
            String xmlString=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
            System.out.println(xmlString);
        }
        catch(Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }
}
