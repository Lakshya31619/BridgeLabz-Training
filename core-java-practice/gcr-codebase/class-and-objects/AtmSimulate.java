public class AtmSimulate {
    // BankAccount Class
    static class BankAccount {
        // Attributes
        private String accountHolder;
        private String accountNumber;
        private double balance;
        // Constructor
        public BankAccount(String accountHolder, String accountNumber, double balance) {
            this.accountHolder = accountHolder;
            this.accountNumber = accountNumber;
            this.balance = balance;
        }
        // Method to display current balance
        public void displayBalance() {
            System.out.println("Current balance: " + balance);
        }
        // Method to deposit money
        public void deposit(double amount) {
            balance += amount;
            System.out.println("Deposited: " + amount);
            displayBalance();
        }
        // Method to withdraw money
        public void withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdraw amount is : " + amount);
                displayBalance();
            } else {
                System.out.println("Insufficient balance");
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("State of Chennai\n");
        // Create BankAccount object
        BankAccount account = new BankAccount("Ravi", "ACC1001", 700.0);
        // Display balance
        account.displayBalance();
        account.deposit(200.0);
        account.withdraw(100.0);
        account.withdraw(1000.0);
    }
}