import java.util.*;
public class AddressBookSystemService {
    private Map<String, List<ContactInfo>> addressBookMap = new HashMap<>();
    private Map<String, List<ContactInfo>> cityPersonMap = new HashMap<>();
    private Map<String, List<ContactInfo>> statePersonMap = new HashMap<>();
    // Use Case - 3: Edit contact
    public void editContactInBook(String bookName, String fullName, ContactInfo updatedPerson) {
        removeContactFromBook(bookName, fullName);
        addContactToBook(bookName, updatedPerson);
    }
    // Use Case - 4: Delete contact
    public void removeContactFromBook(String bookName, String fullName) {
        List<ContactInfo> contacts = addressBookMap.get(bookName);
        if (contacts != null) {
            contacts.removeIf(
                c -> c.getFullName().equalsIgnoreCase(fullName)
            );
        }
    }
    // Use Case - 6 : Add Multiple Address Books
    public void addAddressBook(String name) {
        addressBookMap.putIfAbsent(name, new ArrayList<>());
    }
    public void deleteAddressBook(String name) {
        addressBookMap.remove(name);
    }
    public List<ContactInfo> getAddressBookContacts(String name) {
        return addressBookMap.get(name);
    }
    public boolean addContactToBook(String bookName, ContactInfo person) {
        // Use Case - 7 : Duplicate Check
        List<ContactInfo> contacts = addressBookMap.get(bookName);
        if (contacts == null || contacts.contains(person)) {
            return false;
        }
        //Use Case - 2 : Add new Contact
        contacts.add(person);
        addToCityDictionary(person);
        addToStateDictionary(person);
        return true;
    }
    // Use Case - 8 : Search persons by City/State across all address books
    public List<ContactInfo> searchPersonsByCity(String city) {
        return cityPersonMap.getOrDefault(city.toLowerCase(), new ArrayList<>());
    }
    public List<ContactInfo> searchPersonsByState(String state) {
        return statePersonMap.getOrDefault(state.toLowerCase(), new ArrayList<>());
    }
    // Use Case - 9 : Maintain City/State Persons dictionary
    private void addToCityDictionary(ContactInfo person) {
        cityPersonMap.computeIfAbsent(person.getCity().toLowerCase(), k -> new ArrayList<>()).add(person);
    }
    private void addToStateDictionary(ContactInfo person) {
        statePersonMap.computeIfAbsent(person.getState().toLowerCase(), k -> new ArrayList<>()).add(person);
    }
    // Use Case - 10 : Count persons by City/State
    public int countPersonsByCity(String city) {
        return cityPersonMap.getOrDefault(city.toLowerCase(), new ArrayList<>()).size();
    }
    public int countPersonsByState(String state) {
        return statePersonMap.getOrDefault(state.toLowerCase(), new ArrayList<>()).size();
    }
}