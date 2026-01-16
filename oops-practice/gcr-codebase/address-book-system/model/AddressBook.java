import java.util.ArrayList;
import java.util.List;
public class AddressBook {
    private String name;
    private List<ContactInfo> contacts = new ArrayList<>();
    public AddressBook(String name){
        this.name = name;
    }
    public List<ContactInfo> getContacts(){
        return contacts;
    }
}