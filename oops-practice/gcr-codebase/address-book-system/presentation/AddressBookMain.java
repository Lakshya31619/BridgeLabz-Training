import java.util.Scanner;
public class AddressBookMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBookSystemService systemService = new AddressBookSystemService();
        AddressBookService currentBook = null;
        String currentBookName = null;
        System.out.println("Welcome to Address Book Program");
        while (true) {
            System.out.println("\n===== MAIN MENU =====");
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
                    currentBook = systemService.getAddressBook(name);
                    currentBookName = name;
                    System.out.println("Address Book created and selected: " + name);
                    break;
                case 2:
                    System.out.print("Enter Address Book name to switch: ");
                    String switchName = sc.nextLine();
                    AddressBookService book = systemService.getAddressBook(switchName);
                    if (book == null) {
                        System.out.println("Address Book not found.");
                    } else {
                        currentBook = book;
                        currentBookName = switchName;
                        System.out.println("Switched to Address Book: " + currentBookName);
                    }
                    break;
                case 3:
                    System.out.print("Enter Address Book name to delete: ");
                    String deleteName = sc.nextLine();
                    if (systemService.getAllAddressBooks().remove(deleteName) != null) {
                        System.out.println("Address Book deleted.");
                        if (deleteName.equals(currentBookName)) {
                            currentBook = null;
                            currentBookName = null;
                        }
                    } else {
                        System.out.println("Address Book not found.");
                    }
                    break;
                case 4:
                    if (currentBook == null) {
                        System.out.println("No Address Book selected.");
                        break;
                    }
                    manageAddressBook(sc, currentBook, currentBookName);
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
    //Address Book Menu
    private static void manageAddressBook(Scanner sc, AddressBookService service, String bookName) {
        while (true) {
            System.out.println("\nAddress Book: " + bookName);
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. View Contacts");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose option: ");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    ContactInfo person = readContact(sc);
                    boolean added = service.addContact(person);
                    System.out.println(added
                            ? "Contact added successfully"
                            : "Duplicate contact found");
                    break;
                case 2:
                    System.out.print("Enter full name to edit: ");
                    String editName = sc.nextLine();
                    ContactInfo updated = readContact(sc);
                    service.editContact(editName, updated);
                    System.out.println("Contact updated.");
                    break;
                case 3:
                    System.out.print("Enter full name to delete: ");
                    String deleteName = sc.nextLine();
                    service.deleteContact(deleteName);
                    System.out.println("Contact deleted.");
                    break;
                case 4:
                    service.displayContacts();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
    //Contact input menu
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
        return new ContactInfo(firstName, lastName, address,city, state, zip, phone, email);
    }
}