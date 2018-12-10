import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
* Name: Adam Ktona, Tyler Magdich, Deshawn Studavent
* Description: Adds, modifies, or removes clients from the filesystem
*/
public class Client {
    File file = new File("client.txt");
    
    public static void addClient() throws FileNotFoundException, ParseException {
        Scanner input = new Scanner(System.in);
       
        // Invoke the displayHeader method
        Libraries.displayHeader("Add a Client");
 
        // Collects client name and address input. No error checking necessary
        System.out.print("Enter the clients first name: ");
        String firstName = input.nextLine();
        
        System.out.print("Enter the clients last name: ");
        String lastName = input.nextLine();
        
        System.out.print("Enter the clients phone number: ");
        String clientPhone = input.nextLine();
        
        System.out.print("Enter the clients email address: ");
        String clientEmail = input.nextLine();

          // Creates a File object named file (clients.txt)
        java.io.File file = new java.io.File("clients.txt");
        // If the file does not yet exist, create the file and append the .csv header to prepare it for the .csv format
        if (file.exists() == false) {
                try (PrintWriter csvprep = new PrintWriter(new FileOutputStream(new File("clients.txt"), false))) {
                    csvprep.println("client_first_name,client_last_name,client_phone_number,client_email");
                    csvprep.close();
                }
            }
        // Write each piece of information onto a new line of the file, separated by commas to keep .csv compatibility
        try (PrintWriter output = new PrintWriter(new FileOutputStream(new File("clients.txt"),true))) {
            output.print(firstName + ",");
            output.print(lastName + ",");
            output.print(clientPhone + ",");
            output.println(clientEmail + ",");
            
            output.close();
        }
        // Display confirmation message
        System.out.println("Successfully added " + firstName + " " + lastName + " to the list.");
      
    }
    
    public static void updateClient() throws IOException {
        Scanner input = new Scanner(System.in);
        Libraries.displayHeader("Update a Client");
        
        System.out.print("Enter the name of the client you want to replace: ");
        String oldClientTitle = input.nextLine();
        
        
        File file = new File("clients.txt");
        int memoryLineToUpdate = 0;
	boolean successfullyFoundLine = false;
                 
        Scanner searcher = new Scanner(file);
        int numberOfRows = 0;
        while (searcher.hasNextLine()) {
                String buffer = searcher.nextLine();
                numberOfRows++;
                if (buffer.contains(oldClientTitle)) {
                    successfullyFoundLine = true;
                    memoryLineToUpdate = numberOfRows;
                }
            }
            
        if (!successfullyFoundLine) {
            System.out.println("Error: The show name called \"" + oldClientTitle + "\" could not be found. Please try again.");
            return;
        }
        
        Scanner reader = new Scanner(file);
        reader.useDelimiter(",");
        String[][] memory = new String[numberOfRows][4];
        
        //System.out.println("Number of rows: " + numberOfRows);
        //System.out.println("Row to update: " + memoryLineToUpdate);
            
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < 4; column++) {
                if (reader.hasNextLine()) {
                    memory[row][column] = reader.next();
                }
            }
        }
        
        // Testing purposes
        /*
        for (int row = 0; row < memory.length; row++) {
            for (int column = 0; column < memory[row].length; column++) {
                if (reader.hasNextLine()) {
                    System.out.println(memory[row][column]);
                }
            }
        }
        */
        
        DateFormat df = new SimpleDateFormat("M d y");
        DateFormat dfprint = new SimpleDateFormat("M/d/y");
        DateFormat m = new SimpleDateFormat("M");
        DateFormat d = new SimpleDateFormat("d");
        DateFormat y = new SimpleDateFormat("y");
        
        Scanner update = new Scanner(System.in);
        boolean continueInput = true;
        String newValue = null;
        do {
            try {
                System.out.print("Choose which you would like to edit: \n1: First Name\n2: Last Name\n3: Phone Number\n4: Email Address\n\n");
                int clientType = input.nextInt();
                switch (clientType) {
                    case 1:
                        System.out.println("Old value: " + memory[memoryLineToUpdate - 1][0] + "\n");
                        System.out.print("New value: ");
                        memory[memoryLineToUpdate - 1][0] = update.nextLine();
                        continueInput = false;
                        break;
                    case 2:
                        System.out.println("Old value: " + memory[memoryLineToUpdate - 1][1] + "\n");
                        System.out.print("New value: ");
                        memory[memoryLineToUpdate - 1][1] = update.nextLine();
                        continueInput = false;
                        break;
                    case 3:
                        System.out.println("Old value: " + memory[memoryLineToUpdate - 1][2] + "\n");
                        System.out.print("New value: ");
                        memory[memoryLineToUpdate - 1][2] = update.nextLine();
                        continueInput = false;
                        break;
                    case 4:
                        System.out.println("Old value: " + memory[memoryLineToUpdate - 1][3] + "\n");
                        System.out.print("New value: ");
                        memory[memoryLineToUpdate - 1][3] = update.nextLine();
                        continueInput = false;
                        break;
                    default:
                        System.out.print("Please enter a number between 1 and 4.\n");
                }
            }
            // If user enters in anything but an int, catch the error, display an error message, and kick them back to the start of the loop
            catch (InputMismatchException ex) {
                System.out.print("Please enter a number between 1 and 4.\n");
                input.nextLine();
            }
        } while (continueInput);
        // Clear the buffer and advance the carriage to the next line to avoid input errors
        input.nextLine();
        
        BufferedWriter updater = new BufferedWriter(new FileWriter(file));
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < 4; column++) {
                updater.write(memory[row][column] + ",");
            }
            //updater.newLine();
        }
	updater.newLine();
        updater.flush();
    }
    
    public static void deleteClient() throws FileNotFoundException, IOException {
        Scanner input = new Scanner(System.in);
        Libraries.displayHeader("Delete a Client");
        
        System.out.print("Enter the phone number of the client you want to delete: ");
        String searchQuery = input.nextLine();
        
        File file = new File("clients.txt");
        int memoryLineToDelete = -1;
	boolean foundQuery = false;
        int totalRows = 0;
        
        
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            String currentLine = reader.nextLine();
            if (currentLine.contains(searchQuery)) {
                memoryLineToDelete = totalRows;
            }
            totalRows++;
        }
        
        
        Scanner uploader = new Scanner(file);
        uploader.useDelimiter(",");
        String[][] memory = new String[totalRows][4];
        for (int row = 0; row < memory.length; row++) {
            for (int column = 0; column < memory[row].length; column++) {
                if (uploader.hasNextLine()) {
                    memory[row][column] = uploader.next();
                }
            }
        }
        
        memoryLineToDelete = memoryLineToDelete + 1;
        int offset = 0;
        String[][] memoryNew = new String[totalRows - 1][4];
        for (int row = 0; row < memory.length; row++) {
            for (int column = 0; column < memory[row].length; column++) {
                if (memoryLineToDelete != row + 1) {
                    memoryNew[offset][column] = memory[row][column];
                }
            }
            
            if (memoryLineToDelete != row + 1) {
                offset++;
            }
        }
        
        BufferedWriter updater = new BufferedWriter(new FileWriter(file));
        for (int row = 0; row < memoryNew.length; row++) {
            for (int column = 0; column < memoryNew[row].length; column++) {
                updater.write(memoryNew[row][column] + ",");
            }
            //updater.newLine();
        }
	updater.newLine();			
        updater.flush();
    }   
}
