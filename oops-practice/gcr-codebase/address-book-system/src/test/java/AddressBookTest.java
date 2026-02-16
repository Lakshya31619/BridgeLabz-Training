import model.AddressBook;
import model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for AddressBook class
 */
public class AddressBookTest {
    
    private AddressBook addressBook;
    private Contact contact1;
    private Contact contact2;
    private Contact contact3;
    
    @BeforeEach
    public void setUp() {
        addressBook = new AddressBook("TestBook");
        
        contact1 = new Contact("John", "Doe", "123 Main St", "Mumbai", 
                              "Maharashtra", "400001", "9876543210", "john@email.com");
        contact2 = new Contact("Jane", "Smith", "456 Oak Ave", "Mumbai", 
                              "Maharashtra", "400002", "8765432109", "jane@email.com");
        contact3 = new Contact("Bob", "Johnson", "789 Elm St", "Delhi", 
                              "Delhi", "110001", "7654321098", "bob@email.com");
    }
    
    @Test
    public void testAddContact() {
        assertTrue(addressBook.addContact(contact1));
        assertEquals(1, addressBook.getContacts().size());
    }
    
    @Test
    public void testAddDuplicateContact() {
        addressBook.addContact(contact1);
        assertFalse(addressBook.addContact(contact1)); // Duplicate
        assertEquals(1, addressBook.getContacts().size());
    }
    
    @Test
    public void testEditContact() {
        addressBook.addContact(contact1);
        
        Contact updatedContact = new Contact();
        updatedContact.setFirstName("John");
        updatedContact.setLastName("Doe");
        updatedContact.setAddress("999 New St");
        updatedContact.setCity("Pune");
        updatedContact.setState("Maharashtra");
        updatedContact.setZip("411001");
        updatedContact.setPhoneNumber("9999999999");
        updatedContact.setEmail("john.new@email.com");
        
        assertTrue(addressBook.editContact("John", "Doe", updatedContact));
        
        Optional<Contact> edited = addressBook.findContactByName("John", "Doe");
        assertTrue(edited.isPresent());
        assertEquals("999 New St", edited.get().getAddress());
        assertEquals("Pune", edited.get().getCity());
    }
    
    @Test
    public void testEditNonExistentContact() {
        Contact updatedContact = new Contact();
        updatedContact.setFirstName("NonExistent");
        updatedContact.setLastName("Person");
        
        assertFalse(addressBook.editContact("NonExistent", "Person", updatedContact));
    }
    
    @Test
    public void testDeleteContact() {
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);
        
        assertTrue(addressBook.deleteContact("John", "Doe"));
        assertEquals(1, addressBook.getContacts().size());
        assertFalse(addressBook.findContactByName("John", "Doe").isPresent());
    }
    
    @Test
    public void testDeleteNonExistentContact() {
        assertFalse(addressBook.deleteContact("NonExistent", "Person"));
    }
    
    @Test
    public void testFindContactByName() {
        addressBook.addContact(contact1);
        
        Optional<Contact> found = addressBook.findContactByName("John", "Doe");
        assertTrue(found.isPresent());
        assertEquals("John", found.get().getFirstName());
    }
    
    @Test
    public void testSearchByCity() {
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);
        addressBook.addContact(contact3);
        
        List<Contact> mumbaiContacts = addressBook.searchByCity("Mumbai");
        assertEquals(2, mumbaiContacts.size());
        
        List<Contact> delhiContacts = addressBook.searchByCity("Delhi");
        assertEquals(1, delhiContacts.size());
    }
    
    @Test
    public void testSearchByState() {
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);
        addressBook.addContact(contact3);
        
        List<Contact> maharashtraContacts = addressBook.searchByState("Maharashtra");
        assertEquals(2, maharashtraContacts.size());
        
        List<Contact> delhiContacts = addressBook.searchByState("Delhi");
        assertEquals(1, delhiContacts.size());
    }
    
    @Test
    public void testGetContactsByCity() {
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);
        addressBook.addContact(contact3);
        
        Map<String, List<Contact>> cityMap = addressBook.getContactsByCity();
        assertEquals(2, cityMap.size());
        assertTrue(cityMap.containsKey("Mumbai"));
        assertTrue(cityMap.containsKey("Delhi"));
        assertEquals(2, cityMap.get("Mumbai").size());
    }
    
    @Test
    public void testGetContactsByState() {
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);
        addressBook.addContact(contact3);
        
        Map<String, List<Contact>> stateMap = addressBook.getContactsByState();
        assertEquals(2, stateMap.size());
        assertTrue(stateMap.containsKey("Maharashtra"));
        assertTrue(stateMap.containsKey("Delhi"));
    }
    
    @Test
    public void testGetCountByCity() {
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);
        addressBook.addContact(contact3);
        
        assertEquals(2, addressBook.getCountByCity("Mumbai"));
        assertEquals(1, addressBook.getCountByCity("Delhi"));
        assertEquals(0, addressBook.getCountByCity("Bangalore"));
    }
    
    @Test
    public void testGetCountByState() {
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);
        addressBook.addContact(contact3);
        
        assertEquals(2, addressBook.getCountByState("Maharashtra"));
        assertEquals(1, addressBook.getCountByState("Delhi"));
        assertEquals(0, addressBook.getCountByState("Karnataka"));
    }
    
    @Test
    public void testSortByName() {
        addressBook.addContact(contact3); // Bob
        addressBook.addContact(contact1); // John
        addressBook.addContact(contact2); // Jane
        
        List<Contact> sorted = addressBook.sortByName();
        assertEquals("Bob", sorted.get(0).getFirstName());
        assertEquals("Jane", sorted.get(1).getFirstName());
        assertEquals("John", sorted.get(2).getFirstName());
    }
    
    @Test
    public void testSortByCity() {
        addressBook.addContact(contact1); // Mumbai
        addressBook.addContact(contact3); // Delhi
        addressBook.addContact(contact2); // Mumbai
        
        List<Contact> sorted = addressBook.sortByCity();
        assertEquals("Delhi", sorted.get(0).getCity());
        assertEquals("Mumbai", sorted.get(1).getCity());
        assertEquals("Mumbai", sorted.get(2).getCity());
    }
    
    @Test
    public void testSortByState() {
        addressBook.addContact(contact1); // Maharashtra
        addressBook.addContact(contact3); // Delhi
        addressBook.addContact(contact2); // Maharashtra
        
        List<Contact> sorted = addressBook.sortByState();
        assertEquals("Delhi", sorted.get(0).getState());
        assertEquals("Maharashtra", sorted.get(1).getState());
    }
    
    @Test
    public void testSortByZip() {
        addressBook.addContact(contact3); // 110001
        addressBook.addContact(contact1); // 400001
        addressBook.addContact(contact2); // 400002
        
        List<Contact> sorted = addressBook.sortByZip();
        assertEquals("110001", sorted.get(0).getZip());
        assertEquals("400001", sorted.get(1).getZip());
        assertEquals("400002", sorted.get(2).getZip());
    }
}