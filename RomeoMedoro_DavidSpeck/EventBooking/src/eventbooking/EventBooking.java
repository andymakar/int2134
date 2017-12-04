/*
 * Romeo Medoro.
 * David Speck
 * Intro to Java
 * 11/25/2017
 * Event booking management app. Allows entertainment companies to easily add,
 * edit, and delete clients and events, and assign clients to events. 
 */
package eventbooking;
import java.util.*;
import java.io.*;
import java.text.*;

public class EventBooking {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Local variables. 
        int selection;
        // Create a list of Clients and one of Shows
        List<Show> shows = new ArrayList<Show>();
        List<Client> clients = new ArrayList<Client>();
        
        // create 20 new clients and add them to the list
       /* clients.add(new Client("John", "Smith", "(123)123-1234", "2121 S. Bend st. "
                + "Ann Arbor MI 48883", "jSmith@email.com"));
        clients.add(new Client("Steve", "Darsh", "(111)111-1111", "987 N. Spring rd. "
                + "South Park CO 79890", "sDarsh@email.com"));
        clients.add(new Client("Josh", "Setevens", "(732)222-2222", "1213 road st. "
                + "Detroit MI 48226", "jstevens@mail.com"));
        clients.add(new Client("Andrew", "Mahar", "(555)555-5555", "21000 w. 10 mile rd. "
                + "Southfield MI 48126", "amakar@ltu.edu"));
        clients.add(new Client("Mickey", "Mouse", "(321)123-1234", "1 Disney rd. "
                + "Awesome US 00000", "mmouse@email.com"));
        clients.add(new Client("Tony", "Soprano", "333-222-2222", "909 Mafia rd. "
                + "SomeCity MI 48883", "tSoprano@email.com"));
        clients.add(new Client("Johnny", "Bravo", "111-9675309", "87 Cartoon ntw. "
                + "Canton MI 48188", "jbravo@email.com"));
        clients.add(new Client("Jay", "Stanford", "777-777-7777", "12 awesome rd. "
                + "City CO 99233", "jStanford@email.com"));
        clients.add(new Client("El", "Eleven", "(555)555-5555", "1 upside down rd. "
                + "Upsidedown OH 11200", "eEleven@email.edu"));
        clients.add(new Client("John", "Wick", "(734)732-6308", "9999 youhurtmydog "
                + "KillYou US 00000", "jWick.com"));
        clients.add(new Client("Alex", "Baldwin", "999-000-0000", "4444 some street "
                + "Dearborn MI 48126", "aBaldwin@email.com"));
        clients.add(new Client("Tom", "Jones", "(989)999-8754", "1000 N. Spring rd. "
                + "South Park CO 79890", "tJones@mail.com"));
        clients.add(new Client("Oliver", "Test", "(732)222-8822", "1 international dr. "
                + "Dearborn MI 48126", "oTest@email.com"));
        clients.add(new Client("Dean", "Winchester", "999-121-1111", "120 Supernatural. "
                + "Plymouth MI 48170", "dWinchester@email.edu"));
        clients.add(new Client("Sam", "Winchester", "987-101-9900", "120 Supernatural. "
                + "Plymouth MI 48170", "sWinchester@email.com"));
        clients.add(new Client("Tony", "Sorrento", "333-222-2222", "1000 Mafia rd. "
                + "SomeCity MI 48883", "tSorrano@email.com"));
        clients.add(new Client("Barnie", "Stenson", "123-000-1111", "13 Legendary dr. "
                + "Lincoln NE 99999", "bStenson@email.com"));
        clients.add(new Client("Sandy", "Franklin", "765-890-7777", "9999 somewhere. "
                + "Boston MA 12321", "sFranklin@email.com"));
        clients.add(new Client("Christina", "Jeffries", "(212)888-9999", "1232 Old Bridge. "
                + "Canton MI 48188", "cJeffries@email.com"));
        clients.add(new Client("Romeo", "Medoro", "(734)732-6308", "1556 Old Bridge ct. "
                + "Canton MI 48188", "rmedoro@ltu.edu"));
        
        // Write all the clients in the list to .csv
        for (int i = 0; i < clients.size(); i++){
            Client temp = clients.get(i);
            temp.writeCSV();
        }
       
        // create 20 shows and add them to the list
        shows.add(new Show("Rock the halls", "Rock", "jSmith@email.com", "10/20/2017"
                , 200, "123 North Ave", "Southfield","MI", "48199"));
        shows.add(new Show("Laugh out loud", "Comedy", "sDarsh@email.com", "10/25/2017",
                150, "2100 Fourth st", "Ann Arbor", "MI", "48129"));
        shows.add(new Show("Magic Kingdom", "Magic", "jstevens@mail.com", "10/31/2017",
                275.79, "1911 ruger st", "Detroit", "MI", "48226"));
        shows.add(new Show("Enchantment", "Magic", "amakar@ltu.edu", "11/10/2017",
                500, "The Palace","Auburn Hills", "MI", "49001"));
        shows.add(new Show("Rock Fest", "Rock", "mmouse@email.com", "11/20/2017", 
                875.91, "Ford Field", "Detroit", "MI", "48126"));
        shows.add(new Show("Raw & Uncensored", "Comedy", "tSoprano@email.com", "11/25/2017",
                300, "1898 Laugh Ave", "SomeCity", "OH", "27293"));
        shows.add(new Show("Hall of Shame", "Comedy", "jbravo@email.com", "11/28/2017", 
                978.12, "87 Cartoon rd.", "Canton", "MI", "48188"));
        shows.add(new Show("Battling Magicians", "Magic", "jStanford@email.com", 
                "11/30/2017", 1000, "12 awesome rd.","City", "CO", "99233"));
        shows.add(new Show("Evil Rock", "Rock", "eEleven@email.edu", "11/30/2017",
                1008.99, "1833 Rock st.", "Vail City", "OH", "11200"));
        shows.add(new Show("The sound of Music", "Rock", "jWick.com", "12/01/2017",
                750.55, "9091 Ocean rd.", "New Boston","CT","55009"));
        shows.add(new Show("The Greatest Act", "Magic", "aBaldwin@email.com", "12/10/2017",
                764.98, "St. Andrew's", "Detroit", "MI", "48126"));
        shows.add(new Show("Try not to laugh", "Comedy", "tJones@mail.com", "12/15/2017",
                1343, "1000 N. Spring rd.","South Park", "CO", "79890"));
        shows.add(new Show("Holy Guitars", "Rock", "oTest@email.com", "12/20/2017",
                650, "7777 Tesla drive", "Dearborn", "MI", "48126"));
        shows.add(new Show("How Does He Do it", "Magic","dWinchester@email.edu", 
                "12/21/2017", 350, "1965 Shelby rd.", "Plymouth", "MI", "48170"));
        shows.add(new Show("King of Laughter", "Comedy", "sWinchester@email.com",
                "12/23/2017", 399.15, "1111 Try Me st.", "Plymouth", "MA", "19192"));
        shows.add(new Show("Stranger Things", "Rock", "tSorrano@email.com", "12/24/2017",
                1123,"6464 Rcky Road", "SomeCity", "FL", "22931"));
        shows.add(new Show("Santa's Magic Workshop", "Magic", "bStenson@email.com",
                "12/26/2017", 750, "454 Santa street", "Lincoln","NE","99999"));
        shows.add(new Show("Get Loud", "Rock", "sFranklin@email.com", "12/28/2017",
                1445, "898 Woodward Ave.", "Boston", "MA", "12321"));
        shows.add(new Show("Funny Elf", "Comedy", "cJeffries@email.com", "12/30/2017",
                1900, "4911 JavaLang st.", "San Francisco", "CA", "9009"));
        shows.add(new Show("New Year Bash", "Rock", "rmedoro@ltu.edu", "12/31/2017",
                2000, "Ford Field", "Detroit", "MI", "48226"));
        
        // Write all the clients in the list to .csv
        for (int i = 0; i < shows.size(); i++){
            Show temp = shows.get(i);
            temp.writeCSV();
        } */
        
