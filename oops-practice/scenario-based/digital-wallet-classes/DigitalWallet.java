public class DigitalWallet {
    public static void main(String[] args) {
        Users u1 = new Users(1, "Ajay");
        Users u2 = new Users(2, "Tabbu");
        u1.getWallet().addMoney(5000);
        TransferService transfer = new WalletTransfer();
        try {
            transfer.transfer(u1, u2, 1500);
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Balance of " + u1.getName() + ": ₹" + u1.getWallet().getBalance());
        System.out.println("Balance of " + u2.getName() + ": ₹" + u2.getWallet().getBalance());
        u1.getWallet().showTransactions();
        u2.getWallet().showTransactions();
    }
}