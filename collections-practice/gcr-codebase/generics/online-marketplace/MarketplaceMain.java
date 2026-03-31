public class MarketplaceMain {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", BookCategory.EDUCATIONAL, 50.0);
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", ClothingCategory.MEN, 25.0);
        Product<GadgetCategory> phone = new Product<>("Smartphone", GadgetCategory.MOBILE, 800.0);
        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);
        PricingService.applyDiscount(book, 10);
        PricingService.applyDiscount(shirt, 20);
        PricingService.applyDiscount(phone, 5);
        catalog.displayCatalog();
    }
}