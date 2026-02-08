package com.lakshya;

import java.util.List;

public class AddressBookService {

    private final AddressBookRepository repository;

    public AddressBookService() {
        this.repository = new AddressBookRepository();
    }

    public void addContact(Contact contact) {
        repository.save(contact);
        System.out.println("Contact added successfully.");
    }

    public void viewContacts() {
        List<Contact> contacts = repository.findAll();
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void deleteContact(String name) {
        boolean removed = repository.deleteByName(name);
        if (removed) {
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }
}
