public class DigitalPaymentMain {
    public static void main(String[] args) {
        PaymentMethod[] payments = {
                new UPIPayment(),
                new CreditCardPayment(),
                new WalletPayment()
        };
        double amount = 1500.00;
        for (PaymentMethod payment : payments) {
            payment.pay(amount);
        }
    }
}