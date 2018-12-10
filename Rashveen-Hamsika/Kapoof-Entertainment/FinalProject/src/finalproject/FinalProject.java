/************************************************************************************
* Name: Rashveen, Hamsika
* Description: This is the main file that presents the menu to user to select an option
* Date: 12/9/2018
*************************************************************************************/
package finalproject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FinalProject {
  
  //function to addClient()
  public static void addClient() {
    ClientOperations clientOps = new ClientOperations();
    clientOps.addClient();
  }
  
  //function to updateClient
  public static void updateClient() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the email: ");
    String clientEmail = input.nextLine();
    ClientOperations clientOps = new ClientOperations();
    clientOps.updateClient(clientEmail);
  }
     
  //function to delete client
  public static void deleteClient() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the email: ");
    String clientEmail = input.nextLine();
    ClientOperations clientOps = new ClientOperations();
    clientOps.deleteClient(clientEmail);
  } 
  
  //Function to add show 
  public static void addShow() {
    ShowOperations showOps = new ShowOperations();
    showOps.addShow();
  }
     
  //Function to update Show 
  public static void updateShowId() {
    System.out.print("Enter your Show ID:");
    Scanner input = new Scanner(System.in);
    String showId = input.nextLine();
    ShowOperations showOps = new ShowOperations();
    showOps.updateShowById(showId);
  }
     
  //Function to delete a Show 
  public static void deleteShow() {
    System.out.print("Enter the show ID to be deleted:");
    Scanner input = new Scanner(System.in);
    String showNumber = input.nextLine();
    ShowOperations showOps = new ShowOperations();
    showOps.deleteShow(showNumber);
  }
   
  //Function to print Client Report 
  public static void getClientReport() {
    ClientOperations clientOps = new ClientOperations();
    clientOps.clientReport();
  }
  
  //Function to print Show Report 
  public static void getShowReport() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the month (mm): ");//add checks
    String month = input.nextLine();
    System.out.print("Enter the Year (YYYY): ");// add checks
    String year = input.nextLine();
    ShowOperations showOps = new ShowOperations();
    showOps.showReport(month, year);
  }
 
  //Function to print choice 
  public static int getChoice() {
    try{  
      int val = 0;
      Scanner input = new Scanner(System.in);
      System.out.println("1. Add Client");
      System.out.println("2. Update Client");
      System.out.println("3. Delete Client");
      System.out.println("4. Add a show");
      System.out.println("5. Delete a show");
      System.out.println("6. Update a show");
      System.out.println("7. Client Report");
      System.out.println("8. Show Report");
      System.out.println("9. Exit Menu");
      System.out.print("Enter choice:");
      val = input.nextInt();
      return val;
    } catch (InputMismatchException e) {
        System.out.println("Enter a valid choice");
        return 0;
      }
  }
  
  public static void main(String[] args) {
    int choice = 0;
    do {
      choice = getChoice();
      switch (choice) {
        case 1: addClient();
                break;
        case 2: updateClient();
                break;
        case 3: deleteClient();
                break;
        case 4: addShow();
                break;
        case 5: deleteShow();
                break;
        case 6: updateShowId();
                break;
        case 7: getClientReport();
                break;
        case 8: getShowReport();
                 break;
        case 9: break;
      }
    }while (choice!=9);
  }
}
    