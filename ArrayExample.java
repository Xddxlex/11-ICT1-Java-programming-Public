import java.util.Scanner;

public class ArrayExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask how many elements the user wants
        System.out.print("How many numbers do you want to store? ");
        int size = scanner.nextInt();

        // Create an array with the given size
        int[] numbers = new int[size = 5];

        // Input values into the array
        for (int i = 0; i < size; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Display the values
        System.out.println("\nYou entered:");
        for (int i = 0; i < size; i++) {
            System.out.println("Number " + (i + 1) + ": " + numbers[i]);
        }

        scanner.close();
    }
}
