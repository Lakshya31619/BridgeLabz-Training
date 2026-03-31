public interface PaymentProcessor {
    void pay(double amount);
    default boolean refund(double amount) {
        System.out.println("Default refund processed for amount ₹" + amount);
        return true;
    }
}