package com.lakshya;

import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {
        AddressBookService service = new AddressBookService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Address Book Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Delete Contact");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    service.addContact(new Contact(name, phone, email));
                    break;

                case 2:
                    service.viewContacts();
                    break;

                case 3:
                    System.out.print("Enter name to delete: ");
                    String deleteName = scanner.nextLine();
                    service.deleteContact(deleteName);
                    break;

                case 4:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }
}
