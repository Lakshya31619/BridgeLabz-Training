public interface BankService {
    Account createAccount(String type, String name, double initialAmount);
    void transferFunds(Account from, Account to, double amount) throws InsufficientBalanceException;
    void printTransactionHistory();
}