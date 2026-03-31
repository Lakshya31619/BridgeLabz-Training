public class ECommerce {
    public static void main(String[] args) {
        Product product = new Product(11, "Boat Earphones", 3000.0);
        Customer customer = new Customer(1, "Lakshya");
        Order order = new Order(1, product, customer);
        Payment payment = new CardPayment();
        order.makePayment(payment);
        order.trackOrder();
        order.cancelOrder();
        order.trackOrder();
    }
}