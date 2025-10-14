import java.util.Scanner;
import java.io.PrintStream;

public class GradeReport {
    public static void main(String[] args) throws java.io.FileNotFoundException {
        // Declare variables
        String Name;
        double Q1;
        double Q2;
        double Q3;
        double average;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Name: ");
        Name = input.nextLine();
        System.out.print("Enter Quiz score 1: ");
        Q1 = input.nextDouble();
        System.out.print("Enter Quiz score 2: ");
        Q2 = input.nextDouble();
        System.out.print("Enter Quiz score 3: ");
        Q3 = input.nextDouble();

        // Compute total
        average = (Q1 + Q2 + Q3) / 3.0;  // Add all scores and divide by 3 to get average

        // Print grade report to console (formatted)
        System.out.println();
        System.out.println("----- GRADE REPORT -----");
        System.out.println("Student: " + Name);
        System.out.printf("Quiz 1: %.2f\n", Q1);
        System.out.printf("Quiz 2: %.2f\n", Q2);
        System.out.printf("Quiz 3: %.2f\n", Q3);
        System.out.printf("Average: %.2f\n", average);

        // Print grade report to file (formatted)
        PrintStream ps = new PrintStream("Grade Report.txt");
        ps.println("----- GRADE REPORT -----");
        ps.println("Student: " + Name);
        ps.printf("Quiz 1: %.2f\n", Q1);
        ps.printf("Quiz 2: %.2f\n", Q2);
        ps.printf("Quiz 3: %.2f\n", Q3);
        ps.printf("Average: %.2f\n", average);
        ps.close();

        System.out.println("\nGrade Report.txt has been created.");
        input.close();
    }
}
