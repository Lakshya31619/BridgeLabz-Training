package com.lakshya;
import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class JsonReportFromDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "password";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            String query = "SELECT id, name, age, email FROM users";
            ResultSet rs = stmt.executeQuery(query);
            JSONArray jsonArray = new JSONArray();
            while (rs.next()) {
                JSONObject obj = new JSONObject();
                obj.put("id", rs.getInt("id"));
                obj.put("name", rs.getString("name"));
                obj.put("age", rs.getInt("age"));
                obj.put("email", rs.getString("email"));
                jsonArray.put(obj);
            }
            System.out.println(jsonArray.toString(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}