import model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ContactTest {
    private Contact contact;
    @BeforeEach
    public void setUp() {
        contact = new Contact("John", "Doe", "123 Main St", "Mumbai", "Maharashtra", "400001", "9876543210", "john.doe@email.com");
    }
    @Test
    public void testContactCreation() {
        assertNotNull(contact);
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("Mumbai", contact.getCity());
    }
    @Test
    public void testValidFirstName() {
        assertDoesNotThrow(() -> contact.setFirstName("Alice"));
        assertEquals("Alice", contact.getFirstName());
    }
    @Test
    public void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("jo"));
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("123"));
    }
    @Test
    public void testValidEmail() {
        assertDoesNotThrow(() -> contact.setEmail("test@example.com"));
        assertEquals("test@example.com", contact.getEmail());
    }
    @Test
    public void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> contact.setEmail("invalidemail"));
        assertThrows(IllegalArgumentException.class, () -> contact.setEmail("@example.com"));
    }
    @Test
    public void testValidPhoneNumber() {
        assertDoesNotThrow(() -> contact.setPhoneNumber("1234567890"));
        assertEquals("1234567890", contact.getPhoneNumber());
    }
    @Test
    public void testInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("123"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("abcdefghij"));
    }
    @Test
    public void testValidZip() {
        assertDoesNotThrow(() -> contact.setZip("12345"));
        assertEquals("12345", contact.getZip());
    }
    @Test
    public void testInvalidZip() {
        assertThrows(IllegalArgumentException.class, () -> contact.setZip("123"));
        assertThrows(IllegalArgumentException.class, () -> contact.setZip("abcdef"));
    }
    @Test
    public void testEqualsMethod() {
        Contact contact2 = new Contact("John", "Doe", "456 Oak Ave", "Delhi", 
                                      "Delhi", "110001", "8765432109", "john2@email.com");
        assertEquals(contact, contact2); // Same first and last name
        
        Contact contact3 = new Contact("Jane", "Doe", "123 Main St", "Mumbai", 
                                      "Maharashtra", "400001", "9876543210", "jane@email.com");
        assertNotEquals(contact, contact3); // Different first name
    }
    @Test
    public void testToString() {
        String expected = "Contact{firstName='John', lastName='Doe', address='123 Main St', " +
                         "city='Mumbai', state='Maharashtra', zip='400001', " +
                         "phoneNumber='9876543210', email='john.doe@email.com'}";
        assertEquals(expected, contact.toString());
    }
    @Test
    public void testGetFullName() {
        assertEquals("John Doe", contact.getFullName());
    }
}