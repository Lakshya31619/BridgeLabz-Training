package service;

import model.AddressBook;
import model.Contact;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookSystem {
    
    private Map<String, AddressBook> addressBooks;
    
    public AddressBookSystem() {
        this.addressBooks = new HashMap<>();
    }
    
    /**
     * UC 6: Add a new address book
     */
    public boolean addAddressBook(String name) {
        if (addressBooks.containsKey(name)) {
            System.out.println("Address book with name '" + name + "' already exists!");
            return false;
        }
        addressBooks.put(name, new AddressBook(name));
        System.out.println("Address book '" + name + "' created successfully!");
        return true;
    }
    
    public AddressBook getAddressBook(String name) {
        return addressBooks.get(name);
    }
    
    public Map<String, AddressBook> getAllAddressBooks() {
        return addressBooks;
    }
    
    /**
     * UC 8: Search person across multiple address books by city or state
     */
    public List<Contact> searchPersonsByCity(String city) {
        return addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.searchByCity(city).stream())
                .collect(Collectors.toList());
    }
    
    public List<Contact> searchPersonsByState(String state) {
        return addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.searchByState(state).stream())
                .collect(Collectors.toList());
    }
    
    /**
     * UC 9: View persons by city or state across all address books
     */
    public Map<String, List<Contact>> viewPersonsByCity() {
        Map<String, List<Contact>> cityMap = new HashMap<>();
        addressBooks.values().forEach(addressBook -> {
            addressBook.getContactsByCity().forEach((city, contacts) -> {
                cityMap.computeIfAbsent(city, k -> new ArrayList<>()).addAll(contacts);
            });
        });
        return cityMap;
    }
    
    public Map<String, List<Contact>> viewPersonsByState() {
        Map<String, List<Contact>> stateMap = new HashMap<>();
        addressBooks.values().forEach(addressBook -> {
            addressBook.getContactsByState().forEach((state, contacts) -> {
                stateMap.computeIfAbsent(state, k -> new ArrayList<>()).addAll(contacts);
            });
        });
        return stateMap;
    }
    
    /**
     * UC 10: Get count of persons by city or state across all address books
     */
    public long getCountByCity(String city) {
        return addressBooks.values().stream()
                .mapToLong(addressBook -> addressBook.getCountByCity(city))
                .sum();
    }
    
    public long getCountByState(String state) {
        return addressBooks.values().stream()
                .mapToLong(addressBook -> addressBook.getCountByState(state))
                .sum();
    }
    
    public void displayAllAddressBooks() {
        if (addressBooks.isEmpty()) {
            System.out.println("No address books in the system!");
        } else {
            System.out.println("\n=== All Address Books ===");
            addressBooks.values().forEach(System.out::println);
        }
    }
}