package com.bridglabz.json.hands_on_practice_problem.read_json_keys_values;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.*;
import java.util.*;
public class ReadJsonKeysValues {
    static void printJsonNode(JsonNode node, String parentKey ){
        if (node.isObject()) {
            for (Iterator<Map.Entry<String, JsonNode>> it = node.fields(); it.hasNext(); ) {
                Map.Entry<String, JsonNode> field = it.next();
                printJsonNode(field.getValue(), parentKey.isEmpty() ? field.getKey() : parentKey + "." + field.getKey());
            }
        } else if (node.isArray()) {
            int index = 0;
            for (JsonNode arrayElement : node) {
                printJsonNode(arrayElement, parentKey + "[" + index + "]");
                index++;
            }
        } else {
            System.out.println(parentKey + " : " + node.asText()); // ✅ Print Key : Value
        }
    }
    public static void main(String[] args) {
        String filePath="C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY02-JSON\\src\\main\\java\\com\\bridglabz\\json\\hands_on_practice_problem\\read_json_keys_values\\input.json";
        try {
            // Create an ObjectMapper instance
            ObjectMapper mapper = new ObjectMapper();

            // Read the JSON file
            File file = new File(filePath); // Path to your JSON file
            JsonNode rootNode = mapper.readTree(file);

            // Print all keys and values
            printJsonNode(rootNode, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
