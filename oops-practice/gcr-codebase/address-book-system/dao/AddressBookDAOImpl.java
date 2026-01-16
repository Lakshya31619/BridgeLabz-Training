import java.util.ArrayList;
import java.util.List;
public class AddressBookDAOImpl implements AddressBookDAO{
    List <ContactInfo> contactList = new ArrayList<>();
    @Override
    public void addContact(ContactInfo person){
        contactList.add(person);
    }
    @Override
    public void removeContact(String fullName){
        contactList.removeIf(p -> p.getFullName().equalsIgnoreCase(fullName));
    }
    @Override
    public List<ContactInfo> getAllContacts(){
        return contactList;
    }
}