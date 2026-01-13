public class Wallet {
    private double balance;
    private Transactions[] transactions;
    private int transactionCount;
    public Wallet() {
        balance = 0;
        transactions = new Transactions[10];
        transactionCount = 0;
    }
    public void addMoney(double amount) {
        balance += amount;
        transactions[transactionCount++] = new Transactions("CREDIT", amount);
    }
    public void withdrawMoney(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Insufficient balance!"
            );
        }
        balance -= amount;
        transactions[transactionCount++] = new Transactions("DEBIT", amount);
    }
    public double getBalance() {
        return balance;
    }
    public void showTransactions() {
        System.out.println("Transaction History:");
        for (int i = 0; i < transactionCount; i++) {
            transactions[i].print();
        }
    }
}