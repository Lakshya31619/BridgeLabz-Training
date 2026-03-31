public class Order {
    private int orderId;
    private Product product;
    private Customer customer;
    private String status;
    public Order(int orderId, Product product, Customer customer){
        this.orderId = orderId;
        this.product = product;
        this.customer = customer;
        this.status = "PLACED";
    }
    public void makePayment(Payment payment){
        try{
            payment.pay(product.getPrice());
            status = "PAID";
            System.out.println("Order Payment Successful");
        }catch(PaymentFailedException e){
            status = "PAYMENT FAILED";
            System.out.println("Payment Failed : "+e.getMessage());
        }
    }
    public void cancelOrder(){
        if(status.equals("PAID") || status.equals("PLACED")){
            status = "CANCELLED";
            System.out.println("Order cancelled successfully");
        }else{
            System.out.println("Order cannot be cancelled");
        }
    }
    public void trackOrder(){
        System.out.println("Order status : "+status);
    }
}