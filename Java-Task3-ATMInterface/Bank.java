import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<String, Account> accounts = new HashMap<>();

    public Bank() {
        addAccount(new Account("user1", "1234", 5000));
        addAccount(new Account("user2", "4321", 3000));
        addAccount(new Account("user3", "1111", 10000));
    }

    public void addAccount(Account a) { accounts.put(a.getUserId(), a); }
    public Account find(String id) { return accounts.get(id); }

    public Account authenticate(String id, String pin) {
        Account a = accounts.get(id);
        return (a != null && a.checkPin(pin)) ? a : null;
    }
}
