public class BookFinal {
    // Static variable
    private static String libraryName = "Egmore Library";
    // Final variable
    private final String isbn;
    private String title;
    private String author;
    // Constructor using 'this'
    public BookFinal(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn; // final variable
    }
    // Static method to display library name
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
    // Method to display book details using instanceof
    public void displayBookDetails() {
        if (this instanceof BookFinal) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        } else {
            System.out.println("Invalid book object.");
        }
    }
    public static void main(String[] args) {
        // Create a book object
        BookFinal book1 = new BookFinal("Effective Java","Joshua Bloch","978-0134685991");
        // Display library name
        BookFinal.displayLibraryName();
        // Display book details
        book1.displayBookDetails();
    }
}