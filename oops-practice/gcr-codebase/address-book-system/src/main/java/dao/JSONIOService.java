package dao;
import model.AddressBook;
import model.Contact;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class JSONIOService implements IOService {
    private static final String FILE_PATH = "./oops-practice/gcr-codebase/address-book-system/src/main/resources/";
    private static final String FILE_EXTENSION = ".json";
    public JSONIOService() {
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
                writer.write("{\n");
                writer.write("  \"name\": \"" + escapeJSON(addressBook.getName()) + "\",\n");
                writer.write("  \"contacts\": [\n");
                int size = addressBook.getContacts().size();
                for (int i = 0; i < size; i++) {
                    Contact contact = addressBook.getContacts().get(i);
                    writer.write(contactToJSON(contact, 4));
                    if (i < size - 1) {
                        writer.write(",");
                    }
                    writer.write("\n");
                }
                writer.write("  ]\n");
                writer.write("}\n");
                writer.close();
                System.out.println("Address book saved to JSON: " + fileName);
            } catch (IOException e) {
                System.err.println("Error writing to JSON: " + e.getMessage());
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
                StringBuilder jsonContent = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonContent.append(line).append("\n");
                }
                reader.close();
                parseJSONContacts(jsonContent.toString(), addressBook); 
                System.out.println("Address book loaded from JSON: " + fileName);
            } catch (IOException e) {
                System.err.println("Error reading from JSON: " + e.getMessage());
            }
            return addressBook;
        });
        return addressBook;
    }
    private String contactToJSON(Contact contact, int indent) {
        String spaces = " ".repeat(indent);
        StringBuilder json = new StringBuilder();   
        json.append(spaces).append("{\n");
        json.append(spaces).append("  \"firstName\": \"").append(escapeJSON(contact.getFirstName())).append("\",\n");
        json.append(spaces).append("  \"lastName\": \"").append(escapeJSON(contact.getLastName())).append("\",\n");
        json.append(spaces).append("  \"address\": \"").append(escapeJSON(contact.getAddress())).append("\",\n");
        json.append(spaces).append("  \"city\": \"").append(escapeJSON(contact.getCity())).append("\",\n");
        json.append(spaces).append("  \"state\": \"").append(escapeJSON(contact.getState())).append("\",\n");
        json.append(spaces).append("  \"zip\": \"").append(escapeJSON(contact.getZip())).append("\",\n");
        json.append(spaces).append("  \"phoneNumber\": \"").append(escapeJSON(contact.getPhoneNumber())).append("\",\n");
        json.append(spaces).append("  \"email\": \"").append(escapeJSON(contact.getEmail())).append("\"\n");
        json.append(spaces).append("}");  
        return json.toString();
    }
    private void parseJSONContacts(String json, AddressBook addressBook) {
        // Extract contacts array using regex
        Pattern contactPattern = Pattern.compile(
            "\\{[^}]*\"firstName\"\\s*:\\s*\"([^\"]*)\",\\s*" +
            "\"lastName\"\\s*:\\s*\"([^\"]*)\",\\s*" +
            "\"address\"\\s*:\\s*\"([^\"]*)\",\\s*" +
            "\"city\"\\s*:\\s*\"([^\"]*)\",\\s*" +
            "\"state\"\\s*:\\s*\"([^\"]*)\",\\s*" +
            "\"zip\"\\s*:\\s*\"([^\"]*)\",\\s*" +
            "\"phoneNumber\"\\s*:\\s*\"([^\"]*)\",\\s*" +
            "\"email\"\\s*:\\s*\"([^\"]*)\"[^}]*\\}"
        );
        Matcher matcher = contactPattern.matcher(json);
        while (matcher.find()) {
            try {
                Contact contact = new Contact(
                    matcher.group(1),
                    matcher.group(2),
                    matcher.group(3),
                    matcher.group(4),
                    matcher.group(5),
                    matcher.group(6),
                    matcher.group(7),
                    matcher.group(8)
                );
                addressBook.addContact(contact);
            } catch (Exception e) {
                System.err.println("Error parsing JSON contact: " + e.getMessage());
            }
        }
    }
    private String escapeJSON(String value) {
        if (value == null) return "";
        return value.replace("\\", "\\\\")
                   .replace("\"", "\\\"")
                   .replace("\n", "\\n")
                   .replace("\r", "\\r")
                   .replace("\t", "\\t");
    }
}