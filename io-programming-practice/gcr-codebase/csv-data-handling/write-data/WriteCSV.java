import java.io.FileWriter;
import java.io.IOException;
public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "./io-programming-practice/gcr-codebase/csv-data-handling/write-data/employees.csv";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("ID,Name,Department,Salary\n");
            writer.append("101,Aarav Sharma,HR,45000\n");
            writer.append("102,Priya Verma,IT,60000\n");
            writer.append("103,Rohan Patel,Finance,52000\n");
            writer.append("104,Ananya Iyer,Marketing,48000\n");
            writer.append("105,Kunal Singh,IT,65000\n");
            System.out.println("CSV file created with employee names.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}