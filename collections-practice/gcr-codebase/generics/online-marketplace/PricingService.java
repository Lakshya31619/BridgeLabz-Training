public class PricingService {
    // Generic method with bounded type parameter
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Invalid discount percentage");
        }
        double discount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discount);
    }
}