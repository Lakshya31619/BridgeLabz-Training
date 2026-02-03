package com.lakshya.PrintKeyValues;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
public class JsonPrintAll {
    public static void main(String[] args) throws Exception {
        String json = new String(Files.readAllBytes(Paths.get("./io-programming-practice/gcr-codebase/json-data/src/main/java/com/lakshya/PrintKeyValues/data.json")));
        if (json.trim().startsWith("[")) {
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                printJson(array.get(i), "");
            }
        } else {
            JSONObject obj = new JSONObject(json);
            printJson(obj, "");
        }
    }
    private static void printJson(Object json, String indent) {
        if (json instanceof JSONObject) {
            JSONObject obj = (JSONObject) json;
            Iterator<String> keys = obj.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                Object value = obj.get(key);
                System.out.println(indent + key + ": " + (value instanceof JSONObject || value instanceof JSONArray ? "" : value));
                printJson(value, indent + "  ");
            }
        } else if (json instanceof JSONArray) {
            JSONArray array = (JSONArray) json;
            for (int i = 0; i < array.length(); i++) {
                printJson(array.get(i), indent + "  ");
            }
        }
    }
}