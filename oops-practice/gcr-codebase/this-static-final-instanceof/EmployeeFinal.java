public class EmployeeFinal {
    // Static variable
    private static String companyName = "Tech Solutions Inc.";
    private static int totalEmployees = 0;
    // Final variable
    private final int id;
    private String name;
    private String designation;
    // Constructor using 'this'
    public EmployeeFinal(String name, int id, String designation) {
        this.name = name;
        this.id = id;                 // final variable
        this.designation = designation;
        totalEmployees++;
    }
    // Static method to display total employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }
    // Method to display employee details using instanceof
    public void displayEmployeeDetails() {
        if (this instanceof EmployeeFinal) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Employee Name: " + name);
            System.out.println("Designation: " + designation);
        } else {
            System.out.println("Invalid employee object.");
        }
    }
    public static void main(String[] args) {
        // Create employee objects
        EmployeeFinal emp1 = new EmployeeFinal("Alice", 101, "Software Engineer");
        EmployeeFinal emp2 = new EmployeeFinal("Bob", 102, "QA Engineer");
        // Display total employees
        EmployeeFinal.displayTotalEmployees();
        // Display details of first employee
        emp1.displayEmployeeDetails();
    }
}