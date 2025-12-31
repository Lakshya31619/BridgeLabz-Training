public class BookLib {
    // Attributes (encapsulation)
    private String title;
    private String author;
    private double price;
    private boolean available;
    // Default constructor
    public BookLib() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.price = 0.0;
        this.available = true;
    }
    // Parameterized constructor
    public BookLib(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true; // Book is available by default
    }
    // Method to borrow a book
    public boolean borrowBook() {
        if (available) {
            available = false;
            return true; // Borrow successful
        } else {
            return false; // Book already borrowed
        }
    }
    // Method to return a book
    public void returnBook() {
        available = true;
    }
    // Getters
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public double getPrice() {
        return price;
    }
    public boolean isAvailable() {
        return available;
    }
    public static void main(String[] args) {
        BookLib book = new BookLib("Head First Java", "Bert Bates", 1250.0);
        System.out.println("Book: " + book.getTitle());
        System.out.println("Available: " + book.isAvailable());
        // Borrow the book
        if (book.borrowBook()) {
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Book is already borrowed.");
        }
        System.out.println("Available after borrowing: " + book.isAvailable());
        // Try borrowing again
        if (book.borrowBook()) {
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Book is already borrowed.");
        }
        // Return the book
        book.returnBook();
        System.out.println("Available after return: " + book.isAvailable());
    }
}