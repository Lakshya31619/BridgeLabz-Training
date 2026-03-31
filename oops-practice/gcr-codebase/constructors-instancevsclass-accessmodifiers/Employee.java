public class Employee {
    // Access modifiers
    public int employeeID;     
    protected String department;     
    private double salary;        
    // Constructor
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }
    // Public method to modify salary
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        }
    }
    public double getSalary() {
        return salary;
    }
    // Method to display employee details
    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
    public static void main(String[] args) {
        Employee e1 = new Employee(1346, "IT", 50000);
        e1.displayEmployeeDetails();
        System.out.println();
        e1.setSalary(60000);
        System.out.println("Updated Salary: " + e1.getSalary());
        System.out.println();

        Manager m1 = new Manager(1183, "HR", 80000);
        m1.displayManagerDetails();
    }
}
// Subclass Manager
class Manager extends Employee {
    // Constructor
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }
    // Method demonstrating access to public and protected members
    public void displayManagerDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + getSalary());
    }
}