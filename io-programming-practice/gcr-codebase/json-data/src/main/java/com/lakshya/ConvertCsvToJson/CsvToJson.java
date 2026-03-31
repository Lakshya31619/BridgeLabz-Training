package com.lakshya.ConvertCsvToJson;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
public class CsvToJson {
    public static void main(String[] args) {
        try {
            String csvContent = new String(Files.readAllBytes(Paths.get("./io-programming-practice/gcr-codebase/json-data/src/main/java/com/lakshya/ConvertCsvToJson/data.csv")));
            String[] lines = csvContent.split("\\r?\\n");
            String[] headers = lines[0].split(",");
            JSONArray jsonArray = new JSONArray();
            for (int i = 1; i < lines.length; i++) {
                String[] values = lines[i].split(",");
                JSONObject obj = new JSONObject();
                for (int j = 0; j < headers.length; j++) {
                    obj.put(headers[j], values[j]);
                }
                jsonArray.put(obj);
            }
            System.out.println(jsonArray.toString(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}