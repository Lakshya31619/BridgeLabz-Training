package com.lakshya.ValidateEmail;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.nio.file.Files;
import java.nio.file.Paths;
public class EmailValidationExample {
    public static void main(String[] args) {
        try {
            String schemaContent = new String(Files.readAllBytes(Paths.get("./io-programming-practice/gcr-codebase/json-data/src/main/java/com/lakshya/ValidateEmail/schema.json")));
            JSONObject rawSchema = new JSONObject(new JSONTokener(schemaContent));
            Schema schema = SchemaLoader.load(rawSchema);
            String jsonData = new String(Files.readAllBytes(Paths.get("./io-programming-practice/gcr-codebase/json-data/src/main/java/com/lakshya/ValidateEmail/user.json")));
            JSONObject data = new JSONObject(new JSONTokener(jsonData));
            schema.validate(data);
            System.out.println("Email is valid!");
        } catch (org.everit.json.schema.ValidationException e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}