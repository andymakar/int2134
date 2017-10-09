/*
 * Auhtor: Andrew Makar
 * Description: This program prints a sample menu
 * Date: 10/8/17
 */
package samplemenu;

import java.util.Scanner;


public class SampleMenu {

    public static void main(String[] args) {
        

        //declare the input for menu choice
        Scanner input = new Scanner(System.in);
        char menuChoice;
               
        do {
            printMenu();// TODO code application logic here
            menuChoice = input.nextLine().charAt(0);
            menuChoice = Character.toUpperCase(menuChoice);
            
            switch (menuChoice){
                case 'A':
                printSomething("You selected option A");
                break;
                case 'B':
                printSomething("You selected Option B");
                break;
                case 'P':
                printSomething("You selected Option C");
                break;
                case 'Q':
                System.out.println("Exiting program.  Goodbye");
                break;
                default:
                System.out.println("Please select a valid choice");
				break;
            }
            
        } while (menuChoice != 'Q');
              
    }

    public static void printMenu() {
        System.out.println("\nWelcome to myMenu");
        System.out.println("-------------------");
        System.out.println("\nPlease select from the following options");
        System.out.println("(A) Option 1");
        System.out.println("(B) Option 2");
        System.out.println("(P) Option 3");
        System.out.println("(Q) Quit");
        System.out.print("\nPlease enter a selection: ");
    }
    
    public static void printSomething (String myText) {
    
        System.out.println(myText);
    }
}