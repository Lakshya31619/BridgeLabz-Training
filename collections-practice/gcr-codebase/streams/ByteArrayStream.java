import java.io.*;
public class ByteArrayStream {
    public static void main(String[] args) {
        String sourceImage = "./collections-practice/gcr-codebase/streams/files/input.jpg";
        String outputImage = "./collections-practice/gcr-codebase/streams/files/output.jpg";
        try {
            //Read image into byte array using ByteArrayOutputStream
            FileInputStream fis = new FileInputStream(sourceImage);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            byte[] imageBytes = baos.toByteArray();
            fis.close();
            baos.close();
            //Write byte array back to image using ByteArrayInputStream
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(outputImage);
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            bais.close();
            fos.close();
            System.out.println("Image successfully converted to byte array and restored.");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }
}