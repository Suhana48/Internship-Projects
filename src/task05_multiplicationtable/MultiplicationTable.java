package task05_multiplicationtable;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiplicationTable {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Multiplication Table Generator =====");
            System.out.println("1. Generate table for one number");
            System.out.println("2. Generate tables for a range");
            System.out.println("3. Exit");

            int choice = getNumber(sc, "Enter your choice: ");

            if (choice == 1) {

                int number = getNumber(sc, "Enter a number: ");
                generateTable(number);

            } else if (choice == 2) {

                int start = getNumber(sc, "Enter starting number: ");
                int end = getNumber(sc, "Enter ending number: ");

                if (start > end) {
                    System.out.println("Starting number cannot be greater than ending number.");
                } else {
                    for (int i = start; i <= end; i++) {
                        generateTable(i);
                    }
                }

            } else if (choice == 3) {

                System.out.println("Thank you!");
                break;

            } else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }

    public static void generateTable(int number) {

        System.out.println("\n--- Table of " + number + " ---");

        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
    }

    public static int getNumber(Scanner sc, String message) {

        while (true) {

            System.out.print(message);

            try {
                return sc.nextInt();

            } catch (InputMismatchException e) {

                System.out.println("Please enter a valid whole number.");
                sc.nextLine();
            }
        }
    }
}