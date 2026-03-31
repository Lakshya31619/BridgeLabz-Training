public class BookLibrary {
    // Access modifiers
    public String ISBN;     
    protected String title;     
    private String author;        
    // Constructor
    public BookLibrary(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }
    // Public methods to access and modify author
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    // Method to display book details
    public void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
    public static void main(String[] args) {
        BookLibrary b1 = new BookLibrary("978-0134685991", "Effective Java", "Joshua Bloch");
        b1.displayBookDetails();
        System.out.println();
        b1.setAuthor("J. Bloch");
        System.out.println("Updated Author: " + b1.getAuthor());
    }
}