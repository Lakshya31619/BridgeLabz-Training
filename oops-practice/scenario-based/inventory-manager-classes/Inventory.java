public class Inventory {
    private Product[] products;
    private int count;
    private static final int MAX_PRODUCTS = 5;
    private static final int LOW_STOCK_LIMIT = 5;
    private AlertService alertService;
    public Inventory(AlertService alertService) {
        products = new Product[MAX_PRODUCTS];
        count = 0;
        this.alertService = alertService;
    }
    public void addProduct(Product product) {
        if (count < MAX_PRODUCTS) {
            products[count++] = product;
            System.out.println("Product added: " + product.getName());
        }
    }
    public void updateStock(int productId, int newQuantity) throws OutOfStockException {
        for (int i = 0; i < count; i++) {
            if (products[i].getProductId() == productId) {
                if (newQuantity <= 0) {
                    throw new OutOfStockException(
                            products[i].getName() + " is out of stock!"
                    );
                }
                products[i].setQuantity(newQuantity);
                System.out.println("Stock updated for " + products[i].getName() + ": " + newQuantity);
                if (newQuantity <= LOW_STOCK_LIMIT) {
                    alertService.sendLowStockAlert(products[i]);
                }
                return;
            }
        }
    }
    public void viewInventory() {
        System.out.println("\nCurrent Inventory:");
        for (int i = 0; i < count; i++) {
            System.out.println(products[i].getName() + " → Qty: " + products[i].getQuantity());
        }
    }
}