package com.bridglabz.json.ipl_censor_analyzer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.*;
import java.util.*;
public class ProcessJsonFile {
    public String inputFile;
    public String outputFile;
    ProcessJsonFile(String input,String output){
        this.inputFile=input;
        this.outputFile=output;
    }
    public void censorMatchData(ObjectNode match) {
        // Mask team names
        match.put("team1", maskTeamName(match.get("team1").asText()));
        match.put("team2", maskTeamName(match.get("team2").asText()));

        // Redact player of the match
        match.put("player_of_match", "REDACTED");
    }
    public String maskTeamName(String teamName) {
        if (teamName == null || teamName.isEmpty()) {
            return teamName;
        }
        String[] parts = teamName.split(" ");
        if (parts.length > 1) {
            return parts[0] + " ***";
        }
        return teamName;
    }
    public void processJsonFile(){
        try{
            ObjectMapper mapper = new ObjectMapper();

            // Read the JSON file
            ArrayNode jsonArray = (ArrayNode) mapper.readTree(new FileReader(inputFile));

            // Apply censorship rules
            for (int i = 0; i < jsonArray.size(); i++) {
                ObjectNode match = (ObjectNode) jsonArray.get(i);
                censorMatchData(match);
            }

            // Write the censored JSON to a new file
            mapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(outputFile), jsonArray);
            System.out.println("Censored JSON data written to: " + outputFile);
        }
        catch(Exception e){
            e.getMessage();
        }
    }

}
