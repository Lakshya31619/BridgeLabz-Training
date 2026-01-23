public class ShoppingCartMain {
    public static void main(String[] args) {
        ProductStore store = new ProductStore();
        CartOrder order = new CartOrder();
        PriceSortedView sortedView = new PriceSortedView();
        store.addProduct("Apple", 30.0);
        store.addProduct("Banana", 10.0);
        store.addProduct("Milk", 50.0);
        order.addItem("Apple", store.getProducts().get("Apple"));
        order.addItem("Milk", store.getProducts().get("Milk"));
        order.addItem("Banana", store.getProducts().get("Banana"));
        order.display();
        sortedView.displaySorted(order.getCart());
    }
}