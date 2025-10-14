import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
public class utilScanner {
    public static void main(String[] args) {
        //Decalre the variable
        String CN;
        String PN;
        double Q;
        double PPI;

        Scanner input = new Scanner(System.in);

        try {
            PrintStream ps = new PrintStream(new FileOutputStream("receipt.txt"));

            System.out.print("Enter Customer Name: ");
            CN = input.nextLine();
            System.out.print("Enter Product Name: ");
            PN = input.nextLine();
            System.out.print("Enter Quantity: ");
            Q = input.nextDouble();
            System.out.print("Enter Price Per Item: ");
            PPI = input.nextDouble();

            // Print to file using PrintStream
            ps.println();
            ps.println("----- SALES RECEIPT -----");
            ps.println("Customer: " + CN);
            ps.println("Product: " + PN);
            ps.println("Quantity: " + Q);
            ps.println("Price Per Item: " + PPI);
            ps.println("Total: " + (Q * PPI));

            // Use the variable
            System.out.println();
            System.out.println("----- SALES RECEIPT -----");
            System.out.println("Customer: " + CN);
            System.out.println("Product: " + PN);
            System.out.println("Quantity: " + Q);
            System.out.println("Price Per Item: " + PPI);
            System.out.println("Total: " + (Q * PPI));

            ps.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        input.close();
    }
}      