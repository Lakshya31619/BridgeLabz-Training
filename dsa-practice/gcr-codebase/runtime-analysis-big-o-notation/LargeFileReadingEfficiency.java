import java.io.*;
public class LargeFileReadingEfficiency {
    private static final int BUFFER_SIZE = 8 * 1024; // 8 KB buffer
    // FileReader
    static void readUsingFileReader(String filePath) throws IOException {
        try (FileReader fr = new FileReader(filePath)) {
            char[] buffer = new char[BUFFER_SIZE];
            while (fr.read(buffer) != -1) {
                // reading file
            }
        }
    }
    // InputStreamReader
    static void readUsingInputStreamReader(String filePath) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath))) {
            char[] buffer = new char[BUFFER_SIZE];
            while (isr.read(buffer) != -1) {
                // reading file
            }
        }
    }
    public static void main(String[] args) throws IOException {
        String filePath = "largefile.txt";
        long start, end;
        // FileReader Time
        start = System.nanoTime();
        readUsingFileReader(filePath);
        end = System.nanoTime();
        System.out.println("FileReader Time: " + (end - start) / 1000000 + " ms");
        // InputStreamReader Time
        start = System.nanoTime();
        readUsingInputStreamReader(filePath);
        end = System.nanoTime();
        System.out.println("InputStreamReader Time: " + (end - start) / 1000000 + " ms");
    }
}