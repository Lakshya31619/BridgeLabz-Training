public class SavingsAccount extends Account {
    private double interestRate;
    public SavingsAccount(int accNo, String name, double balance, double interestRate) {
        super(accNo, name, balance);
        this.interestRate = interestRate;
    }
    @Override
    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(holderName + " withdrew " + amount);
        } else {
            throw new InsufficientBalanceException("Insufficient balance in Savings Account");
        }
    }
    public double calculateInterest() {
        return balance * interestRate / 100;
    }
}