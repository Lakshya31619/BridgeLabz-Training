import java.time.LocalDateTime;
public class Transaction {
    private int fromAcc;
    private int toAcc;
    private double amount;
    private LocalDateTime time;
    public Transaction(int fromAcc, int toAcc, double amount) {
        this.fromAcc = fromAcc;
        this.toAcc = toAcc;
        this.amount = amount;
        this.time = LocalDateTime.now();
    }
    @Override
    public String toString() {
        return "From: " + fromAcc + " To: " + toAcc + " Amount: " + amount + " Time: " + time;
    }
}