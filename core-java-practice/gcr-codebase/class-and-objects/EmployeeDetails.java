public class EmployeeDetails {
    //Employee Class
    static class Employee {
        //Attributes
        private String name;
        private int id;
        private double salary;
        // Constructor
        public Employee(String name, int id, double salary) {
            this.name = name;
            this.id = id;
            this.salary = salary;
        }
        // Method to display employee details
        public void displayDetails() {
            System.out.println("Employee Name: " + name);
            System.out.println("Employee id: " + id);
            System.out.println("Employee Salary: " + salary);
        }
    }
    public static void main(String[] args) {
        // Create Employee object
        Employee emp = new Employee("Rohan", 1, 500000);
        // Display details
        emp.displayDetails();
    }
}