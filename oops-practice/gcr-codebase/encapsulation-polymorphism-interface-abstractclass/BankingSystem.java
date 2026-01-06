import java.util.ArrayList;
import java.util.List;

//Main class
public class BankingSystem {

    public static void main(String[] args) {

        List<BaseBankAccount> accounts = new ArrayList<>();

        accounts.add(new SavingsAccountAcc("SB1001", "Shahrukh", 50000));
        accounts.add(new CurrentAccountAcc("CA1002", "Salman", 120000));

        // Polymorphic processing
        for (BaseBankAccount account : accounts) {

            account.deposit(5000);
            account.withdraw(3000);

            double interest = account.calculateInterest();

            System.out.println("Account Number : " + account.getAccountNumber());
            System.out.println("Holder Name    : " + account.getHolderName());
            System.out.println("Balance        : " + account.getBalance());
            System.out.println("Interest       : " + interest);

            if (account instanceof LoanableAcc) {
                LoanableAcc loanAccount = (LoanableAcc) account;
                System.out.println("Loan Eligible  : " +
                        loanAccount.calculateLoanEligibility());
            }

            System.out.println("----------------------------------");
        }
    }
}

//Interface Loan
interface LoanableAcc {

    void applyForLoan();

    double calculateLoanEligibility();
}

//Abstract class
abstract class BaseBankAccount {

    private String accountNumber;
    private String holderName;
    private double balance;

    protected BaseBankAccount(String accountNumber, String holderName, double balance) {
        setAccountNumber(accountNumber);
        setHolderName(holderName);
        setBalance(balance);
    }

    // Concrete methods
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            throw new IllegalArgumentException("Invalid withdrawal amount.");
        }
        balance -= amount;
    }

    // Abstract method
    public abstract double calculateInterest();

    // Encapsulation 
    public String getAccountNumber() {
        return accountNumber;
    }

    private void setAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be empty.");
        }
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    private void setHolderName(String holderName) {
        if (holderName == null || holderName.isEmpty()) {
            throw new IllegalArgumentException("Holder name cannot be empty.");
        }
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.balance = balance;
    }
}

//SavingAccountAcc Class
class SavingsAccountAcc extends BaseBankAccount implements LoanableAcc {

    public SavingsAccountAcc(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.04; // 4% interest
    }

    @Override
    public void applyForLoan() {
        System.out.println("Savings account loan applied.");
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 2; 
    }
}

//CurrentAccountAcc class
class CurrentAccountAcc extends BaseBankAccount implements LoanableAcc {
    public CurrentAccountAcc(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.02;  
    }

    @Override
    public void applyForLoan() {
        System.out.println("Current account loan applied.");
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 3;
    }
}
