import java.util.Scanner;
import java.io.PrintStream;

public class ExamScore {
    public static void main(String[] args) throws java.io.FileNotFoundException {
        // Declare variables
        int ExamScore;
        String Grade;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter exam Score: ");
        ExamScore = input.nextInt(); // Read integer input
        

         // Use if else statements to determine the grade
        if (ExamScore >= 90) {
            Grade = "A";
        } else if (ExamScore >= 80) {
            Grade = "B";
        } else if (ExamScore >= 70) {
            Grade = "C";
        } else if (ExamScore >= 60) {
            Grade = "D";
        } else {
            Grade = "F";
        }
        // Print grade report to console (formatted)
        System.out.println();
        System.out.println("Enter exam Score: " + ExamScore);
        System.out.println("Grade: " + Grade);
    
        // Print grade report to file (formatted)
        PrintStream ps = new PrintStream("Grade Report(2).txt");
        ps.println("Enter exam Score: " +   ExamScore);
        ps.println("Grade: " + Grade);
        ps.close();
        

        System.out.println("\nGrade Report.txt has been created.");
        input.close();
    }
}
