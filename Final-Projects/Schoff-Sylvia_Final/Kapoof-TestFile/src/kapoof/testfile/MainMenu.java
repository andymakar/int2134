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
import java.io.*;
public class MainMenu {
    public static void main(String[] args) {
        System.lineSeparator();
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
                    System.out.println(listOfClients[countC - 1]);
                    countC++;
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
                            break;
                        }
                        else 
                            System.out.println("Email not found");
                    }
                    
                    break;
                case 3: System.out.println("Please enter the email address of the client you wish to remove from the system: ");
                    for(int i = 0; i < listOfClients.length; i++){
                        if(input.next().equals(listOfClients[i].getEmail())){
                            listOfClients[i] = listOfClients[i + 1];
                            while (i < listOfClients.length) {
                                i++;
                                listOfClients[i] = listOfClients[i + 1];
                            }
                        }
                    }
                    countC--;
                    break;
                case 4: System.out.println("Please enter the show's title, type (1 for Magic shows, 2 for Comedic shows, 3 for Rock Shows), date of the show,\nthe booking date of the show, the fee charged, the client's first name\nand the location of the show; in that order, separated by one blank space: ");
                    listOfShows[countS - 1] = new Show(input.next(), input.nextInt(), input.next(), input.next(), input.nextDouble(), input.next(), input.next());
                    System.out.println(listOfShows[countS - 1]);
                    countS++;
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
                    for(int i = 0; i < listOfShows.length; i++){
                        if(input.next().equals(listOfShows[i].getTitle())){
                            listOfShows[i] = listOfShows[i + 1];
                            while (i < listOfShows.length) {
                                i++;
                                listOfShows[i] = listOfShows[i + 1];
                            }
                        }
                    }
                    countS--;
                    break;
                case 7: System.out.println("The full Report of all clients can be found in a file called Client_Full_Report.txt.");
                    CreateFile fileC = new CreateFile();
                    fileC.openFile("Client_Full_Report.txt");
                    for(int i = 0; i < countC - 1; i++) {
                         fileC.addRecord(listOfClients[i]);   
                    }
                    fileC.closeFile();
                    break;
                case 8: System.out.println("The full Report of all the shows for the month can be found in a file called Show_Full_Report.txt."); 
                    CreateFile fileS = new CreateFile();
                    System.getProperty( "line.separator");
                    fileS.openFile("Show_Full_Report.txt");
                    for(int i = 0; i < countS - 1; i++) {
                        fileS.addRecord(listOfShows[i]);
                    }
                    fileS.closeFile();
                    break;
                case 9: System.out.println("Closing...");
                    System.exit(0);
                    break;
            }
            if (countS >= listOfShows.length) {
                Show[] replaceList = new Show[listOfShows.length * 2];
                System.arraycopy(listOfShows, 0, replaceList, 0, listOfShows.length);
                listOfShows = replaceList;
            }
            if (countC >= listOfClients.length) {
                Client[] replaceList = new Client[listOfClients.length * 2];
                System.arraycopy(listOfClients, 0, replaceList, 0, listOfClients.length);
                listOfClients = replaceList;
            }
        }
    }
}





//Please let me write to this file
class CreateFile {
    private Formatter x;
    public void openFile(String file) {
        try{
            x = new Formatter(file);
        } catch (Exception e) {
            System.out.println("You have an error");
        }
    }
    public void addRecord(Client type) {
        x.format("%-12s%n", type);
    }
    public void addRecord(Show type) {
        x.format("%-12s%n", type);
    }
    public void closeFile() {
        x.close();
    }
}