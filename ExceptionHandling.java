import java.io.*;
import java.sql.*;

public class ExceptionHandling {

    public static void main(String[] args) {
        // Prompt the user for actions to simulate and handle exceptions
        System.out.println("Simulating exceptions. Enter data where prompted.\n");

        simulateIOException();
        simulateFileNotFoundException();
        simulateEOFException();
        simulateSQLException();
        simulateClassNotFoundException();
        simulateArithmeticException();
        simulateNullPointerException();
        simulateArrayIndexOutOfBoundsException();
        simulateClassCastException();
        simulateIllegalArgumentException();
        simulateNumberFormatException();
    }

    private static void simulateIOException() {
        System.out.println("\nSimulating IOException:");
        try {
            System.out.println("Enter the file path to read:");
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
            String filePath = inputReader.readLine();

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            System.out.println("File content: " + reader.readLine());
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }

    private static void simulateFileNotFoundException() {
        System.out.println("\nSimulating FileNotFoundException:");
        try {
            System.out.println("Enter the file path to open:");
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
            String filePath = inputReader.readLine();

            FileReader file = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException caught while reading input: " + e.getMessage());
        }
    }

    private static void simulateEOFException() {
        System.out.println("\nSimulating EOFException:");
        try {
            System.out.println("Enter the file path for a serialized file:");
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
            String filePath = inputReader.readLine();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
            ois.readObject();
        } catch (EOFException e) {
            System.out.println("EOFException caught: End of file reached unexpectedly.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Other exception caught: " + e.getMessage());
        }
    }

    private static void simulateSQLException() {
        System.out.println("\nSimulating SQLException:");
        try {
            System.out.println("Enter database URL (e.g., jdbc:mysql://localhost:3306/testdb):");
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
            String dbUrl = inputReader.readLine();

            System.out.println("Enter username:");
            String user = inputReader.readLine();

            System.out.println("Enter password:");
            String password = inputReader.readLine();

            Connection connection = DriverManager.getConnection(dbUrl, user, password);
        } catch (SQLException e) {
            System.out.println("SQLException caught: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException caught while reading input: " + e.getMessage());
        }
    }

    private static void simulateClassNotFoundException() {
        System.out.println("\nSimulating ClassNotFoundException:");
        try {
            System.out.println("Enter the name of a class to load:");
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
            String className = inputReader.readLine();

            Class.forName(className);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException caught: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException caught while reading input: " + e.getMessage());
        }
    }

    private static void simulateArithmeticException() {
        System.out.println("\nSimulating ArithmeticException:");
        try {
            System.out.println("Enter two integers to divide (numerator and denominator):");
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
            int numerator = Integer.parseInt(inputReader.readLine());
            int denominator = Integer.parseInt(inputReader.readLine());

            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException caught while reading input: " + e.getMessage());
        }
    }

    private static void simulateNullPointerException() {
        System.out.println("\nSimulating NullPointerException:");
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: Attempted to access a null reference.");
        }
    }

    private static void simulateArrayIndexOutOfBoundsException() {
        System.out.println("\nSimulating ArrayIndexOutOfBoundsException:");
        try {
            int[] numbers = {1, 2, 3};
            System.out.println("Enter an array index to access (0-2):");
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
            int index = Integer.parseInt(inputReader.readLine());

            System.out.println("Value at index " + index + ": " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException caught while reading input: " + e.getMessage());
        }
    }

    private static void simulateClassCastException() {
        System.out.println("\nSimulating ClassCastException:");
        try {
            Object obj = "Hello";
            Integer num = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught: " + e.getMessage());
        }
    }

    private static void simulateIllegalArgumentException() {
        System.out.println("\nSimulating IllegalArgumentException:");
        try {
            Thread thread = new Thread();
            thread.setPriority(20);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        }
    }

    private static void simulateNumberFormatException() {
        System.out.println("\nSimulating NumberFormatException:");
        try {
            System.out.println("Enter a string to parse as an integer:");
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(inputReader.readLine());

            System.out.println("Parsed number: " + num);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException caught while reading input: " + e.getMessage());
        }
    }
}
