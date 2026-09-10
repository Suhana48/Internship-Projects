package task03_numberguessing;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;

        System.out.println("Number Guessing Game");
        System.out.println("Guess a number between 1 and 100");

        while (true) {

            System.out.print("\nEnter your guess: ");

            try {

                int guess = scanner.nextInt();


                if (guess < 1 || guess > 100) {
                    System.out.println("Enter only numbers between 1 and 100.");
                    continue;
                }

                attempts++;

                if (guess > secretNumber) {
                    System.out.println("LOWER!");

                } else if (guess < secretNumber) {
                    System.out.println("HIGHER!");

                } else {
                    System.out.println("\nCorrect!");
                    System.out.println("Attempts: " + attempts);
                    break;
                }

            } catch (InputMismatchException e) {


                System.out.println("Invalid input! Enter a whole number.");
                scanner.nextLine(); // clear invalid input
            }
        }

        scanner.close();
    }
}