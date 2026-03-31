import java.util.*;
class Library {
    private Map<String, LinkedList<Book>> catalog = new HashMap<>();
    private Set<Book> bookSet = new HashSet<>();
    // Add or Return Book
    public void addBook(String genre, Book book) {
        if (bookSet.contains(book)) {
            System.out.println("Duplicate book ignored: " + book.title);
            return;
        }
        catalog.putIfAbsent(genre, new LinkedList<>());
        catalog.get(genre).add(book);
        bookSet.add(book);
    }
    public void borrowBook(String genre, String isbn) {
        LinkedList<Book> books = catalog.get(genre);
        if (books == null) return;
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.isbn.equals(isbn)) {
                iterator.remove();
                bookSet.remove(book);
                System.out.println("Borrowed: " + book.title);
                return;
            }
        }
    }
    public void displayLibrary() {
        for (String genre : catalog.keySet()) {
            System.out.println("Genre: " + genre);
            for (Book book : catalog.get(genre)) {
                System.out.println("  - " + book.title + " by " + book.author);
            }
        }
    }
}