public class AddressBookService {
    private AddressBookDAO dao;
    public AddressBookService(AddressBookDAO dao) {
        this.dao = dao;
    }
    // Use Case 2 & 7 : Add contact with no duplicates
    public boolean addContact(ContactInfo person) {
        boolean duplicate =dao.getAllContacts().stream().anyMatch(p -> p.equals(person));
        if (duplicate) {
            return false;
        }
        dao.addContact(person);
        return true;
    }
    // Use Case 3 : Edit contact
    public void editContact(String fullName, ContactInfo updatedPerson) {
        deleteContact(fullName);
        dao.addContact(updatedPerson);
    }
    // Use Case 4 : Delete contact
    public void deleteContact(String fullName) {
        dao.removeContact(fullName);
    }
    // Display contacts
    public void displayContacts() {
        dao.getAllContacts().forEach(System.out::println);
    }
}