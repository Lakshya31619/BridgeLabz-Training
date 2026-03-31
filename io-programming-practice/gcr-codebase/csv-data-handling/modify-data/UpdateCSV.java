import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class UpdateCSV {
    public static void main(String[] args) {
        String inputFile = "./io-programming-practice/gcr-codebase/csv-data-handling/modify-data/employees.csv";
        String outputFile = "./io-programming-practice/gcr-codebase/csv-data-handling/modify-data/updated_employees.csv";
        String line;
        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            FileWriter writer = new FileWriter(outputFile)
        ) {
            String header = br.readLine();
            writer.append(header).append("\n");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                String department = data[2];
                double salary = Double.parseDouble(data[3]);
                if (department.equalsIgnoreCase("IT")) {
                    salary = salary + (salary * 0.10);
                }
                writer.append(id).append(",")
                      .append(name).append(",")
                      .append(department).append(",")
                      .append(String.valueOf((int) salary))
                      .append("\n");
            }
            System.out.println("Salary update completed. New CSV file created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}