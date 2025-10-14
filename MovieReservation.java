import java.util.Scanner;

public class MovieReservation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Declarations
        boolean[][] seats = new boolean[4][5]; //4 rows, 5 seats each row
        int row;
        int seat;
        int sort;
        char[] rowletter = {'A','B','C','D','E'};
        char[] colletter = {'A','B','C','D','E'};
        char confirm;

        //Example on how to put a X mark on a Seat
         /*
         seats[0][1] = true;   // A2 will be X
         seats[2][3] = true;   // C4 will be X
         seats[3][0] = true;   // D1 will Be X
          */


        //Menu Loop
        while (true) {
            System.out.println("=== Movie Reservation Menu ===");
            System.out.println("1. View Seat Map");
            System.out.println("2. Reserve Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Sort by Customer (Name/Time)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    //Display seat map
                    System.out.println("=== Movie Theater Seat Map ===");
                    for (row = 0; row < seats.length; row++) {
                        System.out.print("Row " + rowletter[0]++ +": ");
                        for (seat = 0; seat < seats[row].length; seat++){
                            if (seats[row][seat]) {
                                System.out.print("[X] "); //Code for Seat Taken
                            } else {
                                System.out.print("["+ colletter[row] +(seat + 1) + "] ");
                            }
                        }
                        System.out.println();
                    }

                    break;

                case 2:
                    System.out.println("Reserve seat feature coming soon...(AKA NAKAKATAMAD)");
                    break;

                case 3:
                    System.out.println("Cancel reservation feature coming soon...(AKA NAKAKATAMAD)");
                    break;

                case 4:
                    do {
                            System.out.println("Sort By");
                            System.out.println("1| Customer Name");
                            System.out.println("2| Time");
                            sort = scanner.nextInt();

                            if (sort == 1) {
                                System.out.println("NAKAKATAMAD PA");
                                scanner.nextLine();

                            } else if (sort == 2) {
                                System.out.println("NAKAKATAMAD DIN ULET");
                                scanner.nextLine();
                            } else {
                                System.out.println("INVALID OPTION");
                                sort = 5;
                            }
                    }while(sort == 5);

                    System.out.println("Press ENTER to Return");
                    scanner.nextLine();

                    break;
                case 5:
                    System.out.print("Are you sure you want to exit? (y/n): ");
                    confirm = scanner.next().toUpperCase().charAt(0);
                    if (confirm == 'Y') {
                        System.out.println("THANK YOU FOR USING OUR MOVIE RESERVATION SYSTEM!");
                        return; // Code Ends Here
                    } else {

                    }
                    break;
                default:

                    System.out.println("Invalid Option");
                    System.out.println("Returning to menu...");
            }
        }
    }
}
