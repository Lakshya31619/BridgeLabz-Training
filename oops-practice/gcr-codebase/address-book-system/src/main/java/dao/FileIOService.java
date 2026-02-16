package dao;
import model.AddressBook;
import model.Contact;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
public class FileIOService implements IOService {
    private static final String FILE_PATH = "./oops-practice/gcr-codebase/address-book-system/src/main/resources/";
    private static final String FILE_EXTENSION = ".txt";
    public FileIOService() {
        createDataDirectory();
    }
    private void createDataDirectory() {
        try {
            Files.createDirectories(Paths.get(FILE_PATH));
        } catch (IOException e) {
            System.err.println("Error creating data directory: " + e.getMessage());
        }
    }
    @Override
    public void writeAddressBook(AddressBook addressBook) throws IOException {
        CompletableFuture.runAsync(() -> {
            try {
                String fileName = FILE_PATH + addressBook.getName() + FILE_EXTENSION;
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                writer.write("Address Book: " + addressBook.getName());
                writer.newLine();
                writer.write("=".repeat(50));
                writer.newLine();
                for (Contact contact : addressBook.getContacts()) {
                    writer.write(contactToString(contact));
                    writer.newLine();
                }
                writer.close();
                System.out.println("Address book saved to file: " + fileName);
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
        });
    }
    @Override
    public AddressBook readAddressBook(String name) throws IOException {
        AddressBook addressBook = new AddressBook(name);
        CompletableFuture.supplyAsync(() -> {
            try {
                String fileName = FILE_PATH + name + FILE_EXTENSION;
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String line;
                reader.readLine();
                reader.readLine();
                while ((line = reader.readLine()) != null) {
                    if (!line.trim().isEmpty()) {
                        Contact contact = stringToContact(line);
                        if (contact != null) {
                            addressBook.addContact(contact);
                        }
                    }
                }
                reader.close();
                System.out.println("Address book loaded from file: " + fileName);
            } catch (IOException e) {
                System.err.println("Error reading from file: " + e.getMessage());
            }
            return addressBook;
        }); 
        return addressBook;
    }   
    private String contactToString(Contact contact) {
        return String.format("%s|%s|%s|%s|%s|%s|%s|%s",
                contact.getFirstName(),
                contact.getLastName(),
                contact.getAddress(),
                contact.getCity(),
                contact.getState(),
                contact.getZip(),
                contact.getPhoneNumber(),
                contact.getEmail());
    }
    private Contact stringToContact(String line) {
        try {
            String[] parts = line.split("\\|");
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
            System.err.println("Error parsing contact: " + e.getMessage());
        }
        return null;
    }
}