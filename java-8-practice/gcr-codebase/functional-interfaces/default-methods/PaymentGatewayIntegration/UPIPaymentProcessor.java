public class UPIPaymentProcessor implements PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}