package com.lakshya.ParseJsonFilterRecords;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
public class JsonFilter {
    public static void main(String[] args) throws Exception {
        String json = new String(Files.readAllBytes(Paths.get("./io-programming-practice/gcr-codebase/json-data/src/main/java/com/lakshya/ParseJsonFilterRecords/people.json")));
        JSONArray array = new JSONArray(json);
        JSONArray filtered = new JSONArray();
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);
            if (obj.getInt("age") > 25) {
                filtered.put(obj);
            }
        }
        System.out.println(filtered.toString(2));
    }
}