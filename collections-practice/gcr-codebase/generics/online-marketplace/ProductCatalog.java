import java.util.ArrayList;
import java.util.List;
public class ProductCatalog {
    private final List<Product<? extends ProductCategory>> products = new ArrayList<>();
    public void addProduct(Product<? extends ProductCategory> product) {
        products.add(product);
    }
    public void displayCatalog() {
        for (Product<? extends ProductCategory> product : products) {
            System.out.println("Product: " + product.getName() + " | Category: " + product.getCategory().getName() + " | Price: $" + product.getPrice());
        }
    }
}