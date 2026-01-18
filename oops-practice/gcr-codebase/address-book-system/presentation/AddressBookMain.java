import java.util.Scanner;
public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Scanner sc = new Scanner(System.in);
        AddressBookService service = new AddressBookService(new AddressBookDAOImpl());
        // Use Case 5 : Add Multiple Contacts
        boolean continueAdding = true;
        while (continueAdding) {
            System.out.print("Enter First Name: ");
            String firstName = sc.nextLine();
            System.out.print("Enter Last Name: ");
            String lastName = sc.nextLine();
            System.out.print("Enter Address: ");
            String address = sc.nextLine();
            System.out.print("Enter City: ");
            String city = sc.nextLine();
            System.out.print("Enter State: ");
            String state = sc.nextLine();
            System.out.print("Enter Zip: ");
            int zip = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Phone Number: ");
            String phone = sc.nextLine();
            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            // Use Case 2
            ContactInfo person = new ContactInfo(firstName, lastName, address, city, state, zip, phone, email);
            boolean added = service.addContact(person);
            if (added) {
                System.out.println("Contact added successfully");
            } else {
                System.out.println("Duplicate contact found");
            }
            System.out.print("Do you want to add another contact? (yes/no): ");
            String choice = sc.nextLine();

            if (!choice.equalsIgnoreCase("yes")) {
                continueAdding = false;
            }
        }
        System.out.println("\nAll Contacts:");
        service.displayContacts();
    }
}