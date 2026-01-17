import java.io.*;
import java.nio.charset.StandardCharsets;
public class ChallengeProblemReader {
    static void testStringBuilders() {
        int n = 1_000_000;
        long t1 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("hello");
        long t2 = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) sbf.append("hello");
        long t3 = System.currentTimeMillis();
        System.out.println("StringBuilder ms=" + (t2 - t1));
        System.out.println("StringBuffer ms=" + (t3 - t2));
    }
    static void countWordsWithFileReader(File f) throws Exception {
        long t1 = System.currentTimeMillis();
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        long words = 0;
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.isEmpty()) words += line.split("\\s+").length;
        }
        br.close();
        long t2 = System.currentTimeMillis();
        System.out.println("FileReader words=" + words + " ms=" + (t2 - t1));
    }
    static void countWordsWithInputStreamReader(File f) throws Exception {
        long t1 = System.currentTimeMillis();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        long words = 0;
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.isEmpty()) words += line.split("\\s+").length;
        }
        br.close();
        long t2 = System.currentTimeMillis();
        System.out.println("InputStreamReader words=" + words + " ms=" + (t2 - t1));
    }
    public static void main(String[] args) throws Exception {
        testStringBuilders();
        File file = new File("large.txt");
        countWordsWithFileReader(file);
        countWordsWithInputStreamReader(file);
    }
}