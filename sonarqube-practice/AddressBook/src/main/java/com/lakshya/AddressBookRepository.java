package com.lakshya;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddressBookRepository {

    private final List<Contact> contacts = new ArrayList<>();

    public void save(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> findAll() {
        return new ArrayList<>(contacts);
    }

    public boolean deleteByName(String name) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
