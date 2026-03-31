import java.io.*;
import java.util.ArrayList;
public class SerializationMain{
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Aryan", "IT", 60000));
        employees.add(new Employee(102, "Rohit", "HR", 45000));
        employees.add(new Employee(103, "Prem", "Finance", 55000));
        String filename = "./collections-practice/gcr-codebase/streams/files/employees.txt";
        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employees);
            System.out.println("Employee data serialized successfully.");
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }
        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            ArrayList<Employee> empList = (ArrayList<Employee>) ois.readObject();
            System.out.println("\nDeserialized Employee Data:");
            for (Employee emp : empList) {
                emp.display();
            }
        } catch (IOException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}