import java.util.Map;
import java.util.HashMap;
public class AddressBookSystemService {
    // Use Case 6 : Multiple Address Books
    private Map<String, AddressBookService> addressBookMap = new HashMap<>();
    // Add a new address book
    public void addAddressBook(String name) {
        addressBookMap.putIfAbsent(name, new AddressBookService(new AddressBookDAOImpl()));
    }
    // Get a specific address book service
    public AddressBookService getAddressBook(String name) {
        return addressBookMap.get(name);
    }
    // Get all address books
    public Map<String, AddressBookService> getAllAddressBooks() {
        return addressBookMap;
    }
}