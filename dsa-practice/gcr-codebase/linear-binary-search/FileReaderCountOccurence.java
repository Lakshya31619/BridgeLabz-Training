import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class FileReaderCountOccurence {
    public static void main(String[] args) {
        String filepath = "dsa-practice/gcr-codebase/linear-binary-search/sample.txt";
        String target = "java";
        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            int count = 0;
            while((line = br.readLine())!=null){
                String[] words = line.split("\\s+");
                for(String word : words){
                    if(word.equals(target)){
                        count++;
                    }
                }
            }
            System.out.println("The word "+target+" appears "+count+" times.");
            br.close();
            fr.close();
        }catch(IOException e){
            System.out.println("Error reading file : "+e.getMessage());
        }
    }
}