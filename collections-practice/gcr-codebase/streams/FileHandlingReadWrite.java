import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class FileHandlingReadWrite {
    public static void main(String[] args) {
        String sourceFile = "./collections-practice/gcr-codebase/streams/files/source.txt";
        String destinationFile = "./collections-practice/gcr-codebase/streams/files/destination.txt";
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destinationFile);

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("File copied successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Source file does not exist.");
        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        } finally {
            try {
                if (fis != null)
                    fis.close();
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                System.out.println("Error while closing the file.");
            }
        }
    }
}