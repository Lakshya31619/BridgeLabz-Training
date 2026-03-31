public class OnlineBankingSystem {
    public static void main(String[] args) {
        BankService bank = new BankServiceImpl();
        Account acc1 = bank.createAccount("savings", "Baman", 5000);
        Account acc2 = bank.createAccount("current", "Ramam", 3000);
        Runnable task1 = () -> {
            try {
                bank.transferFunds(acc1, acc2, 1000);
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            }
        };
        Runnable task2 = () -> {
            try {
                bank.transferFunds(acc2, acc1, 500);
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            }
        };
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nFinal Balances:");
        System.out.println("Acc1: " + acc1.getBalance());
        System.out.println("Acc2: " + acc2.getBalance());
        bank.printTransactionHistory();
    }
}