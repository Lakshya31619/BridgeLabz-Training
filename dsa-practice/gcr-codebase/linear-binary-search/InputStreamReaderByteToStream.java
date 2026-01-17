import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
public class InputStreamReaderByteToStream {
    public static void main(String[] args) {
        String filepath = "dsa-practice/gcr-codebase/linear-binary-search/sample.txt";
        try{
            FileInputStream fis = new FileInputStream(filepath);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
        }catch(IOException e){
            System.out.println("Error reading file : "+e.getMessage());
        }
    }
}