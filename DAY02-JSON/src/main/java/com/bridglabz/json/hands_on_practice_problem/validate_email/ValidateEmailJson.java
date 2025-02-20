package com.bridglabz.json.hands_on_practice_problem.validate_email;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;
import java.io.IOException;
public class ValidateEmailJson {
    public static void main(String[] args) {
        String filePath="C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY02-JSON\\src\\main\\java\\com\\bridglabz\\json\\hands_on_practice_problem\\validate_email\\input.json";
        String filePath1="C:\\Users\\india\\OneDrive\\Desktop\\Week05-IO_Programming\\DAY02-JSON\\src\\main\\java\\com\\bridglabz\\json\\hands_on_practice_problem\\validate_email\\data.json";
        try {
            // Create an ObjectMapper instance
            ObjectMapper mapper = new ObjectMapper();

            // Load the JSON schema
            File schemaFile = new File(filePath);
            JsonNode schemaNode = mapper.readTree(schemaFile);
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(schemaNode);

            // Load the JSON to validate
            File jsonFile = new File(filePath1);
            JsonNode jsonNode = mapper.readTree(jsonFile);

            // Validate the JSON against the schema
            ProcessingReport report = schema.validate(jsonNode);

            // Check if the JSON is valid
            if (report.isSuccess()) {
                System.out.println("JSON is valid!");
            } else {
                System.out.println("JSON is invalid!");
                report.forEach(message -> System.out.println(message.getMessage()));
            }
        } catch (IOException | ProcessingException e) {
            e.printStackTrace();
        }
    }
}
