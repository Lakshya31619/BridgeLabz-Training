public class InventoryProgram {
    // Item Class
    static class Item {
        // Attributes
        private String itemCode;
        private String itemName;
        private double itemPrice;
        // Constructor
        public Item(String itemCode, String itemName, double itemPrice) {
            this.itemCode = itemCode;
            this.itemName = itemName;
            this.itemPrice = itemPrice;
        }
        // Method to display item details
        public void displayItemDetails() {
            System.out.println("itemCode : " + itemCode);
            System.out.println("itemPrice : " + itemPrice);
            System.out.println("itemName : " + itemName);
            System.out.println("----------------------------");
        }
        // Method to calculate total cost for given quantity
        public double calculateTotalCost(int quantity) {
            return itemPrice * quantity;
        }
    }
    public static void main(String[] args) {
        // Create Item objects
        Item item1 = new Item("01AA", "Water bottle", 500.0);
        Item item2 = new Item("01BB", "Rice", 700.0);
        Item item3 = new Item("02AA", "blackboard", 400.0);
        // Display item details
        item1.displayItemDetails();
        item2.displayItemDetails();
        item3.displayItemDetails();
    }
}