/* 
* Name: Peter Ebaugh, Dan Finn
* Class: INT2134
* Date: 12/04/17
* Description: Event management system that allows a user to add shows and clients,
* update them, delete them, or generate a report of the current shows or clients.
*/
import java.util.*;
import java.io.*;
public class FinalProjectFinishedVersion {
    public static void main(String[] Args) throws Exception {
        
        // Creates the client and show files by using FileWriter to avoid a "File not found" error.
        File file = new File("clientInfo.txt");
        File file2 = new File("ShowList.txt");
        try {
            FileWriter initializeWriter = new FileWriter(file);
            FileWriter initializeWriter2 = new FileWriter(file2);
    		}
    		catch (IOException e) {
    
				}
        
        // Create scanner
        Scanner input = new Scanner(System.in);
        
        int menuSelect;
        
        // Loops the menu until the user inputs 9 for exit
        do {
            
            // Display menu and prompt input
            System.out.println("Main Menu");
            System.out.println("1: Add a client");
            System.out.println("2: Update a client");
            System.out.println("3: Delete a client");
            System.out.println("4: Add a show");
            System.out.println("5: Delete a show");
            System.out.println("6: Update a show");
            System.out.println("7: Report: List of Clients");
            System.out.println("8: Report: List of Shows");
            System.out.println("9: Exit");
            System.out.print("Enter a choice: ");
            while(!input.hasNextInt()) {
                input.next();
                System.out.print("Error: enter only numeric values: ");
            }
            menuSelect = input.nextInt();
            input.nextLine();
            
            // Switch statement to process menu selection
                switch (menuSelect) {
                   
                    // add client
                    case 1: // create regex string that specifies only numbers
                            String regex = "[0-9]+";
                            String phone;
                            System.out.println("\nEnter the new client's info");
                            System.out.print("First name: ");
                            String firstName = input.next();
                            input.nextLine();
                            System.out.print("Last name: ");
                            String lastName = input.next();
                            input.nextLine();
                            
                            // Filters phone inputs by using the regex string
                            do {
                            System.out.print("Phone number (no dashes or spaces): ");
                            phone = input.nextLine();
                            if (!phone.matches(regex)) {
                                System.out.println("Error: Phone number must only contain numbers.");
                            }
                            } while (!phone.matches(regex));
                            System.out.print("Email address: ");
                            String Eaddress = input.next();
                            
                            // Create instance of Clients class and add the client
                            Clients client = new Clients(firstName, lastName, phone, Eaddress);
                            client.addClient();
                            break;
                    
                    // update client    
                    case 2: Clients clients4 = new Clients();
                            System.out.print("Enter the email address or phone # of the client you wish to update: ");
                            String updateID = input.next();
                            
                            // returns true if update was successful
                            boolean updateSuccessful = clients4.updateClient(updateID);
                            if (updateSuccessful) {
                                System.out.println("Update successful");
                            }
                            
                            break;
                            
                              
                    // delete client    
                    case 3: Clients client3 = new Clients();
                            System.out.print("Enter the email address or phone # of the client you wish to delete: ");
                            String deleteID = input.next();
                            boolean successful = client3.deleteClient(deleteID);
                            
                            // Returns true is deletion was successful
                            if (successful) {
                                System.out.println("Successfully deleted.");
                            }
                            else {
                                System.out.println("Unsuccessful");
                            }
                            break;
                        
                    // add a show        
                    case 4: 
                        // Declare variables that are used inside loops and switches
                        String type = "";
                        int choice = 0;
                        boolean formatCheck = false;
                        String Pdate = "";
                        String Bdate = "";
                        System.out.print("Show title (format: sample_text): ");
                        String title = input.next();
                        input.nextLine();
                        
                        // Force user to only input numbers 1-3
                        boolean bError = true;
                        while (bError || choice != 1 && choice != 2 && choice != 3) {
                            System.out.print("\nMagic \t(1)\nComedy \t(2)\nBand \t(3) \nEnter a type number: ");
                            if (input.hasNextInt()) {
                            choice = input.nextInt();
                            }
                            else {
                                input.next();
                                continue;
                            }
                            bError = false;
                            
                        } 
                        
                        // Assign show type
                        switch (choice) {
                            case 1:
                                type = "Magic";
                                break;
                            case 2: 
                                type = "Comedy";
                                break;
                            case 3:
                                type = "Band";
                                break;
                            default:
                            		System.out.println("Error");
                        }
                        
                        // Force user to use the specified format for booking date and performance date
                        do {
                        System.out.print("Performance Date (MM/DD/YYYY): ");
                        Pdate = input.next();
                        //Pattern p = Pattern.compile("\");
                        formatCheck = Pdate.matches("\\d{2}/\\d{2}/\\d{4}");
                        } while (formatCheck == false);
                        //input.nextLine();
                        formatCheck = false;
                        do {
                        System.out.print("Booking Date (MM/DD/YYYY): ");
                        Bdate = input.next();
                        formatCheck = Pdate.matches("\\d{2}/\\d{2}/\\d{4}");
                        } while (!formatCheck);
                        System.out.print("Fee: ");
                        
                        boolean feeError = true;
                        double fee = 0;
                        
                        // Force user input to be only a double type
                        while (feeError) {
                            
                                if (input.hasNextDouble()) {
                                fee = input.nextDouble();
                            }
                            else {
                                input.next();
                                System.out.print("Error: enter a numeric value: ");
                                continue;
                            }
                            feeError = false;
                        }
                        System.out.print("Client last name: ");
                        String showClient = input.next();
                        //input.nextLine();
                        System.out.print("Street and Number (no spaces): ");
                        String address = input.next();
                        System.out.print("City: ");
                        String city = input.next();
                        System.out.print("State: ");
                        String state = input.next();
                        System.out.print("Zip: ");
                        String zip = input.next();
                        
                        Show show1 = new Show(title, type, Pdate, Bdate, showClient, address, city, state, fee, zip);
                        show1.addShow();
                        break;
                    
                    // delete a show
                    case 5:
                        Show show2 = new Show();
                        show2.deleteShow();
                        break;
                        
                    // update a show    
                    case 6:
                        Show show3 = new Show();
                        show3.updateShow();
                        break;
                        
                    case 7: System.out.println("List of all clients\n-------------------\n");
                            
                            // create instance of Clients for displaying client list
                            Clients client4 = new Clients();
                            client4.ClientList();
                            break;
                            
                    case 8:
                    		Show show4 = new Show();
                        show4.showReport();
                        break;
                        
                    case 9:
                    		System.out.println("Logging off...");
                        break;
                        
                    default:
                    		System.out.println("Error: Enter a valid number");
                        break;
                }
            
        } while (menuSelect != 9);
        
        
    }

    
    
}


