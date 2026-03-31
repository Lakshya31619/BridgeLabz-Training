package com.lakshya.ConvertJsonToXml;
import org.json.JSONObject;
import org.json.XML;
import java.nio.file.Files;
import java.nio.file.Paths;
public class JsonToXml {
    public static void main(String[] args) {
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get("./io-programming-practice/gcr-codebase/json-data/src/main/java/com/lakshya/ConvertJsonToXml/user.json")));
            JSONObject jsonObject = new JSONObject(jsonContent);
            String xml = XML.toString(jsonObject);
            System.out.println(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}