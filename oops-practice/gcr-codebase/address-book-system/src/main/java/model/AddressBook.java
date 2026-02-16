package model;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
    
    private String name;
    private List<Contact> contacts;
    
    public AddressBook(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public List<Contact> getContacts() {
        return contacts;
    }
    
    /**
     * UC 2: Add a new contact to address book
     * UC 7: Check for duplicate before adding
     */
    public boolean addContact(Contact contact) {
        if (contacts.contains(contact)) {
            System.out.println("Contact with name " + contact.getFullName() + " already exists!");
            return false;
        }
        contacts.add(contact);
        return true;
    }
    
    /**
     * UC 3: Edit existing contact by name
     */
    public boolean editContact(String firstName, String lastName, Contact updatedContact) {
        Optional<Contact> existingContact = findContactByName(firstName, lastName);
        if (existingContact.isPresent()) {
            Contact contact = existingContact.get();
            contact.setAddress(updatedContact.getAddress());
            contact.setCity(updatedContact.getCity());
            contact.setState(updatedContact.getState());
            contact.setZip(updatedContact.getZip());
            contact.setPhoneNumber(updatedContact.getPhoneNumber());
            contact.setEmail(updatedContact.getEmail());
            return true;
        }
        return false;
    }
    
    /**
     * UC 4: Delete a person by name
     */
    public boolean deleteContact(String firstName, String lastName) {
        return contacts.removeIf(contact -> 
            contact.getFirstName().equalsIgnoreCase(firstName) && 
            contact.getLastName().equalsIgnoreCase(lastName));
    }
    
    /**
     * Helper method to find contact by name
     */
    public Optional<Contact> findContactByName(String firstName, String lastName) {
        return contacts.stream()
                .filter(contact -> contact.getFirstName().equalsIgnoreCase(firstName) && 
                               contact.getLastName().equalsIgnoreCase(lastName))
                .findFirst();
    }
    
    /**
     * UC 8: Search persons by city or state
     */
    public List<Contact> searchByCity(String city) {
        return contacts.stream()
                .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }
    
    public List<Contact> searchByState(String state) {
        return contacts.stream()
                .filter(contact -> contact.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }
    
    /**
     * UC 9: View persons by city or state
     */
    public Map<String, List<Contact>> getContactsByCity() {
        return contacts.stream()
                .collect(Collectors.groupingBy(Contact::getCity));
    }
    
    public Map<String, List<Contact>> getContactsByState() {
        return contacts.stream()
                .collect(Collectors.groupingBy(Contact::getState));
    }
    
    /**
     * UC 10: Get count of contacts by city or state
     */
    public long getCountByCity(String city) {
        return contacts.stream()
                .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                .count();
    }
    
    public long getCountByState(String state) {
        return contacts.stream()
                .filter(contact -> contact.getState().equalsIgnoreCase(state))
                .count();
    }
    
    /**
     * UC 11: Sort contacts by person name
     */
    public List<Contact> sortByName() {
        return contacts.stream()
                .sorted(Comparator.comparing(Contact::getFirstName)
                        .thenComparing(Contact::getLastName))
                .collect(Collectors.toList());
    }
    
    /**
     * UC 12: Sort contacts by city, state, or zip
     */
    public List<Contact> sortByCity() {
        return contacts.stream()
                .sorted(Comparator.comparing(Contact::getCity))
                .collect(Collectors.toList());
    }
    
    public List<Contact> sortByState() {
        return contacts.stream()
                .sorted(Comparator.comparing(Contact::getState))
                .collect(Collectors.toList());
    }
    
    public List<Contact> sortByZip() {
        return contacts.stream()
                .sorted(Comparator.comparing(Contact::getZip))
                .collect(Collectors.toList());
    }
    
    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts in address book: " + name);
        } else {
            System.out.println("\n=== Address Book: " + name + " ===");
            contacts.forEach(System.out::println);
        }
    }
    
    @Override
    public String toString() {
        return "AddressBook{name='" + name + "', contacts=" + contacts.size() + "}";
    }
}