class Clients {
    
    // Delcare class variables
    File file = new File("clientInfo.txt");
    String firstName;
    String lastName;
    String phone;
    String address;
    
    // No-arg constructor
    Clients() {
        firstName = "";
        lastName = "";
        phone = "";
        address = "";
    }
    
    // Constructor for adding a client
    Clients(String firstName, String lastName, String phone, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }
    
    public void addClient() throws Exception {
        boolean foundLine = false;
        try (Scanner read = new Scanner(file)){
            
            // Read through the whole file to check for matching email or phone
            int arrayMatchLine = -1;
            int lineNum = 0;
            while (read.hasNextLine()) {
                String line = read.nextLine();
                lineNum++;
                
                if ((line.toLowerCase().contains(phone.toLowerCase())) || (line.toLowerCase().contains(address.toLowerCase()))) {
                    arrayMatchLine = lineNum;
                }
            }
            
            // Read file into array
            Scanner arrayRead = new Scanner(file);
            String[][] array = new String[lineNum][4];
            
            for (int row = 0; row < array.length; row++) {
                for (int column = 0; column < array[row].length; column++) {
                    if (arrayRead.hasNextLine())
                    array[row][column] = arrayRead.next();
                }
            }
        
        
            // specifically check the email and phone indexes for an exact match
            if(arrayMatchLine != -1) {
                if (phone.matches(array[arrayMatchLine - 1][2]) || phone.matches(array[arrayMatchLine - 1][3])) {
                    
                    foundLine = true;
                }
            }
        }
        
        // Write the client info to file if the email and phone are unique from the existing file content
        if (foundLine == false) {
            
            try (FileWriter output = new FileWriter(file, true)) {
                output.write(firstName + " ");
                output.write(lastName + " ");
                output.write(phone + " ");
                output.write(address + " ");
                // new line
                output.write(System.getProperty("line.separator"));
            }
        }
        // Prints error if the email or phone to add is not unique
        else {
            System.out.println("Error: A client with that address or phone # already exists.");
        }
        
    
    }
    
