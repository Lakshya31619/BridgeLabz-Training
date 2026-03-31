package com.lakshya.ValidateJsonJackson;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Paths;
public class JsonValidator {
    public static void main(String[] args) {
        String filePath = "./io-programming-practice/gcr-codebase/json-data/src/main/java/com/lakshya/ValidateJsonJackson/user.json";
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(jsonContent);
            System.out.println("JSON is valid!");
            System.out.println(jsonNode.toPrettyString());
        } catch (Exception e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}