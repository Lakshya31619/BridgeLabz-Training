public class BankTransfer implements TransferService {
    public void transfer(Users from, Users to, double amount) throws InsufficientBalanceException {
        double bankFee = 10;
        from.getWallet().withdrawMoney(amount + bankFee);
        to.getWallet().addMoney(amount);
        System.out.println("Bank transfer of ₹" + amount + " (Fee ₹10) from " + from.getName() + " to " + to.getName());
    }
}
