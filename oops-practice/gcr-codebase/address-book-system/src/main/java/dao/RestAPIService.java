package dao;
import model.AddressBook;
import model.Contact;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RestAPIService implements IOService {
    private static final String BASE_URL = "http://localhost:3000";
    @Override
    public void writeAddressBook(AddressBook addressBook) throws IOException {
        CompletableFuture.runAsync(() -> {
            try {
                for (Contact contact : addressBook.getContacts()) {
                    postContact(addressBook.getName(), contact);
                }
                System.out.println("Address book saved to JSON Server: " + addressBook.getName());
            } catch (IOException e) {
                System.err.println("Error writing to JSON Server: " + e.getMessage());
            }
        });
    }
    @Override
    public AddressBook readAddressBook(String name) throws IOException {
        AddressBook addressBook = new AddressBook(name);
        CompletableFuture.supplyAsync(() -> {
            try {
                String jsonResponse = getContacts(name);
                parseJSONContacts(jsonResponse, addressBook);
                System.out.println("Address book loaded from JSON Server: " + name);
            } catch (IOException e) {
                System.err.println("Error reading from JSON Server: " + e.getMessage());
            }
            return addressBook;
        }); 
        return addressBook;
    }  
    private void postContact(String addressBookName, Contact contact) throws IOException {
        URL url = new URL(BASE_URL + "/" + addressBookName);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);
        String jsonContact = contactToJSON(contact);
        OutputStream os = conn.getOutputStream();
        os.write(jsonContact.getBytes());
        os.flush();
        os.close(); 
        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_CREATED || responseCode == HttpURLConnection.HTTP_OK) {
            System.out.println("Contact posted successfully: " + contact.getFullName());
        } else {
            System.err.println("Failed to post contact. Response code: " + responseCode);
        }
        conn.disconnect();
    }
    private String getContacts(String addressBookName) throws IOException {
        URL url = new URL(BASE_URL + "/" + addressBookName);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET"); 
        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;      
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();
            conn.disconnect();
            
            return response.toString();
        } else {
            System.err.println("Failed to get contacts. Response code: " + responseCode);
            conn.disconnect();
            return "[]";
        }
    } 
    private String contactToJSON(Contact contact) {
        return String.format("{" +
                "\"firstName\":\"%s\"," +
                "\"lastName\":\"%s\"," +
                "\"address\":\"%s\"," +
                "\"city\":\"%s\"," +
                "\"state\":\"%s\"," +
                "\"zip\":\"%s\"," +
                "\"phoneNumber\":\"%s\"," +
                "\"email\":\"%s\"" +
                "}",
                escapeJSON(contact.getFirstName()),
                escapeJSON(contact.getLastName()),
                escapeJSON(contact.getAddress()),
                escapeJSON(contact.getCity()),
                escapeJSON(contact.getState()),
                escapeJSON(contact.getZip()),
                escapeJSON(contact.getPhoneNumber()),
                escapeJSON(contact.getEmail()));
    }
    private void parseJSONContacts(String json, AddressBook addressBook) {
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