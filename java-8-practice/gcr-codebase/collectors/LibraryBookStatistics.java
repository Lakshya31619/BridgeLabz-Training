import java.util.*;
import java.util.stream.Collectors;
class Book {
    private String title;
    private String genre;
    private int pages;
    public Book(String title, String genre, int pages) {
        this.title = title;
        this.genre = genre;
        this.pages = pages;
    }
    public String getTitle() {
        return title;
    }
    public String getGenre() {
        return genre;
    }
    public int getPages() {
        return pages;
    }
}
public class LibraryBookStatistics {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("The White Tiger", "Fiction", 320),
                new Book("Wings of Fire", "Biography", 180),
                new Book("The Guide", "Fiction", 255),
                new Book("Ignited Minds", "Biography", 210),
                new Book("Clean Code", "Technology", 450)
        );
        Map<String, IntSummaryStatistics> statsByGenre =
                books.stream()
                        .collect(Collectors.groupingBy(
                                Book::getGenre,
                                Collectors.summarizingInt(Book::getPages)
                        ));
        statsByGenre.forEach((genre, stats) -> {
            System.out.println("Genre: " + genre);
            System.out.println("Total Pages: " + stats.getSum());
            System.out.println("Average Pages: " + stats.getAverage());
            System.out.println("Maximum Pages: " + stats.getMax());
            System.out.println();
        });
    }
}