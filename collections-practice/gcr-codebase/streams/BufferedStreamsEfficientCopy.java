import java.io.*;
public class BufferedStreamsEfficientCopy {
    private static final int BUFFER_SIZE = 4096;
    public static void main(String[] args) {
        String sourceFile = "./collections-practice/gcr-codebase/streams/files/source.txt";
        String unbufferedDest = "./collections-practice/gcr-codebase/streams/files/unbufferedDestination.txt";
        String bufferedDest = "./collections-practice/gcr-codebase/streams/files/bufferedDestination.txt";
        copyUsingUnbufferedStreams(sourceFile, unbufferedDest);
        copyUsingBufferedStreams(sourceFile, bufferedDest);
    }
    private static void copyUsingUnbufferedStreams(String source, String dest) {
        long startTime = System.nanoTime();
        try (
            FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(dest)
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error in unbuffered copy: " + e.getMessage());
            return;
        }
        long endTime = System.nanoTime();
        System.out.println("Unbuffered Stream Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }
    private static void copyUsingBufferedStreams(String source, String dest) {
        long startTime = System.nanoTime();
        try (
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error in buffered copy: " + e.getMessage());
            return;
        }
        long endTime = System.nanoTime();
        System.out.println("Buffered Stream Time: " + (endTime - startTime) / 1000000 + " ms");
    }
}