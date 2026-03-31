import java.util.List;
public class WarehouseUtils {
    // Upper bounded wildcard for read-only access
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println("Item: " + item.getName() +" | Category: " + item.getCategory());
        }
    }
}