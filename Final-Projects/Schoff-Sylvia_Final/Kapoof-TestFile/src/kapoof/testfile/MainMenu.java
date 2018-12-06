// Zachary Schoff
// 12 - 4 - 2018
// INT - 2134
// Main menu for the Kapoof Client and Show Manager
/*
 * Nathan S
 * Final project
 * Kapoof - Main
 * 12/4/2018
*/
package kapoof.testfile;
import java.util.*;
public class MainMenu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Client[] listOfClients = new Client[1];
        Show[] listOfShows = new Show[1];
        int countC = 1;
        int countS = 1;
        int selection = 0;
        while (selection < 10){
        System.out.println("___________________________________________\nPlease enter a selection:\n1) Add a client\n2) Update a client\n3) Delete a client\n4) Add a show\n5) Update a show\n6) Delete a show\n7) Report list of clients\n8) Report list of shows for the month\n9) Exit\n___________________________________________");
        selection = input.nextInt();
        switch(selection){
                case 1:  System.out.println("Please enter the client's first name, last name, phone number, address and email; in that order,\nseparated by one blank space: ");
                    listOfClients[countC - 1] = new Client(input.next(), input.next(), input.next(), input.next(), input.next());
                    System.out.println(listOfClients[countC]);
                    break;
                case 2: System.out.println("Please enter the client's current or former email address: ");
                    for(int i = 0; i < listOfClients.length; i++){
                        if(input.next().equals(listOfClients[i].getEmail())){
                            System.out.println("Please input the updated client's first name, last name, phone number, address and email; in that order,\nseparated by one blank space: ");
                            listOfClients[i].setFirstName(input.next());
                            listOfClients[i].setLastName(input.next());
                            listOfClients[i].setPhoneNumber(input.next());
                            listOfClients[i].setAddress(input.next());
                            listOfClients[i].setEmail(input.next());
                        }
                    }
                    
                    break;
                case 3: System.out.println("Please enter the email address of the client you wish to remove from the system: ");
                    for(int i = 0; i < listOfClients.length; i++){
                        if(input.next().equals(listOfClients[i].getEmail())){
                            
                        }
                    }
                    break;
                case 4: System.out.println("Please enter the show's title, type (1 for Magic shows, 2 for Comedic shows, 3 for Rock Shows), date of the show,\nthe booking date of the show, the fee charged, the client's first name\nand the location of the show; in that order, separated by one blank space: ");
                    listOfShows[countS - 1] = new Show(input.next(), input.nextInt(), input.next(), input.next(), input.nextDouble(), input.next(), input.next());
                    System.out.println(listOfShows[countS - 1]);
                    break;
                case 5: System.out.println("Please enter the title of the show you wish to update: ");
                    for(int i = 0; i < listOfShows.length; i++){
                        if(input.next().equals(listOfShows[i].getTitle())){
                            System.out.println("Please enter the updated title of the show, type (1 for Magic shows, 2 for Comedic shows, 3 for Rock Shows), date of the show,\nthe booking date of the show, the fee charged, the client's first name\nand the location of the show; in that order, separated by one blank space: ");
                            listOfShows[i].setTitle(input.next());
                            listOfShows[i].setType(input.nextInt());
                            listOfShows[i].setPerformanceDate(input.next());
                            listOfShows[i].setBookingDate(input.next());
                            listOfShows[i].setFee(input.nextDouble());
                            listOfShows[i].setClient(input.next());
                            listOfShows[i].setLocation(input.next());
                        }
                    }
                    break;
                case 6: System.out.println("Please enter the title of the show you wish to remove from the system: ");
                    
                    break;
                case 7: System.out.println("The full Report of all clients can be found in a file called .");
                    
                    break;
                case 8: System.out.println("The full Report of all the shows for the month can be found in a file called .");
                           
                    break;
                case 9: System.out.println("Closing...");
                    System.exit(0);
                    break;
            }
            if (listOfShows[0].getCount() >= listOfShows.length) {
            Show[] replaceList = new Show[listOfShows.length * 2];
            System.arraycopy(listOfShows, 0, replaceList, 0, listOfShows.length);
            listOfShows = replaceList;
            }
            if (listOfClients[0].getCount() >= listOfClients.length) {
                Client[] replaceList = new Client[listOfClients.length * 2];
                System.arraycopy(listOfClients, 0, replaceList, 0, listOfClients.length);
                listOfClients = replaceList;
            }
        }
    }
}