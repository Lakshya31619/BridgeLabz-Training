import java.util.LinkedList;
import java.util.Queue;
public class WithdrawalProcessor {
    private Queue<WithdrawalRequest> queue = new LinkedList<>();
    private AccountStore store;
    public WithdrawalProcessor(AccountStore store) {
        this.store = store;
    }
    public void addRequest(WithdrawalRequest request) {
        queue.offer(request);
    }
    public void processRequests() {
        while (!queue.isEmpty()) {
            WithdrawalRequest r = queue.poll();
            double balance = store.getAccounts().get(r.accountNumber);
            if (balance >= r.amount) {
                store.updateBalance(r.accountNumber, balance - r.amount);
            }
        }
    }
}