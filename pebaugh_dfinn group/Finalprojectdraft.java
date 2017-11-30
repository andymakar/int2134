
/* 
* Name: Peter Ebaugh
* Class: INT2134
* Date: 10/09/17
* Description: 
*/
package finalproject2;
import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

public class Finalproject2 {
    public static void main(String[] Args) throws Exception {
        
        // Create scanner
        Scanner input = new Scanner(System.in);
        
        int menuSelect;
        
        // Loops the menu until the user inputs 5 for exit
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
            menuSelect = input.nextInt();
            
            // Switch statement to process menu selection
                switch (menuSelect) {
                   
                    // add client
                    case 1: System.out.println("\nEnter the new client's info");
                            System.out.print("First name: ");
                            String firstName = input.next();
                            System.out.print("Last name: ");
                            String lastName = input.next();
                            System.out.print("Phone number (no dashes or spaces): ");
                            String phone = input.next();
                            System.out.print("Email address: ");
                            String Eaddress = input.next();
                            
                            // Create instance of Clients class and add the client
                            Clients client = new Clients(firstName, lastName, phone, Eaddress);
                            client.addClient();
                            break;
                    
                    // update client    
                    case 2: 
                            
                              
                    // delete client    
                    case 3: Clients client3 = new Clients();
                            System.out.print("Enter the email address or phone # of the client you wish to delete: ");
                            String deleteID = input.next();
                            boolean successful = client3.deleteClient(deleteID);
                            if (successful) {
                                System.out.println("Successfully deleted.");
                            }
                            else {
                                System.out.println("Unsuccessful");
                            }
                            break;
                            
                    case 4: 
                        String type = "";
                        int choice = 0;
                        boolean formatCheck = false;
                        String Pdate = "", Bdate = "";
                        System.out.print("Show title (format: sample_text): ");
                        String title = input.next();
                        
                        while (choice != 1 && choice != 2 && choice != 3) {
                            System.out.print("\nMagic \t(1)\nComedy \t(2)\nBand \t(3) \nEnter a type number: ");
                            choice = input.nextInt();
                            
                        } 
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
                        }
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
                        double fee = input.nextDouble();
                        System.out.print("Client: ");
                        String showClient = input.next();
                        //input.nextLine();
                        System.out.print("Street and Number: ");
                        String address = input.next();
                        System.out.print("City: ");
                        String city = input.next();
                        System.out.print("State: ");
                        String state = input.next();
                        System.out.print("Zip: ");
                        int zip = input.nextInt();
                        
                        Show show1 = new Show(title, type, Pdate, Bdate, showClient, address, city, state, fee, zip);
                        show1.addShow();
                        break;
                    
                    case 5:
                        Show show2 = new Show();
                        show2.deleteShow();
                        break;
                    
                    case 7: System.out.println("List of all clients\n-------------------\n");
                            
                            // create instance of Clients for displaying client list
                            Clients client4 = new Clients();
                            client4.ClientList();
                            break;
                }
            
        } while (menuSelect != 9);
        
        
    }

    
    
}


class Clients {
    
    // Delcare class variables and create file
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
    
