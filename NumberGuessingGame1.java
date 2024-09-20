import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rounds = 0;
        int win = 0;

        do {
            rounds++;
            int randomNumber = random.nextInt(100) + 1; // Generate random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 10; // Limit the number of attempts

            System.out.println("Round " + rounds + ": Guess the number between 1 and 100. You have " + maxAttempts + " attempts.");

            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < randomNumber) {
                    System.out.println("Too low!");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high!");
                } else {
                    guessedCorrectly = true;
                    System.out.println("Correct! You've guessed the number in " + attempts + " attempts.");
                    win++;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all your attempts. The number was: " + randomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing! You won " + win + " out of " + rounds + " rounds.");
        scanner.close();
    }
}
