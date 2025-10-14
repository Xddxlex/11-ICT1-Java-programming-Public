import java.util.Scanner;

public class FinalPT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Set number of students and subjects
        int maxStudents = 5; // maximum students
        int numSubjects = 9;

        // Arrays for storing student data
        String[] studentNames = new String[maxStudents];
        String[] studentCourses = new String[maxStudents];
        int[][] studentGrades = new int[maxStudents][numSubjects];

        // Subject names array
        String[] subjectNames = {
            "Computer Programming",
            "Mabisang Komunikasyon",
            "Life and Career Skills",
            "Nihongo 1",
            "Effective Communication",
            "General Mathematics",
            "General Science",
            "FCL",
            "PKLP"
        };
        // The current student count
        // it can hold up to maxStudents or 5 Students
        int currentStudentCount = 0; // how many students have been added
        // Bollean to control the loop
        boolean running = true;
        //Main Loop for the menu
        while (running) {
            // Display menu
            System.out.println("================================");
            System.out.println("WELCOME TO THE STUDENT GRADING SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Sort");
            System.out.println("4. Delete");
            System.out.println("5. Average");
            System.out.println("6. Quit");
            System.out.println("================================");
            System.out.print("Enter your choice: ");
           
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": // Add student
                    if (currentStudentCount >= maxStudents) {
                        System.out.println("Maximum number of students reached!");


                        break;
                    }

                    System.out.println("----You chose Add---");
                    System.out.println("================================");
                    System.out.println("PLEASE ENTER STUDENT DETAILS");
                    System.out.println("================================");

                    System.out.print("Enter student name: ");
                    studentNames[currentStudentCount] = scanner.nextLine();

                    System.out.print("Enter student course: ");
                    studentCourses[currentStudentCount] = scanner.nextLine();

                    // Enter grades for 9 subjects
                    for (int i = 0; i < numSubjects; i++) {
                        System.out.print("Enter grade for " + subjectNames[i] + ": ");
                        studentGrades[currentStudentCount][i] = scanner.nextInt();
                        while (studentGrades[currentStudentCount][i] < 0 || studentGrades[currentStudentCount][i] > 100) {
                            System.out.print("Invalid grade. Please enter a grade between 0 and 100 for " + subjectNames[i] + ": ");
                            studentGrades[currentStudentCount][i] = scanner.nextInt();
                        }
                    }
                    scanner.nextLine(); 

                    currentStudentCount++;
                    System.out.println("Student details added successfully!");
                    break;
                

                case "2": // View students
                    if (currentStudentCount == 0) {
                        System.out.println("----No student data available.-----");
                        break;
                    }

                    System.out.println("You chose View");
                    System.out.println("================================");
                    System.out.println("STUDENTS DETAILS");
                    System.out.println("================================");

                    for (int i = 0; i < currentStudentCount; i++) {
                        System.out.println("Name: " + studentNames[i]);
                        System.out.println("Course: " + studentCourses[i]);
                        System.out.println("Grades:");
                        for (int j = 0; j < numSubjects; j++) {
                            System.out.println(" " + subjectNames[j] + ": " + studentGrades[i][j]);
                        }
                        System.out.println("------------------------");
                    }
                    break;

                case "3":
                    System.out.println("You chose Sort");
                    System.out.println("Coming Soon");
                    break;

                case "4": //Delete student
                System.out.println("You chose Delete");
                System.out.println("================================");
                System.out.println("Enter the name of the student to delete: ");
                System.out.println("================================");
                System.out.println("------Display of the students with their names-----");


                   for (int i = 0; i < currentStudentCount; i++) {
                        System.out.println("Name: " + studentNames[i]);
                        System.out.println("Course: " + studentCourses[i]);
                        System.out.println("Grades:");
                        for (int j = 0; j < numSubjects; j++) {
                            System.out.println(" " + subjectNames[j] + ": " + studentGrades[i][j]);
                        }
                        System.out.println("------------------------");
                String nameToDelete = scanner.nextLine();
                boolean found = false;
                for (int g = 0; i < currentStudentCount; i++) {
                    if (studentNames[i].equalsIgnoreCase(nameToDelete)) {
                        found = true;
                        for (int j = i; j < currentStudentCount - 1; j++) {
                            studentNames[j] = studentNames[j + 1];
                            studentCourses[j] = studentCourses[j + 1];
                            studentGrades[j] = studentGrades[j + 1];
                        }
                        currentStudentCount--;
                        System.out.println("Student " + nameToDelete + " deleted successfully.");
                        break;
                    }
                    System.err.println("---------------------------------");
                    System.err.println("End of the Student List");
                    System.err.println("---------------------------------");
                    System.out.println( "Press enter to EXIT");
                }
                if (!found) {
                    System.out.println("Student " + nameToDelete + " not found.");
                }
            }
                case "5":
                System.out.println("You chose Average");
                System.out.println("================================");
                System.out.println("Average Grades for Each Student");
                System.out.println("================================");
                for (int i = 0; i < currentStudentCount; i++) {
                    int total = 0;
                    for (int j = 0; j < numSubjects; j++) {
                      total += studentGrades[i][j];
                        }
                        double average = (double) total / numSubjects;
                        System.out.printf("Name: %s, Average Grade: %.2f%n", studentNames[i], average);
                    }
                    break;
                            
                    case "6":
                    System.out.println("You chose Quit");
                    System.out.println("Exiting program...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println(); 
        }

        scanner.close();
    }
}

//*NEED FIXES MAKE THE USER INPUT FOR THE GRADES IN ADD KEEP LOOPING UNTIL A DOUBLE DIGIT HAS BEEN FORMED */
// DO THE SORTING SYSTEM Case 3