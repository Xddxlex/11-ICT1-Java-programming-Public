import java.util.Scanner;

public class IfElseExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter grade (A, B, C, D, F): ");
        char grade = input.next().charAt(0);

        if (grade == 'A') {
            System.out.println("Excellent! You passed with flying colors.");
        } else if (grade == 'B') {
            System.out.println("Good job! You did well.");
        } else if (grade == 'C') {
            System.out.println("Fair. You passed.");
        } else if (grade == 'D') {
            System.out.println("Needs improvement. You barely passed.");
        } else if (grade == 'F') {
            System.out.println("Fail. Better luck next time.");
        } else {
            System.out.println("Invalid grade entered.");
        }

        input.close();
    }
}
