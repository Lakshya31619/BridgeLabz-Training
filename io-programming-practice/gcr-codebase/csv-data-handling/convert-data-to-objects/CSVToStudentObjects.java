import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
class Student {
    int id;
    String name;
    int age;
    int marks;
    Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
    @Override
    public String toString() {
        return "Student {" + "ID=" + id + ", Name='" + name + '\'' + ", Age=" + age + ", Marks=" + marks + '}';
    }
}
public class CSVToStudentObjects {
    public static void main(String[] args) {
        String filePath = "./io-programming-practice/gcr-codebase/csv-data-handling/convert-data-to-objects/students.csv";
        String line;
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                int marks = Integer.parseInt(data[3]);
                Student student = new Student(id, name, age, marks);
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Student Objects:\n");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}