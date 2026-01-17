import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class FileReaderReadFile {
    public static void main(String[] args) {
        String filepath = "StringBuilderReverse.java";
        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            br.close();
            fr.close();
        }catch(IOException e){
            System.out.println("Error reading file : "+e.getMessage());
        }
    }
}