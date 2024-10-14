/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number_game;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ntau9
 */
public class Number_Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!\n");
        
        while (playAgain) {
            // Set up the game
            int numberToGuess = random.nextInt(100) + 1; // Generate a random number between 1 and 100
            int maxAttempts = 10; // Set the number of allowed attempts
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Guese any number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");
            
            // Main game loop for the round
            while (attempts < maxAttempts && !guessedCorrectly) {
               
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                // Check the user's guess
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number correctly in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score++; // Increment score when guessed correctly
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            // If the user didn't guess the number
            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all " + maxAttempts + " attempts.");
                System.out.println("The correct number was: " + numberToGuess);
            }

            // Ask if the user wants to play another round
            System.out.print("\nDo you want to play again? Press 1 or any key to quiet: ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("1");
        }

        // Display final score
        System.out.println("\nGame over! Your final score is: " + score);
        System.out.println("Thanks for playing!");
        
        scanner.close();
    }
    
}
