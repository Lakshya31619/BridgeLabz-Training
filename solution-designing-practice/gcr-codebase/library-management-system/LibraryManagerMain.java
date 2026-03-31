public class LibraryManagerMain {
    public static void main(String[] args) {
        LibraryCatalog catalog = LibraryCatalog.getInstance();
        User student = UserFactory.createUser("student", "Arjun");
        User faculty = UserFactory.createUser("faculty", "Dr. Tendulkar");
        student.showRole();
        faculty.showRole();
        catalog.addObserver(student);
        catalog.addObserver(faculty);
        Book book = new Book.BookBuilder("Design Patterns")
                .author("GoF")
                .edition("2nd")
                .genre("Software Engineering")
                .build();
        catalog.addBook(book);
        System.out.println("Arjun can borrow for " + student.getBorrowDuration() + " days");
        System.out.println("Dr. Tendulkar can borrow for " + faculty.getBorrowDuration() + " days");
    }
}