public class StudentReport {
    // Student Class
    static class Student {
        // Attributes
        private String name;
        private String rollNumber;
        private double mark1;
        private double mark2;
        private double mark3;
        // Constructor
        public Student(String name, String rollNumber,double mark1, double mark2, double mark3) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.mark1 = mark1;
            this.mark2 = mark2;
            this.mark3 = mark3;
        }
        // Method to calculate grade
        public String calculateGrade() {
            double average = (mark1 + mark2 + mark3) / 3;
            if (average >= 85) {
                return "A";
            } else if (average >= 75) {
                return "B";
            } else if (average >= 60) {
                return "C";
            } else {
                return "D";
            }
        }
        // Method to display student details and grade
        public void displayDetails() {
            System.out.println("Student Name: " + name);
            System.out.println("Student RollNumber: " + rollNumber);
            System.out.println("Student Marks:");
            System.out.println("Mark1: " + mark1);
            System.out.println("Mark2: " + mark2);
            System.out.println("Mark3: " + mark3);
            System.out.println("Grade " + calculateGrade());
        }
    }
    public static void main(String[] args) {
        // Create Student objects
        Student student1 = new Student("Thamarai", "ECE001", 80.0, 70.0, 75.0);
        Student student2 = new Student("Kannan", "CSC002", 60.0, 65.0, 50.0);
        // Display student reports
        student1.displayDetails();
        student2.displayDetails();
    }
}