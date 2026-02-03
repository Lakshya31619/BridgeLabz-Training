package com.lakshya.ReadExtractFields;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
public class ReadJsonFile {
    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("./io-programming-practice/gcr-codebase/json-data/src/main/java/com/lakshya/ReadExtractFields/user.json")));
        JSONObject json = new JSONObject(content);
        String name = json.getString("name");
        String email = json.getString("email");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}