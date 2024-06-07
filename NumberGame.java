import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound);

        while (true) {
            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;

            System.out.println("Round " + (rounds + 1));
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("yes")) {
                System.out.println("Game over. Your total score is " + score + " points.");
                break;
            }

            rounds++;
        }

        scanner.close();
    }
}
