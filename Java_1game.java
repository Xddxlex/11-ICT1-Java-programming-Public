import java.util.Scanner;

  public class Java_1game {  
       public static void main(String[] args) {

        //Mad Libs Game 

        Scanner scanner = new Scanner(System.in);
    
        String adjective1;
        String noun1;
        String adjective2;
        String verb1;
        String adjective3;

        System.out.println("Welcome to the Mad Libs Game!");
        System.out.println("Please enter the following words:");


        System.out.println("Enter an adjective (Description)");  
        adjective1 = scanner.nextLine();
        System.out.println("Enter a noun:");           
         noun1 = scanner.nextLine();
        System.out.println("Enter another adjective:"); 
        adjective2 = scanner.nextLine();
        System.out.println("Enter a verb:");           
        verb1 = scanner.nextLine();
        System.out.println("Enter another adjective:");
        adjective3 = scanner.nextLine();
        System.out.println("\nHere is your story:\n");
        System.out.println("Once upon a time, there was a " + adjective1 + " " + noun1 + " who loved to " + verb1 + " in a " + adjective2 + " and " + adjective3 + " world.");

        scanner.close(); 
       }
    
    } 
    
        
    
