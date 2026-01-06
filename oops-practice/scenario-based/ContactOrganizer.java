import java.util.ArrayList;
import java.util.Scanner;
//Exception
class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}
// Contact class
class Contact {
    private String name;
    private String phoneNumber;
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
// Contact Manager class
class ContactManager {
    private ArrayList<Contact> contacts = new ArrayList<>();
    // Add contact
    public void addContact(String name, String phone)
            throws InvalidPhoneNumberException {

        if (!phone.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException(
                "Phone number must be exactly 10 digits."
            );
        }
        if (isDuplicate(phone)) {
            throw new InvalidPhoneNumberException(
                "Duplicate contact. Phone number already exists."
            );
        }
        contacts.add(new Contact(name, phone));
    }
    // Delete contact
    public void deleteContact(String phone)
            throws InvalidPhoneNumberException {

        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phone)) {
                contacts.remove(c);
                return;
            }
        }
        throw new InvalidPhoneNumberException("Contact not found.");
    }
    // Search contact
    public Contact searchContact(String phone) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phone)) {
                return c;
            }
        }
        return null;
    }
    // Check duplicate phone number
    private boolean isDuplicate(String phone) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phone)) {
                return true;
            }
        }
        return false;
    }
}
public class ContactOrganizer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactManager manager = new ContactManager();
        int choice;
        do {
            System.out.println("\n===== Phone Contact Organizer =====");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter phone number: ");
                        String phone = sc.nextLine();
                        manager.addContact(name, phone);
                        System.out.println("Contact added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter phone number to delete: ");
                        String delPhone = sc.nextLine();
                        manager.deleteContact(delPhone);
                        System.out.println("Contact deleted successfully.");
                        break;
                    case 3:
                        System.out.print("Enter phone number to search: ");
                        String searchPhone = sc.nextLine();
                        Contact c = manager.searchContact(searchPhone);
                        if (c != null) {
                            System.out.println("Name: " + c.getName());
                            System.out.println("Phone: " + c.getPhoneNumber());
                        } else {
                            System.out.println("Contact not found.");
                        }
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (InvalidPhoneNumberException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 4);
    }
}