    public boolean updateClient(String id) {
        
        // create scanner
        Scanner input = new Scanner(System.in);
        
        
        
        int arrayUpdateLine = -1;
        //String lineToUpdate = "|"; *for testing purposes*
        boolean foundLine = false;
        try {
                 
            // Tests each line for a match
            Scanner read = new Scanner(file);
            int lineNum = 0;
            while (read.hasNextLine()) {
                String line = read.nextLine();
                lineNum++;
                if (line.toLowerCase().contains(id.toLowerCase())) {
                    //lineToUpdate = line; *for testing purposes*
                    foundLine = true;
                    arrayUpdateLine = lineNum;
                }
            }
            
            
            // Reads in current file contents into array
            Scanner arrayRead = new Scanner(file);
            String[][] array = new String[lineNum][4];
            
            for (int row = 0; row < array.length; row++) {
                for (int column = 0; column < array[row].length; column++) {
                    if (arrayRead.hasNextLine())
                    array[row][column] = arrayRead.next();
                }
            }
            
            
            // Checks if input matches the email or phone slots
            if(arrayUpdateLine != -1) {
                if (id.matches(array[arrayUpdateLine - 1][2]) || id.matches(array[arrayUpdateLine - 1][3])) {
                
                }
                else {
                foundLine = false;
                System.out.println("Error: The exact email or phone# must be entered.");
                }
                
            }
            else {
                System.out.println("Error: Please enter the client's phone # or email.");
                foundLine = false;
            }
            
            
            // Proceed if the unique identifier (phone/email) is correct
            if (foundLine) {
                
                int selection;
        
                // Loop menu for updating client info
                do {
                    System.out.println("\n1. First Name");
                    System.out.println("2. Last Name");
                    System.out.println("3. Phone Number");
                    System.out.println("4. Email Address");
                    System.out.print("Enter a number to select which client info you wish to update: ");
                    selection = input.nextInt();
                    } while (selection != 1 && selection != 2 && selection != 3 && selection != 4);
                
                // Print current info and prompt new info
                System.out.println("The current info: " + array[arrayUpdateLine - 1][selection - 1]);
                System.out.print("Enter the new info: ");
                String newClientInfo = input.next();
                
                // Replace old info with new info
                array[arrayUpdateLine - 1][selection - 1] = newClientInfo;

                // Write the updated array back to the file
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                for (int row = 0; row < array.length; row++) {
                    for (int column = 0; column < array[row].length; column++) {
                        writer.write(array[row][column] + " ");
                    }
                    writer.newLine();
                   
                }
                writer.flush();
                
            }
            
        }
            
        catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
        catch (IOException e) {
            System.out.println("Error: IO Exception");
        }
     
        return foundLine;
    }

    
    public boolean deleteClient(String id) {
        //String lineToDelete = "|"; *for code testing*
        
        // line number of client to remove
        int arrayDeleteLine = -1;
        
        boolean foundLine = false;
        
        try {
            
            // Tests each line for a match
            Scanner read = new Scanner(file);
            int lineNum = 0;
            while (read.hasNextLine()) {
                String line = read.nextLine();
                lineNum++;
                if (line.toLowerCase().contains(id.toLowerCase())) {
                    //lineToDelete = line; *for code testing*
                    foundLine = true;
                    arrayDeleteLine = lineNum;
                }
            }
            
            // temporary test output
            //System.out.println(lineNum + " " + arrayDeleteLine);
            
            // Reads in current file contents into array
            Scanner arrayRead = new Scanner(file);
            String[][] array = new String[lineNum][4];
            
            for (int row = 0; row < array.length; row++) {
                for (int column = 0; column < array[row].length; column++) {
                    if (arrayRead.hasNextLine())
                    array[row][column] = arrayRead.next();
                }
            }
            
            
            // Checks if input matches the email or phone slots
            if(arrayDeleteLine != -1) {
                //System.out.println("\n" + array[arrayDeleteLine - 1][2] + " " + array[arrayDeleteLine - 1][3]); *for code testing*
                if (id.matches(array[arrayDeleteLine - 1][2]) || id.matches(array[arrayDeleteLine - 1][3])) {
                
                }
                else {
                foundLine = false;
                System.out.println("Error: The exact email or phone# must be entered.");
                }
                
            }
            else {
                System.out.println("Error: Please enter the client's phone # or email.");
                foundLine = false;
            }
            
            if (foundLine) {
                
                String[][] newArray = new String[lineNum][4];
                
                // Copy array into newArray and offset the row if the line to delete is the current line
                int offsetCounter = 0;
                for (int row = 0; row < array.length; row++) {
                    
                    for (int column = 0; column < array[row].length; column++) {
                    if (arrayDeleteLine != row + 1) {
                        newArray[offsetCounter][column] = array[row][column];
                        }
                    
                    
                    
                    }
                    if (arrayDeleteLine != row + 1) {
                    offsetCounter++;
                    }
                }
                
                // Prints the new array *for code testing*
                /*System.out.println("\n");
                for (int row = 0; row < newArray.length; row++) {
                    for (int column = 0; column < newArray[row].length; column++) {
                if (column == 3) {
                    System.out.println(newArray[row][column]);
                    }
                else 
                System.out.print(newArray[row][column] + " ");
                    }
                }*/
                
                // Writes new array back to file
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                for (int row = 0; row < newArray.length - 1; row++) {
                    for (int column = 0; column < newArray[row].length; column++) {
                        writer.write(newArray[row][column] + " ");
                    }
                    writer.newLine();
                   
                }
                writer.flush();
                
                
           
            }
            
            else {
                System.out.println("Error: Client not found.");
            }
        }
        catch (FileNotFoundException e) {
            System.out.print("Error: File not found.");
        }
        catch (IOException e) {
            System.out.print("Error: IO Exception");
        }
        
        
       return foundLine; 
    }
    
    
    public void ClientList() {
        
        try {
            Scanner read = new Scanner(file);
            int lineNum = 0;
            
            // Get the number of lines in the file
            while (read.hasNextLine()) {
                String line = read.nextLine();
                lineNum++;
            }
            
            // Reads in current file contents into array
            Scanner arrayRead = new Scanner(file);
            String[][] array = new String[lineNum][4];
            
            for (int row = 0; row < array.length; row++) {
                for (int column = 0; column < array[row].length; column++) {
                    if (arrayRead.hasNextLine())
                    array[row][column] = arrayRead.next();
                }
            }
            
            // Prints the current file content from array and formats them
            for (int row = 0; row < array.length; row++) {
                for (int column = 0; column < array[row].length; column++) {
                if (column == 3) {
                    System.out.println(array[row][column]);
                    }
                else if (column == 2) {
                    System.out.print("\t|| " + array[row][column] + " ");
                }
                else 
                System.out.print(array[row][column] + " ");
                }
            }
            System.out.println("\n" + lineNum + " clients total.\n-------------------\t");
            
            // generate current date
            Date date = new Date();
            System.out.println("Report Date: " + date + "\n"); //2016/11/16 12:08:43
        }
        
        catch (FileNotFoundException e) {
            System.out.print("Error: File not found.");
        }
    }
    
}

