public class Transactions {
    private String type;
    private double amount;
    public Transactions(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
    public void print() {
        System.out.println(type + " → ₹" + amount);
    }
}