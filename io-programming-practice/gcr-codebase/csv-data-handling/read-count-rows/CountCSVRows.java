import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CountCSVRows {
    public static void main(String[] args) {
        String filePath = "./io-programming-practice/gcr-codebase/csv-data-handling/read-count-rows/employees.csv";
        String line;
        int recordCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    recordCount++;
                }
            }
            System.out.println("Total number of records: " + recordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}