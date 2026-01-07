public class BankServiceImpl implements BankService {
    private Account[] accounts = new Account[10];
    private Transaction[] transactions = new Transaction[50];
    private int accCount = 0;
    private int txnCount = 0;
    @Override
    public Account createAccount(String type, String name, double initialAmount) {
        Account acc;
        if (type.equalsIgnoreCase("savings")) {
            acc = new SavingsAccount(accCount + 1, name, initialAmount, 5);
        } else {
            acc = new CurrentAccount(accCount + 1, name, initialAmount, 1000);
        }
        accounts[accCount++] = acc;
        return acc;
    }
    @Override
    public synchronized void transferFunds(Account from, Account to, double amount)throws InsufficientBalanceException {
        from.withdraw(amount);
        to.deposit(amount);
        transactions[txnCount++] = new Transaction(from.getAccountNumber(), to.getAccountNumber(), amount);
        System.out.println("Transfer Successful: " + amount);
    }
    @Override
    public void printTransactionHistory() {
        System.out.println("\nTransaction History:");
        for (int i = 0; i < txnCount; i++) {
            System.out.println(transactions[i]);
        }
    }
}