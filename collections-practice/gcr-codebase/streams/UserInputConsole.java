import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.IOException;
public class UserInputConsole {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw = null;
        try {
            System.out.print("Enter your name: ");
            String name = br.readLine();
            System.out.print("Enter your age: ");
            int age = Integer.parseInt(br.readLine());
            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();
            fw = new FileWriter("./collections-practice/gcr-codebase/streams/files/destination.txt");
            fw.write("Name: " + name + "\n");
            fw.write("Age: " + age + "\n");
            fw.write("Favorite Programming Language: " + language + "\n");
            System.out.println("User information saved successfully.");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid age. Please enter a number.");
        } finally {
            try {
                if (fw != null)
                    fw.close();
                if (br != null)
                    br.close();
            } catch (IOException e) {
                System.out.println("Error while closing resources.");
            }
        }
    }
}