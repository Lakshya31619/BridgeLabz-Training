import java.time.LocalDateTime;
class Transaction implements Runnable {
    private BankAccount account;
    private String customerName;
    private int amount;
    public Transaction(BankAccount account, String customerName, int amount) {
        this.account = account;
        this.customerName = customerName;
        this.amount = amount;
    }
    @Override
    public void run() {
        System.out.println("[" + Thread.currentThread().getName() + "] State before: "+ Thread.currentThread().getState()
        );
        System.out.println("[" + Thread.currentThread().getName() + "] Attempting to withdraw " + amount);
        boolean success = account.withdraw(amount);
        if (success) {
            System.out.println("Transaction successful: " + customerName +", Amount: " + amount +", Balance: " + account.getBalance() +", Time: " + LocalDateTime.now());
        } else {
            System.out.println("Transaction failed: " + customerName +", Amount: " + amount +", Insufficient balance" +", Time: " + LocalDateTime.now());
        }
    }
}