import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ReadLargeCSVInChunks {
    private static final int CHUNK_SIZE = 100;
    public static void main(String[] args) {
        String filePath = "./io-programming-practice/gcr-codebase/csv-data-handling/read-large-file/large_students.csv";
        String line;
        int totalRecordsProcessed = 0;
        List<String> chunk = new ArrayList<>(CHUNK_SIZE);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                chunk.add(line);
                if (chunk.size() == CHUNK_SIZE) {
                    totalRecordsProcessed += processChunk(chunk);
                    chunk.clear();
                }
            }
            if (!chunk.isEmpty()) {
                totalRecordsProcessed += processChunk(chunk);
                chunk.clear();
            }
            System.out.println("Total records processed: " + totalRecordsProcessed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static int processChunk(List<String> chunk) {
        System.out.println("Processing chunk of size: " + chunk.size());
        return chunk.size();
    }
}