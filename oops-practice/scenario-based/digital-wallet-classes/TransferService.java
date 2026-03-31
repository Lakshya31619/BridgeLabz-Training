public interface TransferService {
    void transfer(Users from, Users to, double amount) throws InsufficientBalanceException;
}