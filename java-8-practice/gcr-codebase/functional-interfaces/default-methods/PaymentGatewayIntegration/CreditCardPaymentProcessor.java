public class CreditCardPaymentProcessor implements PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }
    @Override
    public boolean refund(double amount) {
        System.out.println("Credit Card refund processed for ₹" + amount);
        return true;
    }
}