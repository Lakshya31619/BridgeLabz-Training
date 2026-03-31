class StudentNode {
    int roll;
    String name;
    int age;
    char grade;
    StudentNode next;
    StudentNode(int roll, String name, int age, char grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}
public class StudentRecordManager {
    private static StudentNode head = null;
    //Insert at beginning
    public static void insertAtBeginning(int roll, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
    }
    //Insert at end
    public static void insertAtEnd(int roll, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    //Insert at specific position
    public static void insertAtPosition(int roll, String name, int age, char grade, int position) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            insertAtBeginning(roll, name, age, grade);
            return;
        }
        StudentNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of range!");
            return;
        }
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        newNode.next = temp.next;
        temp.next = newNode;
    }
    //Delete by Roll Number
    public static void deleteByRoll(int roll) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.roll == roll) {
            head = head.next;
            return;
        }
        StudentNode current = head;
        while (current.next != null && current.next.roll != roll) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Student not found!");
        } else {
            current.next = current.next.next;
        }
    }
    //Search Students
    public static void searchStudent(int roll) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println("Student Found:");
                System.out.println("Roll: " + temp.roll);
                System.out.println("Name: " + temp.name);
                System.out.println("Age: " + temp.age);
                System.out.println("Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found!");
    }
    //Update Grade
    public static void updateGrade(int roll, char newGrade) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                temp.grade = newGrade;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found!");
    }
    //Display Students
    public static void displayStudents() {
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }
        StudentNode temp = head;
        System.out.println("\nStudent Records:");
        while (temp != null) {
            System.out.println("Roll: " + temp.roll + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
    //Main method
    public static void main(String[] args) {
        insertAtBeginning(1, "Ansh", 19, 'A');
        insertAtEnd(2, "Bansh", 21, 'B');
        insertAtEnd(3, "Cansh", 25, 'C');
        insertAtPosition(4, "Dansh", 33, 'B', 2);
        displayStudents();
        System.out.println("\nSearching for Roll 2:");
        searchStudent(2);
        System.out.println("\nUpdating grade for Roll 3:");
        updateGrade(3, 'A');
        System.out.println("\nDeleting Roll 1:");
        deleteByRoll(1);
        System.out.println("\nFinal Student Records:");
        displayStudents();
    }
}