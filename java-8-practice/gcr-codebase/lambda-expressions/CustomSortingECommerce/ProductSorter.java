package CustomSortingECommerce;
import java.util.Comparator;
public class ProductSorter {
    public static Comparator<Product> sortByPrice() {
        return (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice());
    }
    public static Comparator<Product> sortByRating() {
        return (p1, p2) -> Double.compare(p2.getRating(), p1.getRating());
    }
    public static Comparator<Product> sortByDiscount() {
        return (p1, p2) -> Double.compare(p2.getDiscount(), p1.getDiscount());
    }
}