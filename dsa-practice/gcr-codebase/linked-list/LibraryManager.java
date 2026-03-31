class BookNode {
    int bookId;
    String title;
    String author;
    String genre;
    boolean isAvailable;
    BookNode next;
    BookNode prev;
    BookNode(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}
public class LibraryManager {
    private static BookNode head = null;
    private static BookNode tail = null;
    //Add at start
    public static void insertAtBeginning(int id, String title, String author, String genre, boolean available) {
        BookNode newNode = new BookNode(id, title, author, genre, available);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    //Add book at last
    public static void insertAtEnd(int id, String title, String author, String genre, boolean available) {
        BookNode newNode = new BookNode(id, title, author, genre, available);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    //Add at specific position
    public static void insertAtPosition(int id, String title, String author, String genre, boolean available, int position) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            insertAtBeginning(id, title, author, genre, available);
            return;
        }
        BookNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            insertAtEnd(id, title, author, genre, available);
            return;
        }
        BookNode newNode = new BookNode(id, title, author, genre, available);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }
    //Remove book by ID
    public static void deleteById(int id) {
        if (head == null) {
            System.out.println("Library is empty!");
            return;
        }
        BookNode temp = head;
        while (temp != null && temp.bookId != id) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Book not found!");
            return;
        }
        if (temp == head) {
            head = head.next;
            if (head != null){
                head.prev = null;
            }else{
                tail = null;
            }
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }
    //Search by Title
    public static void searchByTitle(String title) {
        BookNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found){
            System.out.println("Book not found with title: " + title);
        }
    }
    //Search by Author
    public static void searchByAuthor(String author) {
        BookNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found){
            System.out.println("No books found by author: " + author);
        }
    }
    //Update Availability
    public static void updateAvailability(int id, boolean available) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                temp.isAvailable = available;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found!");
    }
    //Display in forward
    public static void displayForward() {
        if (head == null) {
            System.out.println("No books available.");
            return;
        }
        BookNode temp = head;
        System.out.println("\nLibrary Books (Forward):");
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }
    //Display in reverse
    public static void displayReverse() {
        if (tail == null) {
            System.out.println("No books available.");
            return;
        }
        BookNode temp = tail;
        System.out.println("\nLibrary Books (Reverse):");
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }
    //Total Books count
    public static void countBooks() {
        int count = 0;
        BookNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("\nTotal Number of Books: " + count);
    }
    //Display
    private static void displayBook(BookNode b) {
        System.out.println("ID: " + b.bookId + ", Title: " + b.title + ", Author: " + b.author + ", Genre: " + b.genre + ", Available: " + (b.isAvailable ? "Yes" : "No"));
    }
    //Main class
    public static void main(String[] args) {
        insertAtBeginning(1, "1984", "George Orwell", "Dystopian", true);
        insertAtEnd(2, "The Hobbit", "J.R.R. Tolkien", "Fantasy", true);
        insertAtEnd(3, "The Alchemist", "Paulo Coelho", "Fiction", false);
        insertAtPosition(4, "Clean Code", "Robert C. Martin", "Programming", true, 2);
        displayForward();
        displayReverse();
        System.out.println("\nSearch by Title: The Hobbit");
        searchByTitle("The Hobbit");
        System.out.println("\nSearch by Author: George Orwell");
        searchByAuthor("George Orwell");
        System.out.println("\nUpdating availability of Book ID 3");
        updateAvailability(3, true);
        countBooks();
        System.out.println("\nDeleting Book ID 2");
        deleteById(2);
        displayForward();
        countBooks();
    }
}