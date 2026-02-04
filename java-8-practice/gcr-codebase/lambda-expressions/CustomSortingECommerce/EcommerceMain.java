package CustomSortingECommerce;
import java.util.*;
public class EcommerceMain {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1200, 4.5, 10));
        products.add(new Product("Headphones", 150, 4.8, 30));
        products.add(new Product("Smartphone", 800, 4.6, 15));
        products.add(new Product("Mouse", 40, 4.2, 20));
        products.sort(ProductSorter.sortByPrice());
        System.out.println("Sorted by Price:");
        products.forEach(System.out::println);
        products.sort(ProductSorter.sortByRating());
        System.out.println("\nSorted by Rating:");
        products.forEach(System.out::println);
        products.sort(ProductSorter.sortByDiscount());
        System.out.println("\nSorted by Discount:");
        products.forEach(System.out::println);
    }
}