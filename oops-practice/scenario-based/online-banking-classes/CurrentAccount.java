public class CurrentAccount extends Account {
    private double overdraftLimit;
    public CurrentAccount(int accNo, String name, double balance, double overdraftLimit) {
        super(accNo, name, balance);
        this.overdraftLimit = overdraftLimit;
    }
    @Override
    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println(holderName + " withdrew " + amount);
        } else {
            throw new InsufficientBalanceException("Overdraft limit exceeded");
        }
    }
}