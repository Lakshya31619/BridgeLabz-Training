public class UpiPayment {
    public void pay(double amount) throws PaymentFailedException{
        if(amount <= 0){
            throw new PaymentFailedException("Invalid UPI amount");
        }
        System.out.println("Paid Rs."+amount+" using UPI");
    }
}