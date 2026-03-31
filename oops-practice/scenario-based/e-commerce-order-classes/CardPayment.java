class CardPayment implements Payment{
    public void pay(double amount) throws PaymentFailedException {
        if(amount > 5000){
            throw new PaymentFailedException("Card limit exceeded");
        }
        System.out.println("Paid Rs."+amount+" using card");
    }
}