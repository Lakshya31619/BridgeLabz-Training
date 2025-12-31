public class Book {
    // Attributes
    private String title;
    private String author;
    private double price;
    // Default constructor
    public Book() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.price = 0.0;
    }
    // Parameterized constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public double getPrice() {
        return price;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }
    public static void main(String[] args) {
        Book book1 = new Book();
        System.out.println("Book 1 Details:");
        System.out.println("Title: " + book1.getTitle());
        System.out.println("Author: " + book1.getAuthor());
        System.out.println("Price: " + book1.getPrice());
        System.out.println();
        Book book2 = new Book("2 States", "Chetan Bhagat", 49.99);
        System.out.println("Book 2 Details:");
        System.out.println("Title: " + book2.getTitle());
        System.out.println("Author: " + book2.getAuthor());
        System.out.println("Price: " + book2.getPrice());
    }
}