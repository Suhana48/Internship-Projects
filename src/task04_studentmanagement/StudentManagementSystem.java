package task04_studentmanagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManagementSystem {

    static final int MAX_STUDENTS = 100;

    static int[] studentIds = new int[MAX_STUDENTS];
    static String[] studentNames = new String[MAX_STUDENTS];
    static int[] studentAges = new int[MAX_STUDENTS];

    static int studentCount = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            displayMenu();

            int choice = getIntegerInput(scanner, "Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent(scanner);
                    break;

                case 2:
                    searchStudent(scanner);
                    break;

                case 3:
                    updateStudent(scanner);
                    break;

                case 4:
                    displayStudents();
                    break;

                case 5:
                    System.out.println("\nExiting Student Management System...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please select between 1 and 5.");
            }
        }
    }

    // Displays the main menu
    public static void displayMenu() {

        System.out.println("\n===== Student Management System =====");
        System.out.println("1. Add Student");
        System.out.println("2. Search Student");
        System.out.println("3. Update Student");
        System.out.println("4. Display All Students");
        System.out.println("5. Exit");
    }

    // Adds a new student
    public static void addStudent(Scanner scanner) {

        if (studentCount >= MAX_STUDENTS) {
            System.out.println("Cannot add more students. The array is full.");
            return;
        }

        System.out.println("\n--- Add Student ---");

        int id = getIntegerInput(scanner, "Enter student ID: ");

        // Check for duplicate ID
        if (findStudentIndex(id) != -1) {
            System.out.println("Student ID already exists. Please use a unique ID.");
            return;
        }

        scanner.nextLine();

        String name;

        while (true) {

            System.out.print("Enter student name: ");
            name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
            } else {
                break;
            }
        }

        int age;

        while (true) {

            age = getIntegerInput(scanner, "Enter student age: ");

            if (age <= 0) {
                System.out.println("Age must be greater than 0.");
            } else {
                break;
            }
        }

        studentIds[studentCount] = id;
        studentNames[studentCount] = name;
        studentAges[studentCount] = age;

        studentCount++;

        System.out.println("Student added successfully.");
    }

    // Searches for a student using student ID
    public static void searchStudent(Scanner scanner) {

        System.out.println("\n--- Search Student ---");

        int id = getIntegerInput(scanner, "Enter student ID to search: ");

        int index = findStudentIndex(id);

        if (index == -1) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("\nStudent Found");
        System.out.println("ID   : " + studentIds[index]);
        System.out.println("Name : " + studentNames[index]);
        System.out.println("Age  : " + studentAges[index]);
    }

    // Updates an existing student's details
    public static void updateStudent(Scanner scanner) {

        System.out.println("\n--- Update Student ---");

        int id = getIntegerInput(scanner, "Enter student ID to update: ");

        int index = findStudentIndex(id);

        if (index == -1) {
            System.out.println("Student not found.");
            return;
        }

        scanner.nextLine();

        String newName;

        while (true) {

            System.out.print("Enter new name: ");
            newName = scanner.nextLine().trim();

            if (newName.isEmpty()) {
                System.out.println("Name cannot be empty.");
            } else {
                break;
            }
        }

        int newAge;

        while (true) {

            newAge = getIntegerInput(scanner, "Enter new age: ");

            if (newAge <= 0) {
                System.out.println("Age must be greater than 0.");
            } else {
                break;
            }
        }

        studentNames[index] = newName;
        studentAges[index] = newAge;

        System.out.println("Student updated successfully.");
    }

    // Displays all students
    public static void displayStudents() {

        System.out.println("\n--- All Students ---");

        if (studentCount == 0) {
            System.out.println("No student records available.");
            return;
        }

        System.out.printf("%-10s %-20s %-10s%n", "ID", "Name", "Age");
        System.out.println("--------------------------------------------");

        for (int i = 0; i < studentCount; i++) {

            System.out.printf(
                    "%-10d %-20s %-10d%n",
                    studentIds[i],
                    studentNames[i],
                    studentAges[i]
            );
        }
    }

    // Finds a student and returns the index
    public static int findStudentIndex(int id) {

        for (int i = 0; i < studentCount; i++) {

            if (studentIds[i] == id) {
                return i;
            }
        }

        return -1;
    }

    // Safely reads an integer
    public static int getIntegerInput(Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            try {

                return scanner.nextInt();

            } catch (InputMismatchException e) {

                System.out.println("Invalid input! Please enter a whole number.");
                scanner.nextLine();
            }
        }
    }
}