import java.util.Scanner;

public class SwitchExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter grade (A, B, C, D, F): ");
        char grade = input.next().charAt(0);

        switch (grade) {
            case 'A':
                System.out.println("Excellent! You passed with flying colors.");
                break;
            case 'B':
                System.out.println("Good job! You did well.");
                break;
            case 'C':
                System.out.println("Fair. You passed.");
                break;
            case 'D':
                System.out.println("Needs improvement. You barely passed.");
                break;
            case 'F':
                System.out.println("Fail. Better luck next time.");
                break;
            default:
                System.out.println("Invalid grade entered.");
        }

        input.close();
    }
}
