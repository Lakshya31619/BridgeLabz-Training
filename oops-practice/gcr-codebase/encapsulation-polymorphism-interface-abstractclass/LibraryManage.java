import java.util.ArrayList;
import java.util.List;

//Main class
public class LibraryManage {

    public static void main(String[] args) {

        List<BaseLibraryItem> items = new ArrayList<>();

        items.add(new LibraryBook("B101", "Head First Java", "Keat Keates"));
        items.add(new LibraryMagazine("M202", "Champak", "Nand Kishore"));
        items.add(new LibraryDVD("D303", "Dhurandhar", "Aditya Dhar"));

        // Polymorphic processing
        for (BaseLibraryItem item : items) {

            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration : " + item.getLoanDuration() + " days");

            if (item instanceof ReservableItem) {
                ReservableItem reservable = (ReservableItem) item;
                reservable.reserveItem();
                System.out.println("Available     : " + reservable.checkAvailability());
            }

            System.out.println("----------------------------------");
        }
    }
}

//Interface
interface ReservableItem {
    void reserveItem();
    boolean checkAvailability();
}

//Abstract class
abstract class BaseLibraryItem {
    private String itemId;
    private String title;
    private String author;
    //Encapsulation
    private String borrowerName;
    protected BaseLibraryItem(String itemId, String title, String author) {
        setItemId(itemId);
        setTitle(title);
        setAuthor(author);
    }

    // Abstract method
    public abstract int getLoanDuration();

    // Concrete method
    public String getItemDetails() {
        return "Item ID : " + itemId +
               ", Title : " + title +
               ", Author: " + author;
    }

    // Encapsulation
    public String getItemId() {
        return itemId;
    }

    private void setItemId(String itemId) {
        if (itemId == null || itemId.isEmpty()) {
            throw new IllegalArgumentException("Item ID cannot be empty.");
        }
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    private void setAuthor(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty.");
        }
        this.author = author;
    }

    // Borrower data is secured
    protected void assignBorrower(String borrowerName) {
        this.borrowerName = borrowerName;
    }
}

//Book class
class LibraryBook extends BaseLibraryItem implements ReservableItem {

    private boolean available = true;

    public LibraryBook(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 2 weeks
    }

    @Override
    public void reserveItem() {
        if (available) {
            assignBorrower("Reserved User");
            available = false;
        }
    }

    @Override
    public boolean checkAvailability() {
        return available;
    }
}

//Magazine class
class LibraryMagazine extends BaseLibraryItem implements ReservableItem {

    private boolean available = true;

    public LibraryMagazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7;
    }

    @Override
    public void reserveItem() {
        if (available) {
            assignBorrower("Reserved User");
            available = false;
        }
    }

    @Override
    public boolean checkAvailability() {
        return available;
    }
}

//DVD class
class LibraryDVD extends BaseLibraryItem implements ReservableItem {

    private boolean available = true;

    public LibraryDVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // 3 days
    }

    @Override
    public void reserveItem() {
        if (available) {
            assignBorrower("Reserved User");
            available = false;
        }
    }

    @Override
    public boolean checkAvailability() {
        return available;
    }
}
