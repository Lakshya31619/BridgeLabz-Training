package dao;
import model.AddressBook;
import model.Contact;
import java.io.IOException;
import java.sql.*;
import java.util.concurrent.CompletableFuture;
public class DatabaseIOService implements IOService {
    private static final String DB_URL = "jdbc:h2:./oops-practice/gcr-codebase/address-book-system/src/main/resources/";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";
    public DatabaseIOService() {
        initializeDatabase();
    }
    private void initializeDatabase() {
        try (Connection conn = getConnection()) {
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS address_books (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(255) UNIQUE NOT NULL)");
            stmt.execute("CREATE TABLE IF NOT EXISTS contacts (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "address_book_id INT NOT NULL, " +
                    "first_name VARCHAR(100) NOT NULL, " +
                    "last_name VARCHAR(100) NOT NULL, " +
                    "address VARCHAR(255), " +
                    "city VARCHAR(100), " +
                    "state VARCHAR(100), " +
                    "zip VARCHAR(10), " +
                    "phone_number VARCHAR(20), " +
                    "email VARCHAR(100), " +
                    "FOREIGN KEY (address_book_id) REFERENCES address_books(id) ON DELETE CASCADE)");
            System.out.println("Database initialized successfully");
        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }
    private Connection getConnection() throws SQLException {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("H2 Driver not found. Using in-memory simulation.");
        }
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
    @Override
    public void writeAddressBook(AddressBook addressBook) throws IOException {
        CompletableFuture.runAsync(() -> {
            try (Connection conn = getConnection()) {
                conn.setAutoCommit(false);
                int addressBookId = insertOrGetAddressBook(conn, addressBook.getName());
                PreparedStatement deleteStmt = conn.prepareStatement(
                        "DELETE FROM contacts WHERE address_book_id = ?");
                deleteStmt.setInt(1, addressBookId);
                deleteStmt.executeUpdate();
                PreparedStatement insertStmt = conn.prepareStatement(
                        "INSERT INTO contacts (address_book_id, first_name, last_name, address, " +
                        "city, state, zip, phone_number, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                for (Contact contact : addressBook.getContacts()) {
                    insertStmt.setInt(1, addressBookId);
                    insertStmt.setString(2, contact.getFirstName());
                    insertStmt.setString(3, contact.getLastName());
                    insertStmt.setString(4, contact.getAddress());
                    insertStmt.setString(5, contact.getCity());
                    insertStmt.setString(6, contact.getState());
                    insertStmt.setString(7, contact.getZip());
                    insertStmt.setString(8, contact.getPhoneNumber());
                    insertStmt.setString(9, contact.getEmail());
                    insertStmt.addBatch();
                }
                insertStmt.executeBatch();
                conn.commit();
                System.out.println("Address book saved to database: " + addressBook.getName());
            } catch (SQLException e) {
                System.err.println("Error writing to database: " + e.getMessage());
            }
        });
    }
    @Override
    public AddressBook readAddressBook(String name) throws IOException {
        AddressBook addressBook = new AddressBook(name);
        CompletableFuture.supplyAsync(() -> {
            try (Connection conn = getConnection()) {
                // Get address book ID
                PreparedStatement getIdStmt = conn.prepareStatement("SELECT id FROM address_books WHERE name = ?");
                getIdStmt.setString(1, name);
                ResultSet rs = getIdStmt.executeQuery();
                if (rs.next()) {
                    int addressBookId = rs.getInt("id");
                    // Get contacts
                    PreparedStatement getContactsStmt = conn.prepareStatement("SELECT * FROM contacts WHERE address_book_id = ?");
                    getContactsStmt.setInt(1, addressBookId);
                    ResultSet contactsRs = getContactsStmt.executeQuery();   
                    while (contactsRs.next()) {
                        Contact contact = new Contact(
                                contactsRs.getString("first_name"),
                                contactsRs.getString("last_name"),
                                contactsRs.getString("address"),
                                contactsRs.getString("city"),
                                contactsRs.getString("state"),
                                contactsRs.getString("zip"),
                                contactsRs.getString("phone_number"),
                                contactsRs.getString("email")
                        );
                        addressBook.addContact(contact);
                    }      
                    System.out.println("Address book loaded from database: " + name);
                }
            } catch (SQLException e) {
                System.err.println("Error reading from database: " + e.getMessage());
            }
            return addressBook;
        });
        return addressBook;
    }
    private int insertOrGetAddressBook(Connection conn, String name) throws SQLException {
        PreparedStatement selectStmt = conn.prepareStatement("SELECT id FROM address_books WHERE name = ?");
        selectStmt.setString(1, name);
        ResultSet rs = selectStmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("id");
        } else {
            PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO address_books (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            insertStmt.setString(1, name);
            insertStmt.executeUpdate();
            ResultSet generatedKeys = insertStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        }
        throw new SQLException("Failed to insert address book");
    }
}