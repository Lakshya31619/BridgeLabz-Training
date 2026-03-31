import java.io.*;
public class DataStreamsStoreRetrieve {
    public static void main(String[] args) {
        String fileName = "./collections-practice/gcr-codebase/streams/files/student.txt";
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            int rollNumber = 101;
            String name = "Abhishek";
            double gpa = 8.75;
            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
            System.out.println("Student data written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
        // Reading student data from binary file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            int rollNumber = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();
            System.out.println("\nRetrieved Student Data:");
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}