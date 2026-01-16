import java.util.List;
public interface AddressBookDAO {
    void addContact(ContactInfo person);
    void removeContact(String fullName);
    List <ContactInfo> getAllContacts();
}