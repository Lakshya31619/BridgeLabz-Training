import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Employee {
    String name;
    String department;
    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    public String toString() {
        return name;
    }
}
public class MapGroupObjects {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));
        Map<String, List<Employee>> grouped = new HashMap<>();
        for (Employee e : employees) {
            grouped.computeIfAbsent(e.department, k -> new ArrayList<>()).add(e);
        }
        System.out.println(grouped);
    }
}