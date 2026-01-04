import java.util.Scanner;
public class LibraryManager {
    // Arrays to store book details
    static String[] titles = {"Java Programming", "Data Structures", "Python Basics", "Web Development"};
    static String[] authors = {"Dinesh", "Ramesh", "Suresh", "Brijesh"};
    static boolean[] isAvailable = {true, true, true, true};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("\n1. Display Books");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Checkout Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    System.out.print("Enter part of book title to search: ");
                    String search = sc.nextLine();
                    searchBook(search);
                    break;
                case 3:
                    System.out.print("Enter book title to checkout: ");
                    String title = sc.nextLine();
                    checkoutBook(title);
                    break;
                case 4:
                    run = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    // Method to display all books
    public static void displayBooks() {
        for (int i = 0; i < titles.length; i++) {
            String status = isAvailable[i] ? "Available" : "Checked Out";
            System.out.println(titles[i] + " by " + authors[i] + " - " + status);
        }
    }
    // Method to search book by partial title
    public static void searchBook(String keyword) {
        boolean found = false;
        for (int i = 0; i < titles.length; i++) {
            if (titles[i].toLowerCase().contains(keyword.toLowerCase())) {
                String status = isAvailable[i] ? "Available" : "Checked Out";
                System.out.println(titles[i] + " by " + authors[i] + " - " + status);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching book found");
        }
    }
    // Method to checkout a book
    public static void checkoutBook(String title) {
        for (int i = 0; i < titles.length; i++) {
            if (titles[i].equalsIgnoreCase(title)) {
                if (isAvailable[i]) {
                    isAvailable[i] = false;
                    System.out.println("Book checked out successfully");
                } else {
                    System.out.println("Book is already checked out");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }
}