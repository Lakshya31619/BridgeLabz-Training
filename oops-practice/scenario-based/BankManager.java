class BankAccount {
    // Fields
    private String accountNumber;
    private double balance;
    // Constructor
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Amount deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    // Method to withdraw money (with overdraft protection)
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Amount withdrawn: " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Overdraft not allowed.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
    // Method to check balance
    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}
public class BankManager {
    public static void main(String[] args) {
        // Creating a bank account object
        BankAccount account = new BankAccount("AEW316009", 4000.0);
        account.checkBalance();
        account.deposit(1500.0);
        account.withdraw(2000.0);
        account.withdraw(6000.0); //overdraft
        account.checkBalance();
    }
}