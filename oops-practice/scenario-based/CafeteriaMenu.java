import java.util.Scanner;
class Menu {
    private String[] items;
    // Constructor to initialize menu items
    public Menu(String[] items) {
        this.items = items;
    }
    // Display the menu
    public void displayMenu() {
        System.out.println("===== Cafeteria Menu =====");
        for (int i = 0; i < items.length; i++) {
            System.out.println(i + ": " + items[i]);
        }
    }
    // Get item by index
    public String getItemByIndex(int index) {
        if (index >= 0 && index < items.length) {
            return items[index];
        }
        return null;
    }
}
public class CafeteriaMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] menuItems = {"Burger", "Pizza", "Pasta", "Sandwich", "Salad","Fried Rice", "Noodles", "Chicken Wrap", "Fries", "Juice"};
        // Create Menu object
        Menu menu = new Menu(menuItems);
        menu.displayMenu();
        System.out.print("\nEnter the item number you want to order: ");
        int index = sc.nextInt();
        String orderedItem = menu.getItemByIndex(index);
        // Display result
        if (orderedItem != null) {
            System.out.println("You ordered: " + orderedItem);
        } else {
            System.out.println("Invalid choice. Please select a valid item number.");
        }
    }
}