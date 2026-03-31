package dao;

import model.AddressBook;
import model.Contact;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CSVIOService implements IOService {

    // Saves files inside project root /data folder
    private static final String FILE_PATH = "./oops-practice/gcr-codebase/address-book-system/src/main/resources/";
    private static final String FILE_EXTENSION = ".csv";
    private static final String CSV_HEADER =
            "FirstName,LastName,Address,City,State,Zip,Phone,Email";

    public CSVIOService() {
        createDataDirectory();
    }

    // Create data directory if it doesn't exist
    private void createDataDirectory() {
        try {
            Files.createDirectories(Paths.get(FILE_PATH));
        } catch (IOException e) {
            System.err.println("Error creating data directory: " + e.getMessage());
        }
    }

    // =========================
    // WRITE ADDRESS BOOK (SAFE)
    // =========================
    @Override
    public void writeAddressBook(AddressBook addressBook) throws IOException {

        String fileName = FILE_PATH + addressBook.getName() + FILE_EXTENSION;
        Path path = Paths.get(fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {

            writer.write(CSV_HEADER);
            writer.newLine();

            for (Contact contact : addressBook.getContacts()) {
                writer.write(contactToCSV(contact));
                writer.newLine();
            }
        }

        System.out.println("Address book saved to CSV: " + fileName);
    }

    // =========================
    // READ ADDRESS BOOK (SAFE)
    // =========================
    @Override
    public AddressBook readAddressBook(String name) throws IOException {

        String fileName = FILE_PATH + name + FILE_EXTENSION;
        Path path = Paths.get(fileName);

        AddressBook addressBook = new AddressBook(name);

        if (!Files.exists(path)) {
            System.out.println("File not found: " + fileName);
            return addressBook;
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {

            reader.readLine(); // Skip CSV header
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    Contact contact = csvToContact(line);
                    if (contact != null) {
                        addressBook.addContact(contact);
                    }
                }
            }
        }

        System.out.println("Address book loaded from CSV: " + fileName);
        return addressBook;
    }

    // Convert Contact object to CSV format
    private String contactToCSV(Contact contact) {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                escapeCSV(contact.getFirstName()),
                escapeCSV(contact.getLastName()),
                escapeCSV(contact.getAddress()),
                escapeCSV(contact.getCity()),
                escapeCSV(contact.getState()),
                escapeCSV(contact.getZip()),
                escapeCSV(contact.getPhoneNumber()),
                escapeCSV(contact.getEmail()));
    }

    // Convert CSV line to Contact object
    private Contact csvToContact(String line) {
        try {
            String[] parts = parseCSVLine(line);

            if (parts.length == 8) {
                return new Contact(
                        parts[0].trim(),
                        parts[1].trim(),
                        parts[2].trim(),
                        parts[3].trim(),
                        parts[4].trim(),
                        parts[5].trim(),
                        parts[6].trim(),
                        parts[7].trim()
                );
            }

        } catch (Exception e) {
            System.err.println("Error parsing CSV contact: " + e.getMessage());
        }

        return null;
    }

    // Escape CSV special characters
    private String escapeCSV(String value) {
        if (value == null) return "";

        if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
            return "\"" + value.replace("\"", "\"\"") + "\"";
        }

        return value;
    }

    // Proper CSV parsing (handles quoted commas)
    private String[] parseCSVLine(String line) {
        return line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
    }
}
