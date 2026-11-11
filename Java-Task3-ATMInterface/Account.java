import java.util.ArrayList;
import java.util.List;

public class Account {
    private final String userId;
    private final String pin;
    private double balance;
    private final List<Transaction> history = new ArrayList<>();

    public Account(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
    }

    public String getUserId() { return userId; }
    public double getBalance() { return balance; }
    public List<Transaction> getHistory() { return history; }
    public boolean checkPin(String p) { return pin.equals(p); }

    public void deposit(double amt) {
        balance += amt;
        history.add(new Transaction("DEPOSIT", amt, "Cash deposit"));
    }

    public boolean withdraw(double amt) {
        if (amt > balance) return false;
        balance -= amt;
        history.add(new Transaction("WITHDRAW", amt, "Cash withdrawal"));
        return true;
    }

    public boolean transferTo(Account to, double amt) {
        if (amt > balance) return false;
        balance -= amt;
        to.balance += amt;
        history.add(new Transaction("TRANSFER", amt, "Sent to " + to.userId));
        to.history.add(new Transaction("RECEIVED", amt, "From " + userId));
        return true;
    }
}
