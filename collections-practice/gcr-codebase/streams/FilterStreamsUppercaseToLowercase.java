import java.io.*;
import java.nio.charset.StandardCharsets;
public class FilterStreamsUppercaseToLowercase {
    public static void main(String[] args) {
        String sourceFile = "./collections-practice/gcr-codebase/streams/files/source.txt";
        String destinationFile = "./collections-practice/gcr-codebase/streams/files/destination.txt";
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile), StandardCharsets.UTF_8));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destinationFile),StandardCharsets.UTF_8))) {
            int ch;
            while ((ch = br.read()) != -1) {
                bw.write(Character.toLowerCase((char) ch));
            }
            System.out.println("File converted from uppercase to lowercase successfully.");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }
}