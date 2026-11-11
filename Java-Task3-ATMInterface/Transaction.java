import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private final String type;
    private final double amount;
    private final String details;
    private final LocalDateTime time = LocalDateTime.now();

    public Transaction(String type, double amount, String details) {
        this.type = type;
        this.amount = amount;
        this.details = details;
    }

    @Override
    public String toString() {
        return String.format("[%s] %-9s %10.2f  %s",
                time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), type, amount, details);
    }
}
