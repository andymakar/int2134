import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/*
* Name: Adam Ktona, Tyler Magdich, Deshawn Studavent
* Description: The main class of the program. Displays the main menu in a loop and calls the other classes' methods for each function
*/
public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException, IOException {
        Libraries.displayLogo();
        
        String option = null;
        Scanner input = new Scanner(System.in);
        
        while (!"9".equals(option)) {
            
            Libraries.displayHeader("Main Menu");
            System.out.println("| Option 1: Add A Client                                |");
            System.out.println("| Option 2: Update A Client                             |");
            System.out.println("| Option 3: Delete A Client                             |");
            System.out.println("| Option 4: Add A Show                                  |");
            System.out.println("| Option 5: Update A Show                               |");
            System.out.println("| Option 6: Delete A Show                               |");
            System.out.println("| Option 7: List of Clients Report                      |");
            System.out.println("| Option 8: List of Magic Shows for the Month           |");
            System.out.println("| Option 9: Exit                                        |");
            System.out.println("\\-------------------------------------------------------/\n");
            System.out.print("> Enter a number from 1 to 9: ");
            
            option = input.next();
            option = option.toUpperCase();
            
            switch (option) {
                case "1":
                    System.out.println("");
                    Client.addClient();
                    System.out.println("");
                    break;
                case "2":
                    System.out.println("");
                    Client.updateClient();
                    System.out.println("");
                    break;
                case "3":
                    System.out.println("");
                    Client.deleteClient();
                    System.out.println("");
                    break;
                case "4":
                    System.out.println("");
                    Show.addShow();
                    System.out.println("");
                    break;
                case "5":
                    System.out.println("");
                    Show.updateShow();
                    System.out.println("");
                    break;
                case "6":
                    System.out.println("");
                    Show.deleteShow();
                    System.out.println("");
                    break;  
                case "7":
                    System.out.println("");
                    Report.listClients();
                    System.out.println("");
                    break;  
                case "8":
                    System.out.println("");
                    Report.listShowsInMonth();
                    System.out.println("");
                    break;  
                case "9":
                    System.out.println("\n\n\n\nThis program copyright © Kapoof Entertainment Inc. All rights reserved.\nShutting down...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nInvalid input: please enter a number between 1 and 9 to select a menu option.");
                    System.out.println("---------------\n\n");
                    break;
            }
        }
    }
}
