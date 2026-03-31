public class Order {
    private int orderId;
    private String customerName;
    private String deliveryLocation;
    public Order(int orderId, String customerName, String deliveryLocation) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.deliveryLocation = deliveryLocation;
    }
    public int getOrderId() {
        return orderId;
    }
    public String getDeliveryLocation() {
        return deliveryLocation;
    }
    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customerName + ", Location: " + deliveryLocation;
    }
}