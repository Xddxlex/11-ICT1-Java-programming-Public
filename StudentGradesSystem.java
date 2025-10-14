import java.util.*;

class Student {
    String name;
    String course;
    double grade;

    Student(String name, String course, double grade) {
        this.name = name;
        this.course = course;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name + " | " + course + " | Grade: " + grade;
    }
}

public class StudentGradesSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n===== Student Grades System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Sort Students by Name");
            System.out.println("4. Edit Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> sortStudents();
                case 4 -> editStudent();
                case 5 -> deleteStudent();
                case 6 -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student's course: ");
        String course = scanner.nextLine();
        System.out.print("Enter student's grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine(); // clear buffer

        students.add(new Student(name, course, grade));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the list.");
            return;
        }
        System.out.println("\n=== Student List ===");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
    }

    private static void sortStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to sort.");
            return;
        }
        students.sort(Comparator.comparing(s -> s.name.toLowerCase()));
        System.out.println("Students sorted alphabetically by name!");
    }

    private static void editStudent() {
        viewStudents();
        if (students.isEmpty()) return;

        System.out.print("Enter the number of the student to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        if (index < 1 || index > students.size()) {
            System.out.println("Invalid student number.");
            return;
        }

        Student s = students.get(index - 1);

        System.out.print("Enter new name (leave blank to keep '" + s.name + "'): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) s.name = newName;

        System.out.print("Enter new course (leave blank to keep '" + s.course + "'): ");
        String newCourse = scanner.nextLine();
        if (!newCourse.isEmpty()) s.course = newCourse;

        System.out.print("Enter new grade (or -1 to keep " + s.grade + "): ");
        double newGrade = scanner.nextDouble();
        scanner.nextLine(); // clear buffer
        if (newGrade >= 0) s.grade = newGrade;

        System.out.println("Student updated successfully!");
    }

    private static void deleteStudent() {
        viewStudents();
        if (students.isEmpty()) return;

        System.out.print("Enter the number of the student to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        if (index < 1 || index > students.size()) {
            System.out.println("Invalid student number.");
            return;
        }

        students.remove(index - 1);
        System.out.println("Student deleted successfully!");
    }
}
