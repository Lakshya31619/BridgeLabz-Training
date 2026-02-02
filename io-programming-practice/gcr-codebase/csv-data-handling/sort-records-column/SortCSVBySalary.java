import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class Employee {
    String id;
    String name;
    String department;
    int salary;
    Employee(String id, String name, String department, int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}
public class SortCSVBySalary {
    public static void main(String[] args) {
        String filePath = "./io-programming-practice/gcr-codebase/csv-data-handling/sort-records-column/employees.csv";
        String line;
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Employee emp = new Employee(
                        data[0],
                        data[1],
                        data[2],
                        Integer.parseInt(data[3])
                );
                employees.add(emp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Integer.compare(e2.salary, e1.salary);
            }
        });
        System.out.println("Top 5 Highest-Paid Employees:\n");
        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            Employee e = employees.get(i);
            System.out.println("Name       : " + e.name);
            System.out.println("Department : " + e.department);
            System.out.println("Salary     : " + e.salary);
            System.out.println();
        }
    }
}