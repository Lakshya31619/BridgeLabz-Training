public class BankAccount {
    // Access modifiers
    public int accountNumber;     
    protected String accountHolder;     
    private double balance;        
    // Constructor
    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    // Public methods to access and modify balance
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        }
    }
    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount(1001, "Indrajeet", 5000);
        b1.displayAccountDetails();
        System.out.println();
        b1.setBalance(7500);
        System.out.println("Updated Balance: " + b1.getBalance());
        System.out.println();

        SavingsAccount s1 = new SavingsAccount(2002, "Pritish", 10000);
        s1.displaySavingsAccountDetails();
    }
}
// Subclass SavingsAccount
class SavingsAccount extends BankAccount {
    // Constructor
    public SavingsAccount(int accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }
    // Method demonstrating access to public and protected members
    public void displaySavingsAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + getBalance());
    }
}