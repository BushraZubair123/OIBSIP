import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/** OIBSIP Java Task 2 - Number Guessing Game (console). */
public class NumberGuessingGame {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Random rnd = new Random();
        List<String> summary = new ArrayList<>();
        int round = 0, wins = 0;
        boolean playAgain = true;

        System.out.println("=== NUMBER GUESSING GAME ===");
        while (playAgain) {
            round++;
            int[] cfg = chooseDifficulty(); // {max, maxAttempts}
            int max = cfg[0], maxAttempts = cfg[1];
            int secret = rnd.nextInt(max) + 1;
            int attempts = 0;
            boolean won = false;

            System.out.println("\n--- Round " + round + " --- Guess a number between 1 and "
                    + max + " (" + maxAttempts + " attempts)");
            while (attempts < maxAttempts) {
                int guess = readInt("Attempt " + (attempts + 1) + "/" + maxAttempts + " - Your guess: ", 1, max);
                attempts++;
                if (guess == secret) {
                    System.out.println("Correct!");
                    won = true;
                    break;
                } else if (guess > secret) {
                    System.out.println("Too High!");
                } else {
                    System.out.println("Too Low!");
                }
            }
            if (won) {
                wins++;
                summary.add("Round " + round + " - guessed in " + attempts + " attempts");
            } else {
                System.out.println("You Lost! The number was " + secret + ".");
                summary.add("Round " + round + " - lost (number was " + secret + ")");
            }
            System.out.print("\nPlay again? (yes/no): ");
            String ans = sc.nextLine().trim().toLowerCase();
            playAgain = ans.equals("yes") || ans.equals("y");
        }

        System.out.println("\n=== SCORE SUMMARY ===");
        for (String s : summary) System.out.println(s);
        System.out.println("Rounds won: " + wins + " / " + round);
        System.out.println("Thanks for playing!");
    }

    private static int[] chooseDifficulty() {
        System.out.println("\nChoose difficulty:");
        System.out.println("1. Easy   (1-50,  10 attempts)");
        System.out.println("2. Medium (1-100, 7 attempts)");
        System.out.println("3. Hard   (1-200, 5 attempts)");
        int c = readInt("Enter 1, 2 or 3: ", 1, 3);
        switch (c) {
            case 1:  return new int[]{50, 10};
            case 3:  return new int[]{200, 5};
            default: return new int[]{100, 7};
        }
    }

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            if (!sc.hasNextLine()) { System.out.println(); System.exit(0); }
            String line = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(line);
                if (v >= min && v <= max) return v;
                System.out.println("Please enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a whole number.");
            }
        }
    }
}
