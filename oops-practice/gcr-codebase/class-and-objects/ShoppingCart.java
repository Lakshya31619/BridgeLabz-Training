public class ShoppingCart {
    // CartItem Class
    static class CartItem {
        // Attributes
        private String itemName;
        private double price;
        private int quantity;
        // Constructor
        public CartItem(String itemName, double price, int quantity) {
            this.itemName = itemName;
            this.price = price;
            this.quantity = quantity;
        }
        // Method to display item details
        public void displayItem() {
            System.out.println("Item: " + itemName +", Price: $" + price +", Quantity: " + quantity);
        }
        // Method to add items to the cart
        public void addItem(int qty) {
            quantity += qty;
            System.out.println("Added " + qty + " of " + itemName + " to the cart.");
        }
        // Method to remove items from the cart
        public void removeItem(int qty) {
            if (quantity >= qty) {
                quantity -= qty;
                System.out.println("Removed " + qty + " of " + itemName + " from the cart.");
            } else {
                System.out.println("Cannot remove more items than available.");
            }
        }
        // Method to calculate and display total cost
        public void displayTotalCost() {
            double totalCost = price * quantity;
            System.out.printf("Total cost: $%.2f\n", totalCost);
        }
    }
    public static void main(String[] args) {
        // Create CartItem object
        CartItem item = new CartItem("Laptop", 999.99, 1);
        // Display item
        item.displayItem();
        // Add items
        item.addItem(2);
        // Remove item
        item.removeItem(1);
        // Display total cost
        item.displayTotalCost();
    }
}