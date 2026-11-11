import java.util.List;
import java.util.Scanner;

public class ATM {
    private final Bank bank;
    private final Scanner sc = new Scanner(System.in);

    public ATM(Bank bank) { this.bank = bank; }

    public void start() {
        System.out.println("===== WELCOME TO THE ATM =====");
        Account acc = login();
        if (acc == null) {
            System.out.println("Too many incorrect attempts. Access denied.");
            return;
        }
        System.out.println("Login successful. Hello, " + acc.getUserId() + "!");
        menu(acc);
    }

    private Account login() {
        for (int i = 1; i <= 3; i++) {
            System.out.print("User ID: ");
            String id = sc.nextLine().trim();
            System.out.print("PIN: ");
            String pin = sc.nextLine().trim();
            Account a = bank.authenticate(id, pin);
            if (a != null) return a;
            System.out.println("Invalid User ID or PIN. Attempts left: " + (3 - i));
        }
        return null;
    }

    private void menu(Account acc) {
        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            String c = sc.nextLine().trim();
            switch (c) {
                case "1": showHistory(acc); break;
                case "2": withdraw(acc); break;
                case "3": deposit(acc); break;
                case "4": transfer(acc); break;
                case "5":
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default: System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void showHistory(Account acc) {
        List<Transaction> h = acc.getHistory();
        System.out.println("\n--- TRANSACTION HISTORY ---");
        if (h.isEmpty()) System.out.println("No transactions in this session.");
        for (Transaction t : h) System.out.println(t);
        System.out.printf("Current balance: %.2f%n", acc.getBalance());
    }

    private void withdraw(Account acc) {
        double amt = readAmount("Enter amount to withdraw: ");
        if (acc.withdraw(amt)) System.out.printf("Withdrawn %.2f. New balance: %.2f%n", amt, acc.getBalance());
        else System.out.println("Insufficient Funds");
    }

    private void deposit(Account acc) {
        double amt = readAmount("Enter amount to deposit: ");
        acc.deposit(amt);
        System.out.printf("Deposited %.2f. New balance: %.2f%n", amt, acc.getBalance());
    }

    private void transfer(Account acc) {
        System.out.print("Recipient account ID: ");
        String id = sc.nextLine().trim();
        Account to = bank.find(id);
        if (to == null || to == acc) {
            System.out.println("Invalid recipient account.");
            return;
        }
        double amt = readAmount("Enter amount to transfer: ");
        if (acc.transferTo(to, amt)) System.out.printf("Transferred %.2f to %s. New balance: %.2f%n", amt, id, acc.getBalance());
        else System.out.println("Insufficient Funds");
    }

    private double readAmount(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double v = Double.parseDouble(sc.nextLine().trim());
                if (v > 0) return v;
                System.out.println("Amount must be greater than zero.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Enter a number.");
            }
        }
    }
}
