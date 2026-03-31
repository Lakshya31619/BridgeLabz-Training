package com.lakshya;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddressBookTest {

    @Test
    void testAddContact() {
        AddressBookService service = new AddressBookService();
        Contact contact = new Contact("John", "1234567890", "john@test.com");

        service.addContact(contact);

        assertNotNull(contact);
    }
}
