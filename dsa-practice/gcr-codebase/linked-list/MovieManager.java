class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next;
    MovieNode prev;
    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}
public class MovieManager {
    private static MovieNode head = null;
    private static MovieNode tail = null;
    //Add at beginning
    public static void insertAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    //Add at end
    public static void insertAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    //Add at specific position
    public static void insertAtPosition(String title, String director, int year, double rating, int position) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            insertAtBeginning(title, director, year, rating);
            return;
        }
        MovieNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            insertAtEnd(title, director, year, rating);
            return;
        }
        MovieNode newNode = new MovieNode(title, director, year, rating);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }
    //Remove by title
    public static void deleteByTitle(String title) {
        if (head == null) {
            System.out.println("Movie list is empty!");
            return;
        }
        MovieNode temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Movie not found!");
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
    //Search by director
    public static void searchByDirector(String director) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("No movies found for director: " + director);
    }
    //Search by Rating
    public static void searchByRating(double rating) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("No movies found with rating: " + rating);
    }
    //Update rating by title
    public static void updateRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found!");
    }
    //Display movies in forward
    public static void displayForward() {
        if (head == null) {
            System.out.println("No movie records available.");
            return;
        }
        MovieNode temp = head;
        System.out.println("\nMovies (Forward Order):");
        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }
    //Display movies in reverse
    public static void displayReverse() {
        if (tail == null) {
            System.out.println("No movie records available.");
            return;
        }
        MovieNode temp = tail;
        System.out.println("\nMovies (Reverse Order):");
        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }
    //Display Linkedlist
    private static void displayMovie(MovieNode m) {
        System.out.println("Title: " + m.title + ", Director: " + m.director + ", Year: " + m.year + ", Rating: " + m.rating);
    }
    //Main method
    public static void main(String[] args) {
        insertAtBeginning("Dhurandhar", "Aditya Dhar", 2025, 9.1);
        insertAtEnd("Tees Maar Khan", "Farah Khan", 2012, 4.2);
        insertAtEnd("Bahubali : The Beginning", "S.S. Rajamouli", 2015, 8.5);
        insertAtPosition("Bahubali : The Conclusion", "S.S. Rajamouli", 2019, 8.4, 2);
        displayForward();
        displayReverse();
        System.out.println("\nSearch by Director: S.S. Rajamouli");
        searchByDirector("S.S. Rajamouli");
        System.out.println("\nSearch by Rating: 9.1");
        searchByRating(9.1);
        System.out.println("\nUpdating rating of Tees Maar Khan");
        updateRating("Tees Maar Khan", 4.5);
        System.out.println("\nDeleting Tees Maar Khan");
        deleteByTitle("Tees Maar Khan");
        displayForward();
    }
}