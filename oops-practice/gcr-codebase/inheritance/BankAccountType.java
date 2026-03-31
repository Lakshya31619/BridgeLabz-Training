// Superclass
class BankAccount {
    protected String accountNumber;
    protected double balance;
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}
// Subclass SavingsAccount
class SavingsAccount extends BankAccount {
    private double interestRate;
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
// Subclass CheckingAccount
class CheckingAccount extends BankAccount {
    private double withdrawalLimit;
    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        System.out.println("Withdrawal Limit: " + withdrawalLimit);
    }
}
// Subclass FixedDepositAccount
class FixedDepositAccount extends BankAccount {
    private int tenureMonths;
    public FixedDepositAccount(String accountNumber, double balance, int tenureMonths) {
        super(accountNumber, balance);
        this.tenureMonths = tenureMonths;
    }
    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Tenure: " + tenureMonths + " months");
    }
}
public class BankAccountType {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("2215000282", 100, 0.5);
        BankAccount checking = new CheckingAccount("2215000586", 10000, 100);
        BankAccount fixedDeposit = new FixedDepositAccount("2215000666", 20000, 24);
        ((SavingsAccount) savings).displayAccountType();
        System.out.println();
        ((CheckingAccount) checking).displayAccountType();
        System.out.println();
        ((FixedDepositAccount) fixedDeposit).displayAccountType();
    }
}