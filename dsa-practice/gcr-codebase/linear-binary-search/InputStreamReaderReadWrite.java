import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
public class InputStreamReaderReadWrite {
    public static void main(String[] args) {
        String filePath = "dsa-practice/gcr-codebase/linear-binary-search/sample.txt";
        try (
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            FileWriter fw = new FileWriter(filePath, true)
        ){
            String input;
            System.out.println("Enter text (type 'exit' to stop):");
            while (true) {
                input = br.readLine();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                fw.write(input + System.lineSeparator());
            }
            System.out.println("Input saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}