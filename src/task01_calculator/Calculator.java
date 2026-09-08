package task01_calculator;

import java.util.Scanner;

public class Calculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return a / b;
    }

    public static double modulus(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot perform modulus by zero.");
        }
        return a % b;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Command-Line Calculator !!");

        System.out.print("Enter first number: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
            System.out.print("Enter first number: ");
        }
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
            System.out.print("Enter second number: ");
        }
        double num2 = scanner.nextDouble();

        System.out.println("Choose an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Modulus");

        System.out.print("Enter your choice (1-5): ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            scanner.next();
            System.out.print("Enter your choice (1-5): ");
        }

        int choice = scanner.nextInt();

        try {
            double result;

            switch (choice) {
                case 1:
                    result = add(num1, num2);
                    break;
                case 2:
                    result = subtract(num1, num2);
                    break;
                case 3:
                    result = multiply(num1, num2);
                    break;
                case 4:
                    result = divide(num1, num2);
                    break;
                case 5:
                    result = modulus(num1, num2);
                    break;
                default:
                    System.out.println("Invalid operation selected.");
                    scanner.close();
                    return;
            }

            System.out.println("\nResult: " + result);

        } catch (ArithmeticException e) {
            System.out.println("\nError: " + e.getMessage());
        }

        scanner.close();
    }
}