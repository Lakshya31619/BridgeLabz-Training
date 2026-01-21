public class WarehouseMain {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("IPad"));
        electronicsStorage.addItem(new Electronics("Smartwatch"));
        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Eggs"));
        groceriesStorage.addItem(new Groceries("Milk"));
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Ladder"));
        furnitureStorage.addItem(new Furniture("Table"));
        System.out.println("Electronics:");
        WarehouseUtils.displayItems(electronicsStorage.getItems());
        System.out.println("\nGroceries:");
        WarehouseUtils.displayItems(groceriesStorage.getItems());
        System.out.println("\nFurniture:");
        WarehouseUtils.displayItems(furnitureStorage.getItems());
    }
}