package com.lakshya;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() { return name; }
    public int getAge() { return age; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
}
public class ListToJson {
    public static void main(String[] args) {
        try {
            List<Person> people = new ArrayList<>();
            people.add(new Person("Arsh", 25));
            people.add(new Person("Bhumi", 30));
            people.add(new Person("Charly", 22));
            ObjectMapper mapper = new ObjectMapper();
            String jsonArray = mapper.writeValueAsString(people);
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}