        // Initiate the program's main menu.
        do{
            System.out.println("Kapoof Entertainment Event Booking System");
            System.out.println("-----------------------------------------------");
            System.out.println("1. Client Portal");
            System.out.println("2. Show Portal");
            System.out.println("3. Reports");
            System.out.println("4. Exit");
            System.out.print("\nEnter a selection: ");
            selection = input.nextInt();
            
            // Evaluate the selection and display the appropriate submenu.
            switch(selection){
                case 1:
                    clientPortal();
                    break;
                case 2: 
                    showPortal();
                    break;
                case 3:
                    reportPortal();
            }
        }while(selection != 4);
         
    }
    
    /* This is the client portal menu */
    public static void clientPortal(){
        Scanner input = new Scanner(System.in);
        // Holds the user's selection. 
        int selection;
        
        // Display the menu.
        do{
            System.out.println("CLIENT PORTAL");
            System.out.println("-----------------------------");
            System.out.println("1. Add Client");
            System.out.println("2. Update Client");
            System.out.println("3. Delete Client");
            System.out.println("4. Main Menu");
            System.out.print("\nEnter a selection: ");
            selection = input.nextInt();
            
            // Set the scanner onto the next line
            input.nextLine();
            
            // Evaluate the selection and perform the appropriate action. 
            switch(selection){
                case 1:
                    // variables used for the new client.
                    String firstName, 
                            lastName, 
                            street,
                            city,
                            state,
                            zip,
                            address,
                            phone, 
                            email;
                    // Get the new client info. 
                    System.out.print("First Name: ");
                    firstName = input.nextLine();
                    System.out.print("Last Name: ");
                    lastName = input.nextLine();
                    System.out.print("Street Address: ");
                    street = input.nextLine();
                    System.out.print("City: ");
                    city = input.nextLine();
                    System.out.print("State: ");
                    state = input.nextLine();
                    System.out.print("Zip: ");
                    zip = input.nextLine();
                    address = (street + " " + city + " " + state + " " + zip);
                    System.out.print("Phone Number: ");
                    phone = input.nextLine();
                    System.out.print("Email address: ");
                    email = input.nextLine();
                    
                    // Add the new client.
                    Client client = new Client(firstName, lastName, phone,
                            address, email);
                    // Push the client to the "db" file. 
                    client.addClient();
                    break;
                case 2:
                    // Valirables used to get and update client. 
                    Client clientToUpdate;
                    String clientEmail = "",
                            attributeToUpdate = "",
                            newValue;
                    int selectedValue;
                    
                    boolean flag = false;
                    do{
                        // Get the email address of the client we want to update.        
                        System.out.print("Enter the client's email address: ");
                        clientEmail = input.next();
                        // create an instace of our client object
                        clientToUpdate = Client.getClient(clientEmail);
                        if(clientToUpdate.getEmail() == null){
                            flag = false;
                            System.out.println("Invalid Client email");
                        }
                        else
                            flag = true;
                    }while(flag == false);
                    
                    // get the attribute we want to change and the new value.
                    System.out.println("What attribute would you like to change?");
                    System.out.println("1. Email Address");
                    System.out.println("2. First Name");
                    System.out.println("3. Last Name");
                    System.out.println("4. Address");
                    System.out.println("5. Phone Number");
                    System.out.println("0. Cancel");
                    System.out.print("Enter your selection: ");
                    
                    // Get the input.
                    selectedValue = input.nextInt();
                    
                    // Check the selection.
                    switch(selectedValue){
                        case 1:
                            attributeToUpdate = "Email";
                            break;
                        case 2:
                            attributeToUpdate = "First Name";
                            break;
                        case 3:
                            attributeToUpdate = "Last Name";
                            break;
                        case 4: 
                            attributeToUpdate = "Address";
                            break;
                        case 5:
                            attributeToUpdate = "Phone Number";
                            break;
                        case 0: 
                            break;
                    }
                    
                    System.out.print("Enter the new " + attributeToUpdate +": ");
                    input.nextLine();
                    newValue = input.nextLine();
                    
                    // call the update client method
                    clientToUpdate.updateClient(attributeToUpdate, newValue);
                    System.out.println("The client has been updated. ");
                    break;
                case 3:
                    System.out.print("Enter the email of the client you wish to"
                            + " delete: ");
                    clientEmail = input.next();
                    Client clientToDelete = Client.getClient(clientEmail);
                    clientToDelete.deleteClient();
            }
            
            
            
            
        }while(selection != 4);
    }
    
    /* Show submenu */
    public static void showPortal(){
        Scanner input = new Scanner(System.in);
        // Holds the user's selection
        int selection;
        
        // Display the menu
        do{
            System.out.println("SHOW PORTAL");
            System.out.println("-----------------------------");
            System.out.println("1. Add Show");
            System.out.println("2. Update Show");
            System.out.println("3. Delete Show");
            System.out.println("4. Exit");
            System.out.print("\nEnter a selection: ");
            selection = input.nextInt();
            
            //Move the scanner object on to the next line
            input.nextLine();
            
            //Check the user input and perform an action
            switch(selection){
                case 1:
                    //Variables used for the show object.
                    String title,
                            address,
                            city,
                            state,
                            zip,
                            performance,
                            email,
                            showType = null;
                    int type;
                    double fee;
                    Client client;
                    
                    // Prompt user for show info.
                    // Get the title of the show
                    System.out.print("\nShow Title: ");
                    title = input.nextLine();
                    // Get show type
                    System.out.println("\nWhat type of show is this?");
                    System.out.println("1. Magic");
                    System.out.println("2. Comedy");
                    System.out.println("3. Rock");
                    System.out.print("Enter your selection: ");
                    // get/validate user input
                    do{
                        type = input.nextInt();
                        
                        if (type < 1 || type > 3){
                            System.out.println("\nInvalid Entry!");
                            System.out.println("Enter your selection: ");
                        }
                    }while (type < 1 || type > 3);
                    
                    input.nextLine();
                    // assign show type.
                    switch(type){
                        case 1:
                            showType = "Magic";
                            break;
                        case 2: 
                            showType = "Comedy";
                            break;
                        case 3:
                            showType = "Rock";
                            break;
                    }
                    // Get perfromance date.
                    System.out.print("\nPerformance Date (ex- 'MM/dd/yyyy'): ");
                    performance = input.nextLine();
                    
                    // Ask for fee amount.
                    do{
                        System.out.print("Booking Fee: ");
                        fee = input.nextDouble();
                        
                        if (fee <= 0 ){
                            System.out.println("Fee must be greater than 0.");
                        }
                    }while (fee <= 0);
                    input.nextLine();
                    boolean flag = false;
                    do{
                        // Get the email address of the client we want to update.        
                        System.out.print("Enter the client's email address: ");
                        email = input.nextLine();
                        // create an instace of our client object
                        client = Client.getClient(email);
                        if(client.getEmail() == null){
                            flag = false;
                            System.out.println("Invalid Client email");
                        }
                        else
                            flag = true;
                    }while(flag == false);
                    
                    // Get the performance address. 
                    System.out.print("Performance address: ");
                    address = input.nextLine();
                    
                    // Get City, state, and zip
                    System.out.print("Performance City: ");
                    city = input.nextLine();
                    System.out.print("Performance State: ");
                    state = input.nextLine();
                    System.out.print("Performance Zip: ");
                    zip = input.nextLine();
                    
                    // create the show object
                    Show show = new Show(title, showType, email, performance, fee, 
                                address, city, state, zip);
                    
                    // push the changes to the file
                    show.addShow();
                    break;
                case 2:          
                    // Valirables used to get and update a show. 
                    Show showToUpdate;
                    String showTitle = "",
                            attributeToUpdate = "",
                            newValue;
                    int selectedValue;
                    
                    boolean exists = false;
                    do{
                        // Get the title of the show.        
                        System.out.print("Enter the title of the show you wish to "
                            + "update: ");
                        showTitle = input.nextLine();
                        // create an instace of our show object
                        showToUpdate = Show.getShow(showTitle);
                        if(showToUpdate.getTitle() == null){
                            exists = false;
                            System.out.println("\nInvalid show title");
                        }
                        else
                            exists = true;
                    }while(exists == false);
                    
                    // get the attribute we want to change and the new value.
                    System.out.println("\nWhat attribute would you like to change?");
                    System.out.println("1. Title");
                    System.out.println("2. Type");
                    System.out.println("3. Performance Date");
                    System.out.println("4. Fee");
                    System.out.println("5. Client");
                    System.out.println("6. Address");
                    System.out.println("7. City");
                    System.out.println("8. State");
                    System.out.println("9. Zip");
                    System.out.print("\nEnter your selection: ");
                    
                    // Get the input.
                    selectedValue = input.nextInt();
                    input.nextLine();
                    // Check the selection.
                    switch(selectedValue){
                        case 1:
                            attributeToUpdate = "Title";
                            break;
                        case 2:
                            attributeToUpdate = "Type";
                            System.out.println("The choices are Rock, Comedy and"
                                    + " Magic");
                            break;
                        case 3:
                            attributeToUpdate = "Performance Date";
                            System.out.println("***Date format = dd/MM/yyyy");
                            break;
                        case 4: 
                            attributeToUpdate = "Fee";
                            break;
                        case 5:
                            attributeToUpdate = "Client";
                            break;
                        case 6:
                            attributeToUpdate = "Address";
                            break;
                        case 7:
                            attributeToUpdate = "City";
                            break;
                        case 8:
                            attributeToUpdate = "State";
                            break;
                        case 9:
                            attributeToUpdate = "Zip";
                            break;
                    }
                    if (attributeToUpdate == "Client"){
                        System.out.print("Enter the new client's email address: ");
                        newValue = input.nextLine();
                    }
                    else{
                        System.out.print("Enter the new " + attributeToUpdate +": ");
                        newValue = input.nextLine();
                    }
                    
                    // call the update show method
                    showToUpdate.updateShow(attributeToUpdate, newValue);
                    System.out.println("The Show has been updated. ");
                    break;
                case 3:
                    System.out.print("Enter the title of the show you wish to"
                            + " delete: ");
                    showTitle = input.nextLine();
                    Show showToDelete = Show.getShow(showTitle);
                    showToDelete.deleteShow();
                    
            }
        }while(selection != 4);
        
    }
    
    /* Report Portal Method */
    public static void reportPortal(){
         Scanner input = new Scanner(System.in);
        // Holds the user's selection
        int selection;
        
        // Display the menu
        do{
            System.out.println("\nREPORT PORTAL");
            System.out.println("-----------------------------");
            System.out.println("1. Clients Report");
            System.out.println("2. Magic Show by Month");
            System.out.println("3. Main Menu");
            System.out.print("\nEnter a selection: ");
            selection = input.nextInt();
            
            //Move the scanner object on to the next line
            input.nextLine();
            // perform an action based on the user's selection. 
            switch(selection){
                case 1:
                    clientReport();
                    break;
                case 2:
                    int month,
                            year;
                    // prompt user for report date. 
                    System.out.print("Enter a month as a 2 digit integer "
                            + "(ex- January = 01): ");
                    month = input.nextInt();
                    System.out.print("Enter the year as a 4 digit year: ");
                    year = input.nextInt();
                    showReport(month, year);
                    break;
                default:
                    System.out.println("\nInvalid selection.");
                    break;
            }
        }while(selection != 3);
    }
    
    /* prints the formatted report */
    public static void clientReport(){
        // create a list of client objects
        List<Client> allClients = new ArrayList<Client>();
        // variable to hold total number of clients
        int totalClients = 0;
        // fill the list with the clients stored in the .csv
        allClients = Client.getClients();
        // print the header for the report
        System.out.println("--------------------------------------------------------------"
                + "---------------------");
        System.out.println("\nClient Listing \t\t" + new Date().toString());
        System.out.println("--------------------------------------------------------------"
                + "---------------------");
        System.out.println(String.format("%-15s", "First") + String.format("%-15s","Last") +
                String.format("%-15s","   Phone") + String.format("%-15s", "\t   Address"));
        System.out.println("---------------------------------------------------------------"
                + "--------------------");
        // Loop through our list of clients and print each client's info
        for (int i = 0; i < allClients.size(); i++){
            Client temp = allClients.get(i);
            String first = temp.getFirstName(),
                    last = temp.getLastName(),
                    phone = temp.getPhone(),
                    address = temp.getAddress();
            System.out.println(String.format("%-15s",first) + " " + String.format("%-15s",last)
                    + " " + String.format("%-18s",phone) + " " + String.format("%-30s",address));
            totalClients++;
        }
        System.out.println("-----------------------------------------------------------------"
                + "---------------------");
        System.out.println("Total Number of Clients: " + totalClients);
        System.out.println("------------------------------------------------------------------"
                + "---------------------");
    }
    
    /* Retruns a report of shows by date */
    public static void showReport(int month, int year){
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        
        // Holds a list of all the Shows in the system. 
        List<Show> allShows = new ArrayList <Show>();
        // Hold the number of shows 
        int totalShows = 0;
        double totalRevenue = 0;
        String reportYear = null,
                reportMonth = null;
        
        // convert our date strings into dates
        Date reportDate = null;
        Date performanceDate = null;
        
        System.out.println("----------------------------------------------------"
                + "----------------------------------------------------");
        System.out.println("Shows by Month \t\t" + new Date().toString());
        System.out.println("----------------------------------------------------"
                + "----------------------------------------------------");
        System.out.println(String.format("%-30s","Title") + String.format("%-22s", 
                "Client") + String.format("%-10s","Type") + String.format("%-15s", 
                        "Show Date") + String.format(
                                "%-15s", "Fee"));
        System.out.println("----------------------------------------------------"
                + "----------------------------------------------------");
        
        // Fill our list with show objects from the file
        allShows = Show.getShows();
        //Loop through the list of all the shows to match our dates
        for(int i = 0; i < allShows.size(); i++){
            // get the object at the current index.
            Show temp = allShows.get(i);
            // try to convert the string date to a Date object
            try{
                performanceDate = (Date)df.parse(temp.getPerformanceDate());
                reportYear = yearFormat.format(performanceDate);
                reportMonth = monthFormat.format(performanceDate);
            }
            catch(ParseException e){
                e.printStackTrace();
            }
            // check de date against our date range.
            if (reportMonth.equals(Integer.toString(month)) 
                    && reportYear.equals(Integer.toString(year))){
                String title = temp.getTitle(),
                        client = temp.getClientName(),
                        type = temp.getType(),
                        perfDate = temp.getPerformanceDate();
                double fee = temp.getFee();
                
                
                System.out.println(String.format("%-30s",title) + 
                        String.format("%-22s",client) + String.format("%-10s",type)
                        +  String.format("%-15s", perfDate) +  
                        String.format("%-15s", fee));
                totalShows++;
                totalRevenue += fee;
            }
        }
        System.out.println("----------------------------------------------------"
                + "----------------------------------------------------");
        System.out.println("Total Shows for time period: " + totalShows);
        System.out.println("Total money earned for time period: $" + totalRevenue);
        
    }
}


