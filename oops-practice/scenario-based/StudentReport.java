import java.util.ArrayList;
import java.util.List;
// Exception
class InvalidMarkException extends Exception {
    public InvalidMarkException(String message) {
        super(message);
    }
}
// Student class 
class Student {
    private String name;
    private String[] subjects;
    private int[] marks;
    public Student(String name, String[] subjects, int[] marks)
            throws InvalidMarkException {

        if (subjects.length != marks.length) {
            throw new InvalidMarkException("Subjects and marks count mismatch.");
        }
        this.name = name;
        this.subjects = subjects;
        this.marks = new int[marks.length];
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 0 || marks[i] > 100) {
                throw new InvalidMarkException(
                    "Invalid mark for " + subjects[i] + ": " + marks[i]
                );
            }
            this.marks[i] = marks[i];
        }
    }
    // Calculate average marks
    public double calculateAverage() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return (double) sum / marks.length;
    }
    // Assign grade
    public String getGrade() {
        double avg = calculateAverage();
        if (avg >= 80) return "A";
        else if (avg >= 60) return "B";
        else if (avg >= 40) return "C";
        else return "F";
    }
    // Display report card
    public void displayReport() {
        System.out.println("\n==============================");
        System.out.println("Student Name: " + name);
        System.out.println("------------------------------");
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%-10s : %d%n", subjects[i], marks[i]);
        }
        System.out.println("------------------------------");
        System.out.printf("Average   : %.2f%n", calculateAverage());
        System.out.println("Grade     : " + getGrade());
        System.out.println("==============================");
    }
}
// Report Manager
class ReportGenerator {
    private List<Student> students = new ArrayList<>();
    public void addStudent(Student student) {
        students.add(student);
    }
    public void displayAllReports() {
        for (Student s : students) {
            s.displayReport();
        }
    }
}
public class StudentReport {
    public static void main(String[] args) {
        String[] subjects = {"Math", "Science", "English"};
        ReportGenerator reportGenerator = new ReportGenerator();
        try {
            int[] marks1 = {85, 78, 90};
            Student s1 = new Student("Sheamus", subjects, marks1);
            reportGenerator.addStudent(s1);
            int[] marks2 = {65, 70, 60};
            Student s2 = new Student("Cesaro", subjects, marks2);
            reportGenerator.addStudent(s2);
            // Display all report cards
            reportGenerator.displayAllReports();
        } catch (InvalidMarkException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}