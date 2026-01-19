import java.util.Scanner;
import java.util.List;
public class AddressBookMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBookService systemService = new AddressBookService();
        String currentBookName = null;
        System.out.println("Welcome to Address Book Program");
        //Use Case - 6 : Add multiple Address Book
        while (true) {
            System.out.println("\nMain Menu : ");
            System.out.println("1. Create Address Book");
            System.out.println("2. Switch Address Book");
            System.out.println("3. Delete Address Book");
            System.out.println("4. Manage Current Address Book");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter new Address Book name: ");
                    String name = sc.nextLine();
                    systemService.addAddressBook(name);
                    currentBookName = name;
                    System.out.println("Address Book created and selected: " + name);
                    break;
                case 2:
                    System.out.print("Enter Address Book name to switch: ");
                    String switchName = sc.nextLine();
                    if (systemService.getAddressBookContacts(switchName) == null) {
                        System.out.println("Address Book not found.");
                    } else {
                        currentBookName = switchName;
                        System.out.println("Switched to Address Book: " + currentBookName);
                    }
                    break;
                case 3:
                    System.out.print("Enter Address Book name to delete: ");
                    String deleteName = sc.nextLine();
                    systemService.deleteAddressBook(deleteName);
                    if (deleteName.equals(currentBookName)) {
                        currentBookName = null;
                    }
                    System.out.println("Address Book deleted.");
                    break;
                case 4:
                    if (currentBookName == null) {
                        System.out.println("No Address Book selected.");
                    } else {
                        manageAddressBook(sc, systemService, currentBookName);
                    }
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
    // Address Book Menu
    private static void manageAddressBook(Scanner sc, AddressBookService systemService, String bookName) {
        // Use Case - 5 : Add multiple person
        while (true) {
            System.out.println("\nAddress Book: " + bookName);
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. View Contacts");
            System.out.println("5. Search Person by City");
            System.out.println("6. Search Person by State");
            System.out.println("7. Count Person by City");
            System.out.println("8. Count Person by State");
            System.out.println("9. Back");
            System.out.print("Choose option: ");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                //Use Case - 2 : Add new contact
                    ContactInfo person = readContact(sc);
                    //Use Case - 7 : No Duplicate Contact
                    boolean added = systemService.addContactToBook(bookName, person);
                    System.out.println(added ? "Contact added successfully" : "Duplicate contact found");
                    break;
                //Use case - 3 : Edit existing contact
                case 2:
                    System.out.print("Enter full name to edit: ");
                    String editName = sc.nextLine();
                    ContactInfo updated = readContact(sc);
                    systemService.editContactInBook(bookName, editName, updated);
                    System.out.println("Contact updated.");
                    break;
                //Use case - 4 : Delete a person
                case 3:
                    System.out.print("Enter full name to delete: ");
                    String deleteName = sc.nextLine();
                    systemService.removeContactFromBook(bookName, deleteName);
                    System.out.println("Contact deleted.");
                    break;
                case 4:
                    List<ContactInfo> contacts = systemService.getAddressBookContacts(bookName);
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts found.");
                    } else {
                        contacts.forEach(System.out::println);
                    }
                    break;
                //Use Case - 8/9 : Search/View Person by City/State
                case 5:
                    System.out.print("Enter City: ");
                    String city = sc.nextLine();
                    systemService.searchPersonsByCity(city).forEach(System.out::println);
                    break;
                case 6:
                    System.out.print("Enter State: ");
                    String state = sc.nextLine();
                    systemService.searchPersonsByState(state).forEach(System.out::println);
                    break;
                //Use Case 10 : Count by City/State
                case 7:
                    System.out.print("Enter City: ");
                    String countCity = sc.nextLine();
                    System.out.println("Count: " + systemService.countPersonsByCity(countCity));
                    break;

                case 8:
                    System.out.print("Enter State: ");
                    String countState = sc.nextLine();
                    System.out.println("Count: " + systemService.countPersonsByState(countState));
                    break;
                case 9:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
    // Contact Input
    private static ContactInfo readContact(Scanner sc) {
        System.out.print("First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Last Name: ");
        String lastName = sc.nextLine();
        System.out.print("Address: ");
        String address = sc.nextLine();
        System.out.print("City: ");
        String city = sc.nextLine();
        System.out.print("State: ");
        String state = sc.nextLine();
        System.out.print("Zip: ");
        int zip = sc.nextInt();
        sc.nextLine();
        System.out.print("Phone Number: ");
        String phone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        return new ContactInfo(firstName, lastName, address, city, state, zip, phone, email);
    }
}