public class Student {
    // Access modifiers
    public int rollNumber;     
    protected String name;     
    private double cgpa;        
    // Constructor
    public Student(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }
    // Public methods to access and modify CGPA
    public double getCGPA() {
        return cgpa;
    }
    public void setCGPA(double cgpa) {
        if (cgpa >= 0.0 && cgpa <= 10.0) {
            this.cgpa = cgpa;
        }
    }
    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + cgpa);
    }
    public static void main(String[] args) {
        Student s1 = new Student(11, "Anjali", 9.2);
        s1.displayStudentDetails();
        System.out.println();
        s1.setCGPA(9.2);
        System.out.println("Updated CGPA: " + s1.getCGPA());
    }
}