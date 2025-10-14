import java.util.Scanner;
import java.io.PrintStream;

public class StudentGrading {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxStudents = 5;
        int numSubjects = 5;

        String[] studentNames = new String[maxStudents];
        String[] studentCourses = new String[maxStudents];
        int[][] studentGrades = new int[maxStudents][numSubjects];
        boolean[] hasGrades = new boolean[maxStudents];

        String[] SubjectNames = {
                "Computer Programming",
                "Mabisang Komunikasyon",
                "Effective Communication",
                "General Mathematics",
                "General Science"
        };

        int currentStudentCount = 0;
        boolean running = true;
        PrintStream out = System.out;

        while (running) {
            out.println();
            out.println("================================");
            out.println("     STUDENT GRADING SYSTEM     ");
            out.println("================================");
            out.println("1. Add Students names and Course");
            out.println("2. Add Grades For Student");
            out.println("3. View Student Average Grades");
            out.println("4. Sort Students By Average Grade");
            out.println("5. Delete Student");
            out.println("6. Quit");
            out.println("================================");
            out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    if (currentStudentCount >= maxStudents) {
                        out.println("Cannot add more students! Maximum limit reached.");
                        break;
                    }

                    out.println("\n---- ADD STUDENT ----");
                    out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    out.print("Enter Student Course: ");
                    String course = scanner.nextLine();

                    studentNames[currentStudentCount] = name;
                    studentCourses[currentStudentCount] = course;
                    hasGrades[currentStudentCount] = false;
                    currentStudentCount++;

                    out.println("Student added successfully!");
                    break;

                case "2":
                    if (currentStudentCount == 0) {
                        out.println("No students available! Please add students first.");
                        break;
                    }

                    out.println("\n---- ADD GRADES ----");
                    out.println("List of Students:");
                    for (int i = 0; i < currentStudentCount; i++) {
                        out.println((i + 1) + ". " + studentNames[i]);
                    }

                    out.print("Enter the student number to add grades for: ");
                    int studentIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (studentIndex < 0 || studentIndex >= currentStudentCount) {
                        out.println("Invalid student number!");
                        break;
                    }

                    out.println("Enter grades for " + studentNames[studentIndex] + ":");
                    for (int j = 0; j < numSubjects; j++) {
                        int grade = -1;
                        while (grade < 0 || grade > 100) {
                            out.print("Enter grade for " + SubjectNames[j] + ": ");
                            grade = scanner.nextInt();
                            if (grade < 0 || grade > 100) {
                                out.println("Invalid grade! Enter 0–100.");
                            }
                        }
                        studentGrades[studentIndex][j] = grade;
                    }
                    scanner.nextLine();
                    hasGrades[studentIndex] = true;
                    out.println("Grades added successfully!");
                    break;

                case "3":
                    if (currentStudentCount == 0) {
                        out.println("No students to display!");
                        break;
                    }

                    out.println("\n---- VIEW STUDENT AVERAGE ----");
                    out.println("List of Students:");
                    for (int i = 0; i < currentStudentCount; i++) {
                        out.println((i + 1) + ". " + studentNames[i]);
                    }

                    out.print("Enter the student number to view: ");
                    int viewIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (viewIndex < 0 || viewIndex >= currentStudentCount) {
                        out.println("Invalid student number!");
                        break;
                    }

                    out.println("\nStudent Name: " + studentNames[viewIndex]);
                    out.println("Course: " + studentCourses[viewIndex]);

                    if (!hasGrades[viewIndex]) {
                        out.println("Average Grade: No Grade Found");
                    } else {
                        double average = computeAverage(studentGrades[viewIndex]);
                        out.printf("Average Grade: %.2f%n", average);
                    }
                    break;

                case "4":
                    if (currentStudentCount == 0) {
                        out.println("No students to sort!");
                        break;
                    }

                    out.println("\n---- SORT STUDENTS BY AVERAGE GRADE ----");

                    for (int i = 0; i < currentStudentCount - 1; i++) {
                        for (int j = 0; j < currentStudentCount - i - 1; j++) {
                            double avg1 = hasGrades[j] ? computeAverage(studentGrades[j]) : -1;
                            double avg2 = hasGrades[j + 1] ? computeAverage(studentGrades[j + 1]) : -1;

                            if (avg1 < avg2) {
                                swap(studentNames, studentCourses, studentGrades, hasGrades, j, j + 1);
                            }
                        }
                    }

                    out.println("\nStudents sorted by average grade (highest to lowest):");
                    for (int i = 0; i < currentStudentCount; i++) {
                        out.print((i + 1) + ". " + studentNames[i] + " - ");
                        if (hasGrades[i]) {
                            out.printf("Average: %.2f%n", computeAverage(studentGrades[i]));
                        } else {
                            out.println("No Grade Found");
                        }
                    }
                    break;

                case "5":
                    if (currentStudentCount == 0) {
                        out.println("No students to delete!");
                        break;
                    }

                    out.println("\n---- DELETE STUDENT ----");
                    out.println("List of Students:");
                    for (int i = 0; i < currentStudentCount; i++) {
                        out.println((i + 1) + ". " + studentNames[i]);
                    }

                    out.print("Enter the student number to delete: ");
                    int deleteIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (deleteIndex < 0 || deleteIndex >= currentStudentCount) {
                        out.println("Invalid student number!");
                        break;
                    }

                    for (int i = deleteIndex; i < currentStudentCount - 1; i++) {
                        studentNames[i] = studentNames[i + 1];
                        studentCourses[i] = studentCourses[i + 1];
                        studentGrades[i] = studentGrades[i + 1];
                        hasGrades[i] = hasGrades[i + 1];
                    }

                    currentStudentCount--;
                    out.println("Student deleted successfully!");
                    break;

                case "6":
                    out.println("Exiting program... Goodbye!");
                    running = false;
                    break;

                default:
                    out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }

    private static double computeAverage(int[] grades) {
        int total = 0;
        for (int g : grades) {
            total += g;
        }
        return (double) total / grades.length;
    }

    private static void swap(String[] names, String[] courses, int[][] grades, boolean[] hasGrades, int i, int j) {
        String tempName = names[i];
        String tempCourse = courses[i];
        int[] tempGrades = grades[i];
        boolean tempHasGrades = hasGrades[i];

        names[i] = names[j];
        courses[i] = courses[j];
        grades[i] = grades[j];
        hasGrades[i] = hasGrades[j];

        names[j] = tempName;
        courses[j] = tempCourse;
        grades[j] = tempGrades;
        hasGrades[j] = tempHasGrades;
    }
}