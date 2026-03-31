package com.lakshya.ConvertObjectToJson;
import com.google.gson.Gson;
public class CarToJson {
    public static void main(String[] args) {
        Car car = new Car("Swift", "Dezire", 2022);
        Gson gson = new Gson();
        String json = gson.toJson(car);
        System.out.println(json);
    }
}