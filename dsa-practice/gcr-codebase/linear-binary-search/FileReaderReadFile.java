import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class FileReaderReadFile {
    public static void main(String[] args) {
        String filepath = "dsa-practice/gcr-codebase/linear-binary-search/sample.txt";
        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
            br.close();
            fr.close();
        }catch(IOException e){
            System.out.println("Error reading file : "+e.getMessage());
        }
    }
}