package task02_gradecalculator;

import java.util.Scanner;

public class StudentGradeCalculator {

    // Calculates the total marks
    public static double calculateTotal(double[] marks) {
        double total = 0;

        for (double mark : marks) {
            total += mark;
        }

        return total;
    }

    // Calculates the percentage
    public static double calculatePercentage(double total, int numberOfSubjects) {
        return (total / (numberOfSubjects * 100)) * 100;
    }

    // Determines the grade based on percentage
    public static String calculateGrade(double percentage) {

        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("STUDENT GRADE CALCULATOR");

        // Validate number of subjects
        int numberOfSubjects;

        System.out.print("\nEnter number of subjects: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a whole number.");
            scanner.next();
            System.out.print("Enter number of subjects: ");
        }

        numberOfSubjects = scanner.nextInt();

        while (numberOfSubjects <= 0) {
            System.out.println("Number of subjects must be greater than 0.");
            System.out.print("Enter number of subjects: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next();
                System.out.print("Enter number of subjects: ");
            }

            numberOfSubjects = scanner.nextInt();
        }

        // Create array dynamically
        double[] marks = new double[numberOfSubjects];

        // Take and validate marks
        for (int i = 0; i < numberOfSubjects; i++) {

            System.out.print("Enter marks for Subject " + (i + 1) + " (0-100): ");

            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
                System.out.print("Enter marks for Subject " + (i + 1) + " (0-100): ");
            }

            marks[i] = scanner.nextDouble();

            while (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks. Marks must be between 0 and 100.");

                System.out.print("Enter marks for Subject " + (i + 1) + " (0-100): ");

                while (!scanner.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next();
                    System.out.print("Enter marks for Subject " + (i + 1) + " (0-100): ");
                }

                marks[i] = scanner.nextDouble();
            }
        }

        // Perform calculations
        double total = calculateTotal(marks);
        double percentage = calculatePercentage(total, numberOfSubjects);
        String grade = calculateGrade(percentage);

        // Display result
        System.out.println("\nRESULT");

        System.out.printf("Total Marks: %.2f / %d%n",
                total, numberOfSubjects * 100);

        System.out.printf("Percentage: %.2f%%%n", percentage);

        System.out.println("Grade: " + grade);

        System.out.println("============================");

        scanner.close();
    }
}