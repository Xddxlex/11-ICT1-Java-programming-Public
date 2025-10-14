import java.util.Scanner;

public class Javapractice3 {
    public static void main(String[] args) {
        
        //making a witholdinng tax calculator 

        Scanner scanner = new Scanner(System.in); 
        
        //Total Deductions Variables (1)
        
        Double sss= 200.0; 
        Double philhealth = 100.0;
        Double pagibig = 100.0;
        Double TD = sss + philhealth + pagibig;

        //witholding tax Variables Table (2)
        
         

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        scanner.close();
        }
    }
