public class PaymentGatewayIntegrationMain {
    public static void main(String[] args) {
        PaymentProcessor upi = new UPIPaymentProcessor();
        PaymentProcessor card = new CreditCardPaymentProcessor();
        upi.pay(1000);
        upi.refund(200);
        System.out.println();
        card.pay(1500);
        card.refund(300);
    }
}