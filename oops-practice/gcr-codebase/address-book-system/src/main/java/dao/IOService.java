package dao;
import model.AddressBook;
import java.io.IOException;
public interface IOService {
    void writeAddressBook(AddressBook addressBook) throws IOException;
    AddressBook readAddressBook(String name) throws IOException;
}