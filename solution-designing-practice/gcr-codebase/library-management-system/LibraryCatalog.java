import java.util.List;
import java.util.ArrayList;
public class LibraryCatalog {
    private static LibraryCatalog instance;
    private List<Book> books = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    private LibraryCatalog() {}
    public static synchronized LibraryCatalog getInstance() {
        if (instance == null) {
            instance = new LibraryCatalog();
        }
        return instance;
    }
    public void addBook(Book book) {
        books.add(book);
        notifyObservers(book.getTitle());
    }
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    private void notifyObservers(String bookName) {
        for (Observer observer : observers) {
            observer.update("New book available: " + bookName);
        }
    }
}