    void addClient() throws Exception {
        boolean foundLine = false;
        try (Scanner read = new Scanner(file)){
            
            // Read through the whole file to check for matching email or phone
            while (read.hasNextLine()) {
                String line = read.nextLine();
                
                if ((line.toLowerCase().contains(phone.toLowerCase())) || (line.toLowerCase().contains(address.toLowerCase()))) {
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
    
    boolean updateClient(String id, String newInfo) {
        
        String lineToUpdate = "|";
        boolean foundLine = false;
        try {
            Scanner read = new Scanner(file);
            int lineNum = 0;
            while (read.hasNextLine()) {
                String line = read.nextLine();
                lineNum++;
                if (line.toLowerCase().contains(id.toLowerCase())) {
                    lineToUpdate = line;
                    foundLine = true;
                    
                }
            }
            
            
            if (foundLine) {
                String s;
                BufferedReader reader = new BufferedReader(new FileReader(file));
                
                while ((s = reader.readLine()) != null) {
                    s.replaceAll(lineToUpdate, id);
                }
            
            }
            else {
            
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
    
    boolean deleteClient(String id) {
        java.io.File tempFile = new java.io.File("tempFile.txt");
        String lineToDelete = "|";
        
        // line number of client to remove
        int arrayDeleteLine = -1;
        
        boolean foundLine = false;
        boolean successful = false;
        
        
        try {
            
            // Tests each line for a match
            Scanner read = new Scanner(file);
            int lineNum = 0;
            while (read.hasNextLine()) {
                String line = read.nextLine();
                lineNum++;
                if (line.toLowerCase().contains(id.toLowerCase())) {
                    lineToDelete = line;
                    foundLine = true;
                    arrayDeleteLine = lineNum;
                }
            }
            
            // temporary test output
            System.out.println(lineNum + " " + arrayDeleteLine);
            
            
            Scanner arrayRead = new Scanner(file);
            String[][] array = new String[lineNum][4];
            
            for (int row = 0; row < array.length; row++) {
                for (int column = 0; column < array[row].length; column++) {
                    if (arrayRead.hasNextLine())
                    array[row][column] = arrayRead.next();
                }
            }
            
            // Prints the current file content from array
            for (int row = 0; row < array.length; row++) {
                for (int column = 0; column < array[row].length; column++) {
                if (column == 3) {
                    System.out.println(array[row][column]);
                    }
                else 
                System.out.print(array[row][column] + " ");
                }
            }
            
            // Checks if input matches the email or phone slots
            if(arrayDeleteLine != -1) {
                System.out.println("\n" + array[arrayDeleteLine - 1][2] + " " + array[arrayDeleteLine - 1][3]);
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
                
                //ArrayList<String> list = new ArrayList<>(Arrays.asList(array[arrayDeleteLine - 1]));
                //boolean skippedLine = false;
                String[][] newArray = new String[lineNum][4];
                
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
                for (int row = 0; row < newArray.length; row++) {
                    for (int column = 0; column < newArray[row].length; column++) {
                if (column == 3) {
                    System.out.println(newArray[row][column]);
                    }
                else 
                System.out.print(newArray[row][column] + " ");
                    }
                }
                
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                for (int row = 0; row < newArray.length - 1; row++) {
                    for (int column = 0; column < newArray[row].length; column++) {
                        writer.write(newArray[row][column] + " ");
                    }
                    writer.newLine();
                    /*output.write(newArray[row][0] + " ");
                    output.write(newArray[row][1] + " ");
                    output.write(newArray[row][2] + " ");
                    output.write(newArray[row][3] + " ");
                    output.write(System.getProperty("line.separator"));
                    */
                }
                writer.flush();
                
                
            /*
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            
            String currentLine;
            
            while ((currentLine = reader.readLine()) != null) {
                //trime newline when comparing with lineToDelete
                String trimmedLine = currentLine.trim();
                
                if (trimmedLine.equals(lineToDelete)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            successful = tempFile.renameTo(file);
            */
            }
            
            else {
                System.out.println("Error: Client not found.");
                successful = false;
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
    
    void ClientList() {
        
        try {
            Scanner read = new Scanner(file);
            int lineNum = 0;
            while (read.hasNextLine()) {
                String line = read.nextLine();
                lineNum++;
            }
            
            Scanner arrayRead = new Scanner(file);
            String[][] array = new String[lineNum][4];
            
            for (int row = 0; row < array.length; row++) {
                for (int column = 0; column < array[row].length; column++) {
                    if (arrayRead.hasNextLine())
                    array[row][column] = arrayRead.next();
                }
            }
            
            // Prints the current file content from array
            for (int row = 0; row < array.length; row++) {
                for (int column = 0; column < array[row].length; column++) {
                if (column == 3) {
                    System.out.println(array[row][column]);
                    }
                else 
                System.out.print(array[row][column] + " ");
                }
            }
            System.out.println("");
        }
        
        catch (FileNotFoundException e) {
            System.out.print("Error: File not found.");
        }
    }
    
}

class Show {
    File file = new File("ShowList.txt");
    String title, type, Pdate, Bdate, client, address, city, state;
    double fee;
    int zip;
    
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
        zip = 0;
    }
    
    //add show constructor
    Show(String title, String type, String Pdate, String Bdate, String client, String address, String city, String state, double fee, int zip) {
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
    
    
    void addShow() throws Exception {
        boolean foundLine = false;
        Scanner input = new Scanner(System.in);
        String choice = "";
        try (Scanner read = new Scanner(file)){
            String checkLine = (title + " " + type + " " + Pdate + " " + Bdate + " " + fee + " " + client + " " + address + " " + city + " " + state + " " + zip);
            // Read through the whole file to check for matching email or phone
            while (read.hasNextLine()) {
                String line = read.nextLine();
                
                if ((line.toLowerCase().contains(checkLine.toLowerCase()))) {
                    foundLine = true;
                }
            }
        }
        
        if (foundLine == false){
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
            do {
            System.out.println("That show already exists, would you like to add anyway? (Y/N)");
            choice = input.nextLine();
            if (choice.toLowerCase() != "y" || choice.toLowerCase() != "n") {
                System.out.println("Please enter Y or N");
            }
          } while (choice.toLowerCase() != "y" || choice.toLowerCase() != "n");
        }
    }
    
    void deleteShow() throws IOException, FileNotFoundException {
        int arrayDeleteLine = -1, choice = 0;
        Scanner input = new Scanner (System.in);
        boolean validNumber = false;
        
        try {
            System.out.println("Select a show to delete:");
            // gets the number of rows in file
            Scanner read = new Scanner(file);
            int lineNum = 0;
            while (read.hasNextLine()) {
                String line = read.nextLine();
                lineNum++;
            }
        
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
                /*for (int row = 0; row < newArray.length; row++) {
                    for (int column = 0; column < newArray[row].length; column++) {
                if (column == 9) {
                    System.out.println(newArray[row][column]);
                    }
                else 
                System.out.print(newArray[row][column] + " ");
                    }
                }*/
                
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
}

