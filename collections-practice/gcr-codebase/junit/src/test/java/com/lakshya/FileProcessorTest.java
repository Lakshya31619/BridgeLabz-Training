package com.lakshya;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
class FileProcessorTest {
    private final FileProcessor fileProcessor = new FileProcessor();
    private final String testFile = "sample.txt";
    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello, World!";
        fileProcessor.writeToFile(testFile, content);

        String readContent = fileProcessor.readFromFile(testFile);
        assertEquals(content, readContent, "Content read should match content written");
    }
    @Test
    void testFileExistsAfterWriting() throws IOException {
        String content = "File existence test";
        fileProcessor.writeToFile(testFile, content);

        assertTrue(Files.exists(Path.of(testFile)), "File should exist after writing");
    }
    @Test
    void testReadNonExistentFileThrowsIOException() {
        String nonExistentFile = "no_such_file.txt";
        Exception exception = assertThrows(
                IOException.class,
                () -> fileProcessor.readFromFile(nonExistentFile)
        );
        assertTrue(exception.getMessage().contains("no_such_file"), "Exception message should indicate file does not exist");
    }
}