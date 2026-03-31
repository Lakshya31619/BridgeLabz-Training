public abstract class Account {
    protected int accountNumber;
    protected String holderName;
    protected double balance;
    public Account(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public synchronized double getBalance() {
        return balance;
    }
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(holderName + " deposited " + amount);
    }
    public abstract void withdraw(double amount) throws InsufficientBalanceException;
}