class BankAccount {
    private int balance = 10000;
    public int getBalance() {
        return balance;
    }
    public boolean withdraw(int amount) {
        if (balance >= amount) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            return true;
        }
        return false;
    }
}