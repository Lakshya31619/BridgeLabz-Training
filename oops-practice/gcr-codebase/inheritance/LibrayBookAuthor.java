// Superclass
class Book {
    protected String title;
    protected int publicationYear;
    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}
// Subclass
class Author extends Book {
    private String name;
    private String bio;
    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}
public class LibrayBookAuthor {
    public static void main(String[] args) {
        Book book = new Author(
                "Head First Java",
                2020,
                "Keat Kates",
                "A complete knowledge of JAVA"
        );
        book.displayInfo();
    }
}