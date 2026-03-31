import java.util.HashMap;
import java.util.Map;
public class AccountStore {
    private Map<Integer, Double> accounts = new HashMap<>();
    public void addAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
    }
    public Map<Integer, Double> getAccounts() {
        return accounts;
    }
    public void updateBalance(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
    }
}