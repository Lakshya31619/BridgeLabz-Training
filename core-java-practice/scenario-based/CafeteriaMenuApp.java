import java.util.Scanner;
public class CafeteriaMenuApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Fixed cafeteria menu (10 items)
        String[] menuItems = {
            "Burger", "Pizza", "Pasta", "Sandwich", "Salad",
            "Fried Rice", "Noodles", "Chicken Wrap", "Fries", "Juice"
        };
        // Display menu
        displayMenu(menuItems);
        // User selects an item
        System.out.print("\nEnter the item number you want to order: ");
        int index = sc.nextInt();
        // Get selected item
        String orderedItem = getItemByIndex(menuItems, index);
        // Display result
        if (orderedItem != null) {
            System.out.println("You ordered: " + orderedItem);
        } else {
            System.out.println("Invalid choice. Please select a valid item number.");
        }
    }
    // Method to display menu items
    public static void displayMenu(String[] items) {
        System.out.println("===== Cafeteria Menu =====");
        for (int i = 0; i < items.length; i++) {
            System.out.println(i + ": " + items[i]);
        }
    }
    // Method to return item based on index
    public static String getItemByIndex(String[] items, int index) {
        if (index >= 0 && index < items.length) {
            return items[index];
        }
        return null;
    }
}