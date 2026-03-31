// Base class
class Order {
    protected int orderId;
    protected String orderDate;
    public Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    public String getOrderStatus() {
        return "Order Placed";
    }
}
// Subclass
class ShippedOrder extends Order {
    protected String trackingNumber;
    public ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }
    @Override
    public String getOrderStatus() {
        return "Order Shipped";
    }
}
// Subclass extending ShippedOrder
class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;
    public DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }
    @Override
    public String getOrderStatus() {
        return "Order Delivered";
    }
}
public class OnlineOrderManager {
    public static void main(String[] args) {
        Order order = new Order(1, "2026-01-01");
        Order shippedOrder = new ShippedOrder(12, "2026-01-01", "TRK31006");
        Order deliveredOrder = new DeliveredOrder(103, "2026-01-01", "TRK61009", "2026-01-03");
        System.out.println(order.getOrderStatus());
        System.out.println(shippedOrder.getOrderStatus());
        System.out.println(deliveredOrder.getOrderStatus());
    }
}