public class InventoryApp {
    public static void main(String[] args) {
        AlertService alertService = new ConsoleAlertService();
        Inventory inventory = new Inventory(alertService);
        Product p1 = new Product(1, "UPS", 10);
        Product p2 = new Product(2, "Floppy", 3);
        inventory.addProduct(p1);
        inventory.addProduct(p2);
        try {
            inventory.updateStock(1, 4); 
            inventory.updateStock(2, 0);
        } catch (OutOfStockException e) {
            System.out.println("Error: " + e.getMessage());
        }
        inventory.viewInventory();
    }
}