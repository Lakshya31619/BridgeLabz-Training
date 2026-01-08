class ItemNode {
    int itemId;
    String itemName;
    int quantity;
    double price;
    ItemNode next;
    ItemNode(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}
public class InventoryManager {
    private static ItemNode head = null;
    //Add at beginning
    public static void insertAtBeginning(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = head;
        head = newNode;
    }
    //Add at last
    public static void insertAtEnd(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);
        if (head == null) {
            head = newNode;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }
    //Add at specific position
    public static void insertAtPosition(int id, String name, int qty, double price, int position) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            insertAtBeginning(id, name, qty, price);
            return;
        }
        ItemNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++)
            temp = temp.next;
        if (temp == null) {
            System.out.println("Position out of range!");
            return;
        }
        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = temp.next;
        temp.next = newNode;
    }
    //Remove item by ID
    public static void deleteById(int id) {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }
        if (head.itemId == id) {
            head = head.next;
            return;
        }
        ItemNode current = head;
        while (current.next != null && current.next.itemId != id)
            current = current.next;
        if (current.next == null) {
            System.out.println("Item not found!");
        } else {
            current.next = current.next.next;
        }
    }
    //Update Quantity
    public static void updateQuantity(int id, int newQty) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found!");
    }
    //Search by ID
    public static void searchById(int id) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found!");
    }
    //Search by name
    public static void searchByName(String name) {
        ItemNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found){
            System.out.println("Item not found!");
        }
    }
    //Total inventory value
    public static void calculateTotalValue() {
        double total = 0.0;
        ItemNode temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("\nTotal Inventory Value: " + total);
    }
    //Sort by item name
    public static void sortByName(boolean ascending) {
        if (head == null) return;
        for (ItemNode i = head; i.next != null; i = i.next) {
            for (ItemNode j = i.next; j != null; j = j.next) {
                if ((ascending && i.itemName.compareToIgnoreCase(j.itemName) > 0) ||
                    (!ascending && i.itemName.compareToIgnoreCase(j.itemName) < 0)) {
                    swapData(i, j);
                }
            }
        }
    }
    //Sort by price
    public static void sortByPrice(boolean ascending) {
        if (head == null) return;
        for (ItemNode i = head; i.next != null; i = i.next) {
            for (ItemNode j = i.next; j != null; j = j.next) {
                if ((ascending && i.price > j.price) ||
                    (!ascending && i.price < j.price)) {
                    swapData(i, j);
                }
            }
        }
    }
    //Swap node data
    private static void swapData(ItemNode a, ItemNode b) {
        int tempId = a.itemId;
        String tempName = a.itemName;
        int tempQty = a.quantity;
        double tempPrice = a.price;
        a.itemId = b.itemId;
        a.itemName = b.itemName;
        a.quantity = b.quantity;
        a.price = b.price;
        b.itemId = tempId;
        b.itemName = tempName;
        b.quantity = tempQty;
        b.price = tempPrice;
    }
    //Inventory Display
    public static void displayInventory() {
        if (head == null) {
            System.out.println("No items in inventory.");
            return;
        }
        ItemNode temp = head;
        System.out.println("\nInventory Items:");
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }
    //Display
    private static void displayItem(ItemNode i) {
        System.out.println("ID: " + i.itemId + ", Name: " + i.itemName + ", Quantity: " + i.quantity + ", Price: " + i.price);
    }
    //Main class
    public static void main(String[] args) {
        insertAtBeginning(101, "Laptop", 5, 50000);
        insertAtEnd(102, "Mouse", 20, 500);
        insertAtEnd(103, "Keyboard", 10, 1500);
        insertAtPosition(104, "CPU", 7, 12000, 2);
        displayInventory();
        System.out.println("\nSearch by ID 102:");
        searchById(102);
        System.out.println("\nSearch by Name 'Mouse':");
        searchByName("Mouse");
        System.out.println("\nUpdating quantity of Keyboard:");
        updateQuantity(103, 15);
        calculateTotalValue();
        System.out.println("\nSort by Name (Ascending):");
        sortByName(true);
        displayInventory();
        System.out.println("\nSort by Price (Descending):");
        sortByPrice(false);
        displayInventory();
        System.out.println("\nDeleting item ID 101:");
        deleteById(101);
        displayInventory();
    }
}