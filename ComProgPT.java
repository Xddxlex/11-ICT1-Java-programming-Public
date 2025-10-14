import java.util.Scanner;
public class ComProgPT {
    public static void main(String[] args) {
        
        String Add;
        String View;
        String Sort;
        String Average;
        String Quit;
        
        
        Scanner scanner = new Scanner(System.in);

        // Ask how many elements the user wants
        
        System.out.println("================================");
        System.out.println("WELCOME TO THE STUDENT GRADING SYSTEM PLEASE ENTER YOUR DETAILS");
        System.out.println("================================");
        System.out.print(" \n");

        System.out.println("Please enter your choice (Number)");
        System.out.println("====");
        System.out.println(" 1. Add");
        System.out.println(" 2. View");
        System.out.println(" 3. Sort");
        System.out.println(" 4. Average");
        System.out.println(" 5. Quit");
        System.out.print(" \n");
        String choice = scanner.nextLine();


        //Switch Case, Case 1 Add, Case 2, View, Case 3 Sort, Case 4 Average, Case 5 Quit.


        // Case 1 Add
        //sTEP 1 Ask how many elements the user wants
        switch (choice) {
            case "1":
                System.out.println("You chose Add");
               
    
        
        System.out.print("Students name : ");
        int size = scanner.nextInt();
        

        // Step 2: Create an array
          String[] names = new String[size];

        // Step 3: Store user input into the array
        for (int i = 0; i < size; i++) {
            System.out.print("Enter Name " + (i + 1) + ": ");
            names[i] = scanner.nextLine(); // <-- store input in array
        }

        // Step 4: Display stored values
        System.out.println("\nYou entered:");
        for (int i = 0; i < size; i++) {
         System.out.println("Student " + (i + 1) + ": " + names[i]);

        }

                break;
            case "2":
                System.out.println("You chose View");
                System.out.println("Coming Soon");
                break;
            case "3":
                System.out.println("You chose Sort");
                System.out.println("Coming Soon");
                break;
            case "4":
                System.out.println("You chose Average");
                System.out.println("Coming Soon");
                break;
            case "5":
                System.out.println("You chose Quit");
                System.out.println("Coming Soon");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

        scanner.close();
    }
}
                
