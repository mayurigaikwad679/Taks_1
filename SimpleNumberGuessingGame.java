import java.util.*;

public class SimpleNumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 5; // Maximum number of attempts per round
        int totalRounds = 3; // Total number of rounds
        int roundsPlayed = 0; // Track the number of rounds played
        int totalScore = 0;   // Track the total score

        while (roundsPlayed < totalRounds) {
            int numberToGuess = random.nextInt(100) + 1; // Generate a random number between 1 and 100
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;

            System.out.println("Round " + (roundsPlayed + 1));
            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attemptsLeft > 0 && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attemptsLeft--;

                if (userGuess == numberToGuess) {
                    System.out.println("Congrats! You have guessed the number correctly!");
                    guessedCorrectly = true;
                    totalScore += (maxAttempts - attemptsLeft); // Score based on attempts used
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (!guessedCorrectly) {
                    System.out.println("Attempts left: " + attemptsLeft);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! The correct number was " + numberToGuess + ".");
            }

            roundsPlayed++;
            System.out.println("\nEnd of Round " + roundsPlayed);
            System.out.println("Your current score: " + totalScore);
            System.out.println();
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Rounds Played: " + roundsPlayed);
        System.out.println("Final Score: " + totalScore);
    }
}