class Show {
    File file = new File("ShowList.txt");
    String title, type, Pdate, Bdate, client, address, city, state, zip;
    double fee;
    
    //no-arg constructor
    Show() {
        title = "";
        type = "";
        Pdate = "";
        Bdate = "";
        client = "";
        address = "";
        city = "";
        state = "";
        fee = 0;
        zip = "";
    }
    
    //add show constructor
    Show(String title, String type, String Pdate, String Bdate, String client, String address, String city, String state, double fee, String zip) {
        this.title = title;
        this.type = type;
        this.Pdate = Pdate;
        this.Bdate = Bdate;
        this.client = client;
        this.address = address;
        this.city = city;
        this.state = state;
        this.fee = fee;
        this.zip = zip;
    } 
    
    
    public void addShow() throws Exception {
        boolean foundLine = false;
        Scanner input = new Scanner(System.in);
        String choice = "";
        try (Scanner read = new Scanner(file)){
            String checkLine = (title + " " + type + " " + Pdate + " " + Bdate + " " + fee + " " + client + " " + address + " " + city + " " + state + " " + zip);
            // Read through the whole file to check for an exact match
            while (read.hasNextLine()) {
                String line = read.nextLine();
                
                if ((line.toLowerCase().contains(checkLine.toLowerCase()))) {
                    foundLine = true;
                }
            }
        }
        
        if (foundLine == false){
            
            // write data to file
            try (FileWriter output = new FileWriter(file, true)) {
                output.write(title + " ");
                output.write(type + " ");
                output.write(Pdate + " ");
                output.write(Bdate + " ");
                output.write(fee + " ");
                output.write(client + " ");
                output.write(address + " ");
                output.write(city + " ");
                output.write(state + " ");
                output.write(zip + " ");
                // new line
                output.write(System.getProperty("line.separator"));
            }
        }
        else {
            
            // Prompt user for duplicate entry confirmation
            do {
            System.out.println("That show already exists, would you like to add anyway? (Y/N)");
            choice = input.nextLine();
            if (choice.toLowerCase() != "y" || choice.toLowerCase() != "n") {
                System.out.println("Please enter Y or N");
            }
          } while (choice.toLowerCase() != "y" || choice.toLowerCase() != "n");
        }
    }
    
