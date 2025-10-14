//Java Introduction and Lesson:2 Variables and Data Types 
public class Java_Practice {
    public static void main(String[] args)
    {
        // How to print a message in Java 
        System.out.println("Hello. World!");

        // Variables and Data Types Primitive Variables 
        int age = 25; // Integer variable
        double salary = 50000.50; // Double variable
        char grade = 'A'; // Character variable
        boolean isEmployed = false; // Boolean variable

        // Printing variables
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Grade: " + grade);
        System.out.println("Employed: " + isEmployed);
       if (isEmployed) {
            System.out.println("You are employed.");
        } else {
            System.out.println("You are not employed.");
        }
        //Strings Variables// Reference Variables 
        String name = " Francis Alex J. Geraldizo";
        String address = "5 MA. lourdes vsllrjo st. Las Pinas City, Philippines";
        // Removed incomplete String declaration
        
        System.out.println(" your name is:" + name) ;
        System.out.println("Your address is: " + address);

        

       }
}