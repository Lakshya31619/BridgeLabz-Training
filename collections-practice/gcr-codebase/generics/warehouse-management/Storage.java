import java.util.ArrayList;
import java.util.List;
public class Storage<T extends WarehouseItem> {
    private final List<T> items = new ArrayList<>();
    // Write operation — type safe
    public void addItem(T item) {
        items.add(item);
    }
    // Read-only access
    public List<T> getItems() {
        return items;
    }
}