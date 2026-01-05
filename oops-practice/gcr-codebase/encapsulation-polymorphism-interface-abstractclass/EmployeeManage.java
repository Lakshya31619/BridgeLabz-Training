import java.util.ArrayList;
import java.util.List;
//Main Class
public class EmployeeManage {
    public static void main(String[] args) {
        List<EmployeeAbs> employees = new ArrayList<>();
        EmployeeAbs fullTimeEmp = new FullTimeEmployee(1278, "Naman", 90000);
        EmployeeAbs partTimeEmp = new PartTimeEmployee(286, "Ansh", 50, 80);
        // Assign departments using interface reference
        Department dept1 = (Department) fullTimeEmp;
        dept1.assignDepartment("IT");
        Department dept2 = (Department) partTimeEmp;
        dept2.assignDepartment("HR");
        employees.add(fullTimeEmp);
        employees.add(partTimeEmp);
        // Polymorphic processing
        for (EmployeeAbs employee : employees) {
            employee.displayDetails();
            System.out.println("Department    : "+ ((Department) employee).getDepartmentDetails());
            System.out.println("------------------------------");
        }
    }
}
//Interface
interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}
//Abstract Class
abstract class EmployeeAbs {
    private int employeeId;
    private String name;
    private double baseSalary;
    protected EmployeeAbs(int employeeId, String name, double baseSalary) {
        setEmployeeId(employeeId);
        setName(name);
        setBaseSalary(baseSalary);
    }
    public abstract double calculateSalary();
    public void displayDetails() {
        System.out.println("Employee ID   : " + employeeId);
        System.out.println("Name          : " + name);
        System.out.println("Total Salary  : " + calculateSalary());
    }
    public int getEmployeeId() {
        return employeeId;
    }
    private void setEmployeeId(int employeeId) {
        if (employeeId <= 0) {
            throw new IllegalArgumentException("Employee ID must be positive.");
        }
        this.employeeId = employeeId;
    }
    public String getName() {
        return name;
    }
    private void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }
    protected double getBaseSalary() {
        return baseSalary;
    }
    protected void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) {
            throw new IllegalArgumentException("Base salary cannot be negative.");
        }
        this.baseSalary = baseSalary;
    }
}
//Full time employee class
class FullTimeEmployee extends EmployeeAbs implements Department {
    private String department;
    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }
    @Override
    public double calculateSalary() {
        return getBaseSalary();
    }
    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }
    @Override
    public String getDepartmentDetails() {
        return department;
    }
}
//Part time employee class
class PartTimeEmployee extends EmployeeAbs implements Department {
    private int workHours;
    private String department;
    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int workHours) {
        super(employeeId, name, hourlyRate);
        setWorkHours(workHours);
    }
    @Override
    public double calculateSalary() {
        return getBaseSalary() * workHours;
    }
    private void setWorkHours(int workHours) {
        if (workHours < 0) {
            throw new IllegalArgumentException("Work hours cannot be negative.");
        }
        this.workHours = workHours;
    }
    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }
    @Override
    public String getDepartmentDetails() {
        return department;
    }
}