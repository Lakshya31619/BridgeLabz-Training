import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
public class DetectDuplicateCSV {
    public static void main(String[] args) {
        String filePath = "./io-programming-practice/gcr-codebase/csv-data-handling/detect-duplicates/students.csv";
        String line;
        Set<String> seenIds = new HashSet<>();
        System.out.println("Duplicate Records Found:\n");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                if (!seenIds.add(id)) {
                    System.out.println("Duplicate Record:");
                    System.out.println("ID    : " + data[0]);
                    System.out.println("Name  : " + data[1]);
                    System.out.println("Age   : " + data[2]);
                    System.out.println("Marks : " + data[3]);
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}