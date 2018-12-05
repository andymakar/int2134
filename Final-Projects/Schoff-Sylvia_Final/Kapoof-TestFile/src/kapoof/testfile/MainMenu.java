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
        Client[] listOfClients = new Client[10];
        Show[] listOfShows = new Show[10];
        System.out.println("___________________________________________\nPlease enter a selection:\n1) Add a client\n2) Update a client\n3) Delete a client\n4) Add a show\n5) Update a show\n6) Delete a show\n7) Report list of clients\n8) Report list of shows for the month\n9) Exit\n___________________________________________");
        int selection = input.nextInt();
        while (selection != 9){
            System.out.println("___________________________________________\nPlease enter a selection:\n1) Add a client\n2) Update a client\n3) Delete a client\n4) Add a show\n5) Update a show\n6) Delete a show\n7) Report list of clients\n8) Report list of shows for the month\n9) Exit\n___________________________________________");
            switch(selection){
                case 1: System.out.println("Please input the client's first name, last name, phone number, address and email; int that order: ");
                    listOfClients[listOfClients[0].getCount()] = new Client(input.next(), input.next(), input.next(), input.next(), input.next());
                    System.out.println(listOfClients[0].getCount());
                    break;
                case 2: System.out.println("Case 2");
                    break;
                case 3: System.out.println("Case 3");
                    break;
                case 4: System.out.println("Case 4");
                    break;
                case 5: System.out.println("Case 5");
                    break;
                case 6: System.out.println("Case 6");
                    break;
                case 7: System.out.println("Case 7");
                    break;
                case 8: System.out.println("Case 8");
                    break;
                case 9: System.out.println("Case 9");
                    break;
            }
            selection = input.nextInt();
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