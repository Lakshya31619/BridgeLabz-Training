public abstract class WarehouseItem {
    private final String name;
    public WarehouseItem(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract String getCategory();
}