public class BookShelfMain {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook("Adventure", new Book("1", "Jungle Book", "Ruyald Kipling"));
        library.addBook("Fiction", new Book("2", "Harry Potter", "J.K.Rowling"));
        library.addBook("Drama", new Book("3", "Story of My Life", "Hellen Keller"));
        library.displayLibrary();
        library.borrowBook("Fiction", "2");
        library.displayLibrary();
    }
}