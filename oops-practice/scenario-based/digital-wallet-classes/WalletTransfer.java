public class WalletTransfer implements TransferService {
    public void transfer(Users from, Users to, double amount) throws InsufficientBalanceException {
        from.getWallet().withdrawMoney(amount);
        to.getWallet().addMoney(amount);
        System.out.println("Wallet transfer of ₹" + amount + " from " + from.getName() + " to " + to.getName());
    }
}