package com.lakshya.MergeJSONs;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
public class MergeJsonFiles {
    public static void main(String[] args) throws Exception {
        String json1Content = new String(Files.readAllBytes(Paths.get("./io-programming-practice/gcr-codebase/json-data/src/main/java/com/lakshya/MergeJSONs/user.json")));
        String json2Content = new String(Files.readAllBytes(Paths.get("./io-programming-practice/gcr-codebase/json-data/src/main/java/com/lakshya/MergeJSONs/details.json")));
        JSONObject json1 = new JSONObject(json1Content);
        JSONObject json2 = new JSONObject(json2Content);
        for (String key : json2.keySet()) {
            json1.put(key, json2.get(key));
        }
        System.out.println(json1.toString(2));
    }
}