public class StudentFinal {
    // Static variable
    private static String universityName = "Global University";
    private static int totalStudents = 0;
    // Final variable
    private final int rollNumber;
    private String name;
    private String grade;
    // Constructor using 'this'
    public StudentFinal(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++; 
    }
    // Static method to display total students
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    // Method to display student details using instanceof
    public void displayStudentDetails() {
        if (this instanceof StudentFinal) {
            System.out.println("University Name: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        } else {
            System.out.println("Invalid student object.");
        }
    }
    // Method to update grade using instanceof check
    public void updateGrade(String newGrade) {
        if (this instanceof StudentFinal) {
            this.grade = newGrade;
            System.out.println("Grade updated to: " + newGrade);
        }
    }
    public static void main(String[] args) {
        // Create student objects
        StudentFinal s1 = new StudentFinal("Hemashree", 101, "A");
        StudentFinal s2 = new StudentFinal("Sharmila", 102, "B");
        // Display total students
        StudentFinal.displayTotalStudents();
        // Display student details
        s1.displayStudentDetails();
        System.out.println();
        s2.displayStudentDetails();
        // Update grade for second student
        s2.updateGrade("A");
        // Display updated details
        s2.displayStudentDetails();
    }
}