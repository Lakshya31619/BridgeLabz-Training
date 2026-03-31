import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "./io-programming-practice/gcr-codebase/csv-data-handling/merge-two-csv/student1.csv";
        String file2 = "./io-programming-practice/gcr-codebase/csv-data-handling/merge-two-csv/student2.csv";
        String outputFile = "./io-programming-practice/gcr-codebase/csv-data-handling/merge-two-csv/student_merged.csv";
        Map<String, String[]> studentMap = new HashMap<>();
        String line;
        try (
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            FileWriter writer = new FileWriter(outputFile)
        ) {
            br1.readLine();
            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                studentMap.put(data[0], new String[]{data[1], data[2]});
            }
            writer.append("ID,Name,Age,Marks,Grade\n");
            br2.readLine();
            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String marks = data[1];
                String grade = data[2];
                if (studentMap.containsKey(id)) {
                    String[] studentInfo = studentMap.get(id);
                    writer.append(id).append(",")
                          .append(studentInfo[0]).append(",")
                          .append(studentInfo[1]).append(",")
                          .append(marks).append(",")
                          .append(grade).append("\n");
                }
            }
            System.out.println("CSV files merged successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}