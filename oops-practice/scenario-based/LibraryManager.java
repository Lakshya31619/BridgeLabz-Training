import java.util.ArrayList;
import java.util.List;
// Exception
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}
// Book class
class Book {
    private String title;
    private String author;
    private boolean isAvailable;
    public Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }
    public String getTitle() {
        return title;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void checkOut() throws BookNotAvailableException {
        if (!isAvailable) {
            throw new BookNotAvailableException(
                "Book is already checked out: " + title
            );
        }
        isAvailable = false;
    }
    public void display() {
        System.out.printf(
            "Title: %-20s Author: %-15s Status: %s%n",
            title, author, isAvailable ? "Available" : "Checked Out"
        );
    }
}
// Library class
class Library {
    private List<Book> books = new ArrayList<>();
    public void loadBooks(Book[] bookArray) {
        for (Book b : bookArray) {
            books.add(b);
        }
    }
    // Display all books
    public void displayBooks() {
        System.out.println("\n--- Library Books ---");
        for (Book b : books) {
            b.display();
        }
    }
    // Search by partial title
    public void searchByTitle(String keyword) {
        System.out.println("\nSearch Results:");
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                b.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found.");
        }
    }
    // Checkout book by exact title
    public void checkoutBook(String title)
            throws BookNotAvailableException {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                b.checkOut();
                System.out.println("Book checked out successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
public class LibraryManager {
    public static void main(String[] args) {
        Book[] bookArray = {
            new Book("Java Head First", "Keat", true),
            new Book("Data Structures", "Monu", true),
            new Book("Computer Networks", "Saroj", false),
            new Book("Database Systems", "Somya", true)
        };
        Library library = new Library();
        library.loadBooks(bookArray);
        library.displayBooks();
        library.searchByTitle("Data");
        // Checkout books
        try {
            library.checkoutBook("Computer Networks");
        } catch (BookNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            library.checkoutBook("Java Head First");
        } catch (BookNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
        //Output
        library.displayBooks();
    }
}