import java.io.*;
public class ReadLargeFileByLine {
    public static void main(String[] args) {
        String fileName = "./collections-practice/gcr-codebase/streams/files/source.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("File reading error: " + e.getMessage());
        }
    }
}