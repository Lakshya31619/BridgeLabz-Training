import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CheckedException {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./collections-practice/gcr-codebase/exception-handling/file.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}