    public void updateShow() {
        
        int arrayUpdateLine = -1;
        int choice = 0;
        boolean validNumber = false;
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Select a show to update:");
            // gets the number of rows in file
            Scanner read = new Scanner(file);
            int lineNum = 0;
            while (read.hasNextLine()) {
                String line = read.nextLine();
                lineNum++;
            }
        
            // Read in current file contents to array
            Scanner arrayRead = new Scanner(file);
            String[][] array = new String[lineNum][10];
            
            for (int row = 0; row < array.length; row++) {
                for (int column = 0; column < array[row].length; column++) {
                    if (arrayRead.hasNextLine())
                    array[row][column] = arrayRead.next();
                }
            }
            
            // Prints the current file content from array
            for (int row = 0; row < array.length; row++) {
                System.out.print((row + 1) + ". ");
                for (int column = 0; column < array[row].length; column++) {
                if (column == 9) {
                    System.out.println(array[row][column]);
                    }
                else 
                System.out.print(array[row][column] + " ");
                }
            }
            
            // Prompt user to specify show to update and validate the user's input
            do {
            System.out.print("Enter a show number to update (0 to exit): ");
            choice = input.nextInt();
            if (choice > lineNum || choice < 0) {
                System.out.println("Invalid show number");
            }
            else if (choice == 0) {
                return;
            }
            else {
                validNumber = true;
                }
            } while (validNumber == false);
            
            arrayUpdateLine = choice;
            int selection = 0;
            
            // Menu loop to print update options
            do {
                System.out.println("\n1. Show Title");
                System.out.println("2. Show Type");
                System.out.println("3. Performance Date");
                System.out.println("4. Booking Date");
                System.out.println("5. Fee");
                System.out.println("6. Client");
                System.out.println("7. Performance Address");
                System.out.print("Enter a number to select which show info you wish to update: ");
                selection = input.nextInt();
                } while (selection != 1 && selection != 2 && selection != 3 && selection != 4 && selection != 5 && selection != 6
                    && selection != 7);
                
            // Switch cases for each menu selection
            switch (selection) {
                
                // Update title
                case 1:
                    System.out.println("The current info: " + array[arrayUpdateLine - 1][selection - 1]);
                    System.out.print("Enter the new info: ");
                    title = input.next();
                    array[arrayUpdateLine - 1][selection - 1] = title;
                    break;
                        
                 // Update Show type   
                case 2:
                    int typeChoice = 0;
                    type = "";
                    System.out.println("The current type: " + array[arrayUpdateLine - 1][selection - 1]);
                    System.out.println("Enter the new type: ");

                    while (typeChoice != 1 && typeChoice != 2 && typeChoice != 3) {
                                System.out.print("\nMagic \t(1)\nComedy \t(2)\nBand \t(3) \nEnter a type number: ");
                                typeChoice = input.nextInt();

                    } 

                    switch (typeChoice) {
                        case 1:
                            type = "Magic";
                            break;
                        case 2: 
                            type = "Comedy";
                            break;
                        case 3:
                            type = "Band";
                            break;
                        default:
                        		System.out.println("Enter a number 1-3");
                            break;
                    }
                    
                    array[arrayUpdateLine - 1][selection - 1] = type;
                    break;
                   
                // Update performance date
                case 3:
                    System.out.println("The current performance date: " + array[arrayUpdateLine - 1][selection - 1]);
                    boolean formatCheck;
                    do {
                        System.out.print("Enter new Performance Date (MM/DD/YYYY): ");
                        Pdate = input.next();
                        //Pattern p = Pattern.compile("\");
                        formatCheck = Pdate.matches("\\d{2}/\\d{2}/\\d{4}");
                        } while (formatCheck == false);
                    
                    array[arrayUpdateLine - 1][selection - 1] = Pdate;
                    break;
                   
                // Update booking date    
                case 4:   
                    System.out.println("The current Booking Date: " + array[arrayUpdateLine - 1][selection - 1]);
                    do {
                        System.out.print(" Enter new Booking Date (MM/DD/YYYY): ");
                        Bdate = input.next();
                        //Pattern p = Pattern.compile("\");
                        formatCheck = Bdate.matches("\\d{2}/\\d{2}/\\d{4}");
                        } while (formatCheck == false);
                    
                    array[arrayUpdateLine - 1][selection - 1] = Bdate;
                    break;
                  
                // Update fee    
                case 5:
                    System.out.println("The current fee: " + array[arrayUpdateLine - 1][selection - 1]);
                    System.out.print("Enter the new fee: ");
                    fee = input.nextDouble();
                    String stringFee = ("" + fee);
                    
                    array[arrayUpdateLine - 1][selection - 1] = stringFee;
                    break;
                  
                // Update show client    
                case 6:    
                    System.out.println("The current show client: " + array[arrayUpdateLine - 1][selection - 1]);
                    System.out.print("Enter a new client");
                    client = input.next();
                    
                    array[arrayUpdateLine - 1][selection - 1] = client;
                    break;
            
                // Update address    
                case 7:
                    System.out.println("The current address: " + array[arrayUpdateLine - 1][6] + " " + array[arrayUpdateLine - 1][7] +
                            " " + array[arrayUpdateLine - 1][8] + " " + array[arrayUpdateLine - 1][9]);

                    System.out.println("Enter the new address info.\n");
                    System.out.print("Street and Number (format: NUMBER_STREET_STREET): ");
                    this.address = input.next();
                    System.out.print("City: ");
                    this.city = input.next();
                    System.out.print("State: ");
                    this.state = input.next();
                    System.out.print("Zip: ");
                    this.zip = input.next();
                    String stringZip = ("" + this.zip);

                    array[arrayUpdateLine - 1][6] = this.address;
                    array[arrayUpdateLine - 1][7] = this.city;
                    array[arrayUpdateLine - 1][8] = this.state;
                    array[arrayUpdateLine - 1][9] = stringZip;
                    
                    break;
                
                default:
                		System.out.println("Error");
                    break;
            }
              
            // Write new array contents back to file
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                for (int row = 0; row < array.length; row++) {
                    for (int column = 0; column < array[row].length; column++) {
                        writer.write(array[row][column] + " ");
                    }
                    writer.newLine();
                   
                }
                writer.flush();
                
            
        }
        
        catch (FileNotFoundException e){
            System.out.println("Error: File not found...");
        }
        catch (IOException e) {
            System.out.println("Error: IO Exception");
        }
        catch (InputMismatchException e) {
            System.out.println("Error: Incorrect input type");
        }
        
    }
    
    public void deleteShow() throws IOException, FileNotFoundException {
        int arrayDeleteLine = -1, choice = 0;
        Scanner input = new Scanner (System.in);
        boolean validNumber = false;
        
        try {
            System.out.println("Select a show to delete:");
            // gets the number of rows in file
            Scanner read = new Scanner(file);
            int lineNum = 0;
            
            // Get number of rows in file
            while (read.hasNextLine()) {
                String line = read.nextLine();
                lineNum++;
            }
        
            
            // Reads in the current file content to array
            Scanner arrayRead = new Scanner(file);
            String[][] array = new String[lineNum][10];
            
            for (int row = 0; row < array.length; row++) {
                for (int column = 0; column < array[row].length; column++) {
                    if (arrayRead.hasNextLine())
                    array[row][column] = arrayRead.next();
                }
            }
            
            // Prints the current file content from array
            for (int row = 0; row < array.length; row++) {
                System.out.print((row + 1) + ". ");
                for (int column = 0; column < array[row].length; column++) {
                if (column == 9) {
                    System.out.println(array[row][column]);
                    }
                else 
                System.out.print(array[row][column] + " ");
                }
            }
            
            // Prompt user choice and validate input
            do {
            System.out.print("Enter a show number to delete (0 to exit): ");
            choice = input.nextInt();
            if (choice > lineNum || choice < 0) {
                System.out.println("Invalid show number");
            }
            else if (choice == 0) {
                return;
            }
            else {
                validNumber = true;
                }
            } while (validNumber == false);
            
            
            arrayDeleteLine = choice;
            String[][] newArray = new String[lineNum][10];
                
                // copy array to new array and offset the row if the line to delete is the current line
                int offsetCounter = 0;
                for (int row = 0; row < array.length; row++) {
                    
                    for (int column = 0; column < array[row].length; column++) {
                    if (arrayDeleteLine != row + 1) {
                        newArray[offsetCounter][column] = array[row][column];
                        }
                    
                    }
                    if (arrayDeleteLine != row + 1) {
                    offsetCounter++;
                    }
                }
                
                // Prints the new array
                System.out.println("\n");
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                for (int row = 0; row < newArray.length - 1; row++) {
                    for (int column = 0; column < newArray[row].length; column++) {
                        writer.write(newArray[row][column] + " ");
                    }
                    writer.newLine();
                    
                }
                writer.flush();
                
        } 
        catch (FileNotFoundException e){
            System.out.println("Error: File not found...");
        }
        catch (IOException e) {
            System.out.println("Error: IO Exception");
        }
    }
    
    public void showReport() {
        Scanner input = new Scanner(System.in);
        int numberOfShows = 0;
        double feeSum = 0;
        
        try {
            Scanner read = new Scanner(file);
            int lineNum = 0;
            
            // Gets the number of rows in the file
            while (read.hasNextLine()) {
                String line = read.nextLine();
                lineNum++;
            }
        
            // Reads in the current file content to array
            Scanner arrayRead = new Scanner(file);
            String[][] array = new String[lineNum][10];
            
            for (int row = 0; row < array.length; row++) {
                for (int column = 0; column < array[row].length; column++) {
                    if (arrayRead.hasNextLine())
                    array[row][column] = arrayRead.next();
                }
            }
            
            //prompts user to enter month and year and prints header
            System.out.print("Enter the month for the report (MM): ");
            int month = input.nextInt();
            if (month > 12 || month <= 0) {
                System.out.print("Invalid month please try again.\nEnter the month for the report: ");
                month = input.nextInt();
            }
            System.out.print("Enter the year for the report (YYYY): ");
            int year = input.nextInt();
            if (year <= 0) {
                System.out.print("Invalid year please try again.\nEnter the year for the report: ");
                year = input.nextInt();
            }
            
            System.out.println("\n-------------------------");
            System.out.println("-\tShow Report\t-");
            System.out.println("-------------------------\n");
            
            //converts the dates in the array to integers and compares them to the inputed dates then prints the report
            for (int row = 0; row < array.length; row++) {
                int tempMonth = Integer.parseInt(array[row][2].substring(0, array[row][2].indexOf('/')));
                int tempYear = Integer.parseInt(array[row][2].substring(6,10));
                
                if (month == tempMonth && year == tempYear) {
                    System.out.println(array[row][0] + " " + array[row][5] + " " + array[row][1] + " " + array[row][2] + " " + array[row][4]);
                    numberOfShows++;
                    double tempFee = Double.parseDouble(array[row][4]);
                    feeSum += tempFee;
                }
            }
            System.out.println("Total Shows for Month: " + numberOfShows);
            System.out.println("Total Fees for Month: $" + feeSum);
            
            // generate current date
            Date date = new Date();
            System.out.println("Report Date: " + date + "\n"); //2016/11/16 12:08:43
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: File not found...");
        }
        catch (InputMismatchException e) {
            System.out.println("Error: Input Mismatch. Enter a number only");
        }
    }
}


