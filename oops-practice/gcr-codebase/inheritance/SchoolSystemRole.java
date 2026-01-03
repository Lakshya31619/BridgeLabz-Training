// Superclass
class Person {
    protected String name;
    protected int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
// Subclass Teacher
class Teacher extends Person {
    private String subject;
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    public void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}
// Subclass Student
class Student extends Person {
    private String grade;
    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }
    public void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}
// Subclass Staff
class Staff extends Person {
    private String department;
    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }
    public void displayRole() {
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}
// Main class
public class SchoolSystemRole {
    public static void main(String[] args) {
        Person teacher = new Teacher("Mr. Ajay Mahato", 40, "DIP");
        Person student = new Student("Devarshi", 22, "4th year");
        Person staff = new Staff("Pan Singh", 55, "Service carry and Jug filling");
        ((Teacher) teacher).displayRole();
        System.out.println();
        ((Student) student).displayRole();
        System.out.println();
        ((Staff) staff).displayRole();
    }
}