import java.util.Scanner;
import java.io.PrintStream;

public class ReceiptGenerator {
    public static void main(String[] args) throws java.io.FileNotFoundException {
        // Declare variables
        String customer;
        String product;
        double qty;
        double price;
        double total;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Customer Name: ");
        customer = input.nextLine();
        System.out.print("Enter Product Name: ");
        product = input.nextLine();
        System.out.print("Enter Quantity: ");
        qty = input.nextDouble();
        System.out.print("Enter Price Per Item: ");
        price = input.nextDouble();

        // Compute total
        total = qty * price;

        // Print receipt to console
        System.out.println();
        System.out.println("----- SALES RECEIPT -----");
        System.out.println("Customer: " + customer);
        System.out.println("Product: " + product);
        System.out.println("Quantity: " + qty);
        System.out.println("Price Per Item: " + price);
        System.out.println("Total: " + total);

        // Print receipt to file
        PrintStream ps = new PrintStream("receipt.txt");
        ps.println("--- SALES RECEIPT ---");
        ps.println("Customer: " + customer);
        ps.println("Product: " + product);
        ps.println("Quantity: " + qty);
        ps.println("Price per Item: " + price);
        ps.println("Total: " + total);
        ps.close();

        System.out.println("\nReceipt saved to receipt.txt");

        input.close();
    }
}