public class AddressBookService {
    private AddressBookDAO dao;
    public AddressBookService(AddressBookDAO dao) {
        this.dao = dao;
    }
    // Use Case 7 : No Duplicates
    public boolean addContact(ContactInfo person) {
        boolean duplicate = dao.getAllContacts().stream().anyMatch(p -> p.equals(person));
        if (duplicate) {
            return false;
        }
        dao.addContact(person);
        return true;
    }
    // Use Case 3 : Edit a contact
    public void editContact(String name, ContactInfo updatedPerson) {
        deleteContact(name);
        dao.addContact(updatedPerson);
    }
    // Use Case 4
    public void deleteContact(String name) {
        dao.removeContact(name);
    }
    public void displayContacts() {
        dao.getAllContacts().forEach(System.out::println);
    }
}