import model.AddressBook;
import model.Contact;
import service.AddressBookSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
public class AddressBookSystemTest {
    
    private AddressBookSystem system;
    private Contact contact1;
    private Contact contact2;
    private Contact contact3;
    
    @BeforeEach
    public void setUp() {
        system = new AddressBookSystem();
        
        contact1 = new Contact("John", "Doe", "123 Main St", "Mumbai", 
                              "Maharashtra", "400001", "9876543210", "john@email.com");
        contact2 = new Contact("Jane", "Smith", "456 Oak Ave", "Mumbai", 
                              "Maharashtra", "400002", "8765432109", "jane@email.com");
        contact3 = new Contact("Bob", "Johnson", "789 Elm St", "Delhi", 
                              "Delhi", "110001", "7654321098", "bob@email.com");
    }
    
    @Test
    public void testAddAddressBook() {
        assertTrue(system.addAddressBook("Personal"));
        assertNotNull(system.getAddressBook("Personal"));
    }
    
    @Test
    public void testAddDuplicateAddressBook() {
        system.addAddressBook("Personal");
        assertFalse(system.addAddressBook("Personal")); // Duplicate
    }
    
    @Test
    public void testGetAddressBook() {
        system.addAddressBook("Work");
        AddressBook addressBook = system.getAddressBook("Work");
        assertNotNull(addressBook);
        assertEquals("Work", addressBook.getName());
    }
    
    @Test
    public void testSearchPersonsByCity() {
        system.addAddressBook("Book1");
        system.addAddressBook("Book2");
        
        AddressBook book1 = system.getAddressBook("Book1");
        AddressBook book2 = system.getAddressBook("Book2");
        
        book1.addContact(contact1); // Mumbai
        book1.addContact(contact2); // Mumbai
        book2.addContact(contact3); // Delhi
        
        List<Contact> mumbaiContacts = system.searchPersonsByCity("Mumbai");
        assertEquals(2, mumbaiContacts.size());
        
        List<Contact> delhiContacts = system.searchPersonsByCity("Delhi");
        assertEquals(1, delhiContacts.size());
    }
    
    @Test
    public void testSearchPersonsByState() {
        system.addAddressBook("Book1");
        system.addAddressBook("Book2");
        
        AddressBook book1 = system.getAddressBook("Book1");
        AddressBook book2 = system.getAddressBook("Book2");
        
        book1.addContact(contact1); // Maharashtra
        book1.addContact(contact2); // Maharashtra
        book2.addContact(contact3); // Delhi
        
        List<Contact> maharashtraContacts = system.searchPersonsByState("Maharashtra");
        assertEquals(2, maharashtraContacts.size());
        
        List<Contact> delhiContacts = system.searchPersonsByState("Delhi");
        assertEquals(1, delhiContacts.size());
    }
    
    @Test
    public void testViewPersonsByCity() {
        system.addAddressBook("Book1");
        system.addAddressBook("Book2");
        
        AddressBook book1 = system.getAddressBook("Book1");
        AddressBook book2 = system.getAddressBook("Book2");
        
        book1.addContact(contact1); // Mumbai
        book1.addContact(contact2); // Mumbai
        book2.addContact(contact3); // Delhi
        
        Map<String, List<Contact>> cityMap = system.viewPersonsByCity();
        assertEquals(2, cityMap.size());
        assertTrue(cityMap.containsKey("Mumbai"));
        assertTrue(cityMap.containsKey("Delhi"));
        assertEquals(2, cityMap.get("Mumbai").size());
        assertEquals(1, cityMap.get("Delhi").size());
    }
    
    @Test
    public void testViewPersonsByState() {
        system.addAddressBook("Book1");
        system.addAddressBook("Book2");
        
        AddressBook book1 = system.getAddressBook("Book1");
        AddressBook book2 = system.getAddressBook("Book2");
        
        book1.addContact(contact1); // Maharashtra
        book1.addContact(contact2); // Maharashtra
        book2.addContact(contact3); // Delhi
        
        Map<String, List<Contact>> stateMap = system.viewPersonsByState();
        assertEquals(2, stateMap.size());
        assertTrue(stateMap.containsKey("Maharashtra"));
        assertTrue(stateMap.containsKey("Delhi"));
        assertEquals(2, stateMap.get("Maharashtra").size());
    }
    
    @Test
    public void testGetCountByCity() {
        system.addAddressBook("Book1");
        system.addAddressBook("Book2");
        
        AddressBook book1 = system.getAddressBook("Book1");
        AddressBook book2 = system.getAddressBook("Book2");
        
        book1.addContact(contact1); // Mumbai
        book1.addContact(contact2); // Mumbai
        book2.addContact(contact3); // Delhi
        
        assertEquals(2, system.getCountByCity("Mumbai"));
        assertEquals(1, system.getCountByCity("Delhi"));
        assertEquals(0, system.getCountByCity("Bangalore"));
    }
    
    @Test
    public void testGetCountByState() {
        system.addAddressBook("Book1");
        system.addAddressBook("Book2");
        
        AddressBook book1 = system.getAddressBook("Book1");
        AddressBook book2 = system.getAddressBook("Book2");
        
        book1.addContact(contact1); // Maharashtra
        book1.addContact(contact2); // Maharashtra
        book2.addContact(contact3); // Delhi
        
        assertEquals(2, system.getCountByState("Maharashtra"));
        assertEquals(1, system.getCountByState("Delhi"));
        assertEquals(0, system.getCountByState("Karnataka"));
    }
    
    @Test
    public void testMultipleAddressBooksIndependence() {
        system.addAddressBook("Personal");
        system.addAddressBook("Work");
        
        AddressBook personal = system.getAddressBook("Personal");
        AddressBook work = system.getAddressBook("Work");
        
        personal.addContact(contact1);
        work.addContact(contact2);
        work.addContact(contact3);
        
        assertEquals(1, personal.getContacts().size());
        assertEquals(2, work.getContacts().size());
    }
}