import java.util.ArrayList;
 import java.util.Scanner;
 import java.io.*;
 public class GradingSystem {
  private static ArrayList<Student> students = new ArrayList<>();
  private static Scanner scanner = new Scanner(System.in);
  private static final String DATA_FILE = "grades.txt";
  public static void main(String[] args) {
  loadData();
  mainLoop();
  }
  
  private static void loadData() {
  try (BufferedReader br = new BufferedReader(new FileReader(DATA_FILE))) {
  String line;
  while ((line = br.readLine()) != null) {
  String[] parts = line.split(",");
  if (parts.length == 3) {
  try {
  String name = parts[0];
  String course = parts[1];
  double grade = Double.parseDouble(parts[2]);
  students.add(new Student(name, course, grade));
  } catch (NumberFormatException e) {
  System.err.println("Error parsing grade: " + parts[2]);
  }
  } else {
  System.err.println("Invalid data format: " + line);
  }
  }
  } catch (IOException e) {
  System.err.println("Error loading data: " + e.getMessage());
  }
  }
  
  private static void saveData() {
  try (PrintWriter pw = new PrintWriter(new FileWriter(DATA_FILE))) {
  for (Student student : students) {
  pw.println(student.getName() + "," + student.getCourse() + "," + student.getGrade());
  }
  } catch (IOException e) {
  System.err.println("Error saving data: " + e.getMessage());
  }
  }
  
  private static void mainLoop() {
  while (true) {
  System.out.println("\nOptions: add | update | delete | search | view | sort | quit");
  System.out.print("Enter command: ");
  String command = scanner.nextLine().trim().toLowerCase();
  switch (command) {
  case "add":
  addStudent();
  break;
  case "update":
  updateStudent();
  break;
  case "delete":
  deleteStudent();
  break;
  case "search":
  searchStudents();
  break;
  case "view":
  viewStudents();
  break;
  case "sort":
  sortStudents();
  break;
  case "quit":
  saveData();
  System.out.println("Exiting program.");
  return;
  default:
  System.out.println("Invalid command. Please try again.");
  }
  }
  }
  
  private static void addStudent() {
  System.out.print("Enter student name: ");
  String name = scanner.nextLine();
  System.out.print("Enter course name: ");
  String course = scanner.nextLine();
  System.out.print("Enter grade: ");
  try {
  double grade = Double.parseDouble(scanner.nextLine());
  students.add(new Student(name, course, grade));
  System.out.println("Student added.");
  } catch (NumberFormatException e) {
  System.out.println("Invalid grade format.");
  }
  }
  
  private static void updateStudent() {
  System.out.print("Enter the index of the student to update: ");
  try {
  int index = Integer.parseInt(scanner.nextLine());
  if (index >= 0 && index < students.size()) {
  System.out.print("Enter new student name: ");
  String name = scanner.nextLine();
  System.out.print("Enter new course name: ");
  String course = scanner.nextLine();
  System.out.print("Enter new grade: ");
  try {
  double grade = Double.parseDouble(scanner.nextLine());
  students.set(index, new Student(name, course, grade));
  System.out.println("Student updated.");
  } catch (NumberFormatException e) {
  System.out.println("Invalid grade format.");
  }
  } else {
  System.out.println("Invalid index.");
  }
  } catch (NumberFormatException e) {
  System.out.println("Invalid index format.");
  }
  }
  
  private static void deleteStudent() {
  System.out.print("Enter the index of the student to delete: ");
  try {
  int index = Integer.parseInt(scanner.nextLine());
  if (index >= 0 && index < students.size()) {
  students.remove(index);
  System.out.println("Student deleted.");
  } else {
  System.out.println("Invalid index.");
  }
  } catch (NumberFormatException e) {
  System.out.println("Invalid index format.");
  }
  }
  
  private static void searchStudents() {
  System.out.print("Enter search term: ");
  String term = scanner.nextLine().toLowerCase();
  for (int i = 0; i < students.size(); i++) {
  Student student = students.get(i);
  if (student.getName().toLowerCase().contains(term) ||
  student.getCourse().toLowerCase().contains(term)) {
  System.out.println("Student found at index " + i + ": " + student);
  }
  }
  }
  
  private static void viewStudents() {
  if (students.isEmpty()) {
  System.out.println("No students found.");
  return;
  }
  for (int i = 0; i < students.size(); i++) {
  System.out.println("Index " + i + ": " + students.get(i));
  }
  }
  
  private static void sortStudents() {
  students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
  System.out.println("Students sorted by name.");
  }
 }
 class Student {
  private String name;
  private String course;
  private double grade;

  public Student(String name, String course, double grade) {
    this.name = name;
    this.course = course;
    this.grade = grade;
  }

  public String getName() {
    return name;
  }

  public String getCourse() {
    return course;
  }

  public double getGrade() {
    return grade;
  }

  @Override
  public String toString() {
    return "Name: " + name + ", Course: " + course + ", Grade: " + grade;
  }
}