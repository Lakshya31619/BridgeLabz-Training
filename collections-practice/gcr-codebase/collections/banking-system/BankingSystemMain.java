public class BankingSystemMain {
    public static void main(String[] args) {
        AccountStore store = new AccountStore();
        store.addAccount(101, 5000);
        store.addAccount(102, 3000);
        store.addAccount(103, 7000);
        WithdrawalProcessor processor = new WithdrawalProcessor(store);
        processor.addRequest(new WithdrawalRequest(101, 1000));
        processor.addRequest(new WithdrawalRequest(102, 500));
        processor.addRequest(new WithdrawalRequest(103, 2000));
        processor.processRequests();
        BalanceSortedView view = new BalanceSortedView();
        view.displaySorted(store.getAccounts());
    }
}