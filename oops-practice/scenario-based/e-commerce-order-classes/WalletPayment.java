public class WalletPayment {
    private double walletBalance = 2000.0;
    public void pay(double amount) throws PaymentFailedException{
        if(amount > walletBalance){
            throw new PaymentFailedException("Insufficient wallet balance");
        }
        walletBalance -= amount;
        System.out.println("Paid Rs."+amount+" using wallet");
    }
}