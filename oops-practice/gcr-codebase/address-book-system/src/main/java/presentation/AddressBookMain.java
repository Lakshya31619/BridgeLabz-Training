package presentation;
import dao.*;
import model.AddressBook;
import model.Contact;
import service.AddressBookSystem;
import java.io.IOException;
import java.util.*;
public class AddressBookMain {
    private static Scanner scanner = new Scanner(System.in);
    private static AddressBookSystem addressBookSystem = new AddressBookSystem();
    private static IOService currentIOService;
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("Welcome to Address Book Program");
        System.out.println("========================================\n");
        boolean exit = false;
        while (!exit) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    addNewAddressBook();
                    break;
                case 2:
                    selectAndManageAddressBook();
                    break;
                case 3:
                    searchAcrossAddressBooks();
                    break;
                case 4:
                    viewPersonsByCityOrState();
                    break;
                case 5:
                    getCountByCityOrState();
                    break;
                case 6:
                    saveAddressBook();
                    break;
                case 7:
                    loadAddressBook();
                    break;
                case 8:
                    displayAllAddressBooks();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Thank you for using Address Book System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        
        scanner.close();
    }
    private static void displayMainMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1. Add New Address Book");
        System.out.println("2. Select & Manage Address Book");
        System.out.println("3. Search Across Address Books");
        System.out.println("4. View Persons by City/State");
        System.out.println("5. Get Count by City/State");
        System.out.println("6. Save Address Book");
        System.out.println("7. Load Address Book");
        System.out.println("8. Display All Address Books");
        System.out.println("0. Exit");
        System.out.println("================================");
    }
    private static void addNewAddressBook() {
        System.out.print("Enter address book name: ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty()) {
            addressBookSystem.addAddressBook(name);
        } else {
            System.out.println("Invalid name!");
        }
    }
    private static void selectAndManageAddressBook() {
        System.out.print("Enter address book name: ");
        String name = scanner.nextLine().trim();
        AddressBook addressBook = addressBookSystem.getAddressBook(name);
        if (addressBook == null) {
            System.out.println("Address book not found!");
            return;
        }
        boolean back = false;
        while (!back) {
            displayAddressBookMenu();
            int choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    addContact(addressBook);
                    break;
                case 2:
                    editContact(addressBook);
                    break;
                case 3:
                    deleteContact(addressBook);
                    break;
                case 4:
                    addressBook.displayAllContacts();
                    break;
                case 5:
                    sortAndDisplayContacts(addressBook);
                    break;
                case 6:
                    searchInAddressBook(addressBook);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    } 
    private static void displayAddressBookMenu() {
        System.out.println("\n========== ADDRESS BOOK MENU ==========");
        System.out.println("1. Add Contact");
        System.out.println("2. Edit Contact");
        System.out.println("3. Delete Contact");
        System.out.println("4. Display All Contacts");
        System.out.println("5. Sort Contacts");
        System.out.println("6. Search in Address Book");
        System.out.println("0. Back to Main Menu");
        System.out.println("========================================");
    }
    
    private static void addContact(AddressBook addressBook) {
        System.out.println("\n--- Add New Contact ---");
        
        try {
            System.out.print("First Name: ");
            String firstName = scanner.nextLine().trim();
            
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine().trim();
            
            System.out.print("Address: ");
            String address = scanner.nextLine().trim();
            
            System.out.print("City: ");
            String city = scanner.nextLine().trim();
            
            System.out.print("State: ");
            String state = scanner.nextLine().trim();
            
            System.out.print("Zip Code: ");
            String zip = scanner.nextLine().trim();
            
            System.out.print("Phone Number (10 digits): ");
            String phone = scanner.nextLine().trim();
            
            System.out.print("Email: ");
            String email = scanner.nextLine().trim();
            
            Contact contact = new Contact(firstName, lastName, address, city, state, zip, phone, email);
            
            if (addressBook.addContact(contact)) {
                System.out.println("Contact added successfully!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void editContact(AddressBook addressBook) {
        System.out.print("Enter first name of contact to edit: ");
        String firstName = scanner.nextLine().trim();
        
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine().trim();
        
        Optional<Contact> existingContact = addressBook.findContactByName(firstName, lastName);
        
        if (existingContact.isPresent()) {
            System.out.println("Current contact: " + existingContact.get());
            System.out.println("\nEnter new details (press Enter to keep current value):");
            
            try {
                Contact updatedContact = new Contact();
                updatedContact.setFirstName(firstName);
                updatedContact.setLastName(lastName);
                
                System.out.print("Address: ");
                String address = scanner.nextLine().trim();
                updatedContact.setAddress(address.isEmpty() ? existingContact.get().getAddress() : address);
                
                System.out.print("City: ");
                String city = scanner.nextLine().trim();
                updatedContact.setCity(city.isEmpty() ? existingContact.get().getCity() : city);
                
                System.out.print("State: ");
                String state = scanner.nextLine().trim();
                updatedContact.setState(state.isEmpty() ? existingContact.get().getState() : state);
                
                System.out.print("Zip: ");
                String zip = scanner.nextLine().trim();
                updatedContact.setZip(zip.isEmpty() ? existingContact.get().getZip() : zip);
                
                System.out.print("Phone: ");
                String phone = scanner.nextLine().trim();
                updatedContact.setPhoneNumber(phone.isEmpty() ? existingContact.get().getPhoneNumber() : phone);
                
                System.out.print("Email: ");
                String email = scanner.nextLine().trim();
                updatedContact.setEmail(email.isEmpty() ? existingContact.get().getEmail() : email);
                
                if (addressBook.editContact(firstName, lastName, updatedContact)) {
                    System.out.println("Contact updated successfully!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Contact not found!");
        }
    }
    
    private static void deleteContact(AddressBook addressBook) {
        System.out.print("Enter first name of contact to delete: ");
        String firstName = scanner.nextLine().trim();
        
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine().trim();
        
        if (addressBook.deleteContact(firstName, lastName)) {
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found!");
        }
    }
    
    private static void sortAndDisplayContacts(AddressBook addressBook) {
        System.out.println("\n--- Sort Contacts ---");
        System.out.println("1. Sort by Name");
        System.out.println("2. Sort by City");
        System.out.println("3. Sort by State");
        System.out.println("4. Sort by Zip");
        
        int choice = getIntInput("Enter your choice: ");
        List<Contact> sortedContacts;
        
        switch (choice) {
            case 1:
                sortedContacts = addressBook.sortByName();
                break;
            case 2:
                sortedContacts = addressBook.sortByCity();
                break;
            case 3:
                sortedContacts = addressBook.sortByState();
                break;
            case 4:
                sortedContacts = addressBook.sortByZip();
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        
        System.out.println("\n--- Sorted Contacts ---");
        sortedContacts.forEach(System.out::println);
    }
    
    private static void searchInAddressBook(AddressBook addressBook) {
        System.out.println("\n--- Search ---");
        System.out.println("1. Search by City");
        System.out.println("2. Search by State");
        
        int choice = getIntInput("Enter your choice: ");
        
        switch (choice) {
            case 1:
                System.out.print("Enter city: ");
                String city = scanner.nextLine().trim();
                List<Contact> cityContacts = addressBook.searchByCity(city);
                displaySearchResults(cityContacts);
                break;
            case 2:
                System.out.print("Enter state: ");
                String state = scanner.nextLine().trim();
                List<Contact> stateContacts = addressBook.searchByState(state);
                displaySearchResults(stateContacts);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    
    private static void searchAcrossAddressBooks() {
        System.out.println("\n--- Search Across All Address Books ---");
        System.out.println("1. Search by City");
        System.out.println("2. Search by State");
        
        int choice = getIntInput("Enter your choice: ");
        
        switch (choice) {
            case 1:
                System.out.print("Enter city: ");
                String city = scanner.nextLine().trim();
                List<Contact> cityContacts = addressBookSystem.searchPersonsByCity(city);
                displaySearchResults(cityContacts);
                break;
            case 2:
                System.out.print("Enter state: ");
                String state = scanner.nextLine().trim();
                List<Contact> stateContacts = addressBookSystem.searchPersonsByState(state);
                displaySearchResults(stateContacts);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    
    private static void viewPersonsByCityOrState() {
        System.out.println("\n--- View Persons ---");
        System.out.println("1. View by City");
        System.out.println("2. View by State");
        
        int choice = getIntInput("Enter your choice: ");
        
        switch (choice) {
            case 1:
                Map<String, List<Contact>> cityMap = addressBookSystem.viewPersonsByCity();
                System.out.println("\n--- Persons by City ---");
                cityMap.forEach((city, contacts) -> {
                    System.out.println("\nCity: " + city + " (Count: " + contacts.size() + ")");
                    contacts.forEach(System.out::println);
                });
                break;
            case 2:
                Map<String, List<Contact>> stateMap = addressBookSystem.viewPersonsByState();
                System.out.println("\n--- Persons by State ---");
                stateMap.forEach((state, contacts) -> {
                    System.out.println("\nState: " + state + " (Count: " + contacts.size() + ")");
                    contacts.forEach(System.out::println);
                });
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    
    private static void getCountByCityOrState() {
        System.out.println("\n--- Get Count ---");
        System.out.println("1. Count by City");
        System.out.println("2. Count by State");
        
        int choice = getIntInput("Enter your choice: ");
        
        switch (choice) {
            case 1:
                System.out.print("Enter city: ");
                String city = scanner.nextLine().trim();
                long cityCount = addressBookSystem.getCountByCity(city);
                System.out.println("Number of persons in " + city + ": " + cityCount);
                break;
            case 2:
                System.out.print("Enter state: ");
                String state = scanner.nextLine().trim();
                long stateCount = addressBookSystem.getCountByState(state);
                System.out.println("Number of persons in " + state + ": " + stateCount);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    
    private static void saveAddressBook() {
        System.out.print("Enter address book name to save: ");
        String name = scanner.nextLine().trim();
        AddressBook addressBook = addressBookSystem.getAddressBook(name);
        
        if (addressBook == null) {
            System.out.println("Address book not found!");
            return;
        }
        
        System.out.println("\n--- Select Save Format ---");
        System.out.println("1. Text File");
        System.out.println("2. CSV File");
        System.out.println("3. JSON File");
        System.out.println("4. Database");
        System.out.println("5. REST API (JSON Server)");
        
        int choice = getIntInput("Enter your choice: ");
        
        try {
            switch (choice) {
                case 1:
                    currentIOService = new FileIOService();
                    break;
                case 2:
                    currentIOService = new CSVIOService();
                    break;
                case 3:
                    currentIOService = new JSONIOService();
                    break;
                case 4:
                    currentIOService = new DatabaseIOService();
                    break;
                case 5:
                    currentIOService = new RestAPIService();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    return;
            }
            
            currentIOService.writeAddressBook(addressBook);
            Thread.sleep(1000); // Wait for async operation
            
        } catch (IOException | InterruptedException e) {
            System.err.println("Error saving address book: " + e.getMessage());
        }
    }
    
    private static void loadAddressBook() {
        System.out.print("Enter address book name to load: ");
        String name = scanner.nextLine().trim();
        
        System.out.println("\n--- Select Load Format ---");
        System.out.println("1. Text File");
        System.out.println("2. CSV File");
        System.out.println("3. JSON File");
        System.out.println("4. Database");
        System.out.println("5. REST API (JSON Server)");
        
        int choice = getIntInput("Enter your choice: ");
        
        try {
            switch (choice) {
                case 1:
                    currentIOService = new FileIOService();
                    break;
                case 2:
                    currentIOService = new CSVIOService();
                    break;
                case 3:
                    currentIOService = new JSONIOService();
                    break;
                case 4:
                    currentIOService = new DatabaseIOService();
                    break;
                case 5:
                    currentIOService = new RestAPIService();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    return;
            }
            
            AddressBook loadedAddressBook = currentIOService.readAddressBook(name);
            Thread.sleep(1000); // Wait for async operation
            
            addressBookSystem.addAddressBook(name);
            AddressBook systemAddressBook = addressBookSystem.getAddressBook(name);
            loadedAddressBook.getContacts().forEach(systemAddressBook::addContact);
            
        } catch (IOException | InterruptedException e) {
            System.err.println("Error loading address book: " + e.getMessage());
        }
    }
    
    private static void displayAllAddressBooks() {
        addressBookSystem.displayAllAddressBooks();
        addressBookSystem.getAllAddressBooks().values().forEach(AddressBook::displayAllContacts);
    }
    
    private static void displaySearchResults(List<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found!");
        } else {
            System.out.println("\n--- Search Results (" + contacts.size() + ") ---");
            contacts.forEach(System.out::println);
        }
    }
    
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }
}