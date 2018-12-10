/*
* Name: Adam Ktona, Tyler Magdich, Deshawn Studavent
* Description: Adds, modifies, or deletes shows from the filesystem
*/
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
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Show {
    
    public static void addShow() throws FileNotFoundException, ParseException {
        // Preparation: initialize date formats to help parse input
        Scanner input = new Scanner(System.in);
        DateFormat df = new SimpleDateFormat("MM dd y");
        DateFormat dfprint = new SimpleDateFormat("MM/dd/y");
        DateFormat m = new SimpleDateFormat("MM");
        DateFormat d = new SimpleDateFormat("dd");
        DateFormat y = new SimpleDateFormat("yy");
        
        // Invoke the displayHeader method
        Libraries.displayHeader("Add a Show");
        
        // Get show name
        System.out.print("Enter the name of the show: ");
        String showTitle = input.nextLine();
        
        boolean continueInput = true;
        String showTypeString = null;
        
        // Prompt for 1, 2, or 3. Errors will be caught and the user prompted again for input. When the correct input is given, convert the number into a user-friendly string.
        do {
            try {
                System.out.print("Enter the type of show: \n1: Magic show\n2: Comedian show\n3: Rock band\n");
                int showType = input.nextInt();
                switch (showType) {
                    case 1:
                        showTypeString = "Magic Show";
                        continueInput = false;
                        break;
                    case 2:
                        showTypeString = "Comedian Show";
                        continueInput = false;
                        break;
                    case 3:
                        showTypeString = "Rock Band";
                        continueInput = false;
                        break;
                    default:
                        System.out.print("Please enter 1, 2, or 3 only.\n");
                }
            }
            // If user enters in anything but an int, catch the error, display an error message, and kick them back to the start of the loop
            catch (InputMismatchException ex) {
                System.out.print("Please enter 1, 2, or 3 only.\n");
                input.nextLine();
            }
        } while (continueInput);
        // Clear the buffer and advance the carriage to the next line to avoid input errors
        input.nextLine();
        
        continueInput = true;
        Date performanceDate = null;
        // Get a date as a string and parse it into a SimpleDateFormat. If the string cannot be parsed, throw an error and prompt again
        while (continueInput) {
            try {
                System.out.print("Enter the performance date (format: MM DD YYYY): ");
                String performanceString = input.nextLine();
                
                performanceDate = df.parse(performanceString);
                continueInput = false;
                
            } catch (ParseException ex) {
                System.out.print("Invalid format: use the MM DD YYYY format with spaces in between each number.\n");
            }
        }
        
        continueInput = true;
        Date bookingDate = null;
        // Same as above, except with the booking date
        while (continueInput) {
            try {
                System.out.print("Enter the booking date (format: MM DD YYYY): ");
                String book = input.nextLine();
                
                bookingDate = df.parse(book);
                
                
                    continueInput = false;
                
            }
            catch (ParseException ex) {
                System.out.print("Invalid format: use the MM DD YYYY format with spaces in between each number.\n");
            }
        }
        
        double fee = 0.0;
        continueInput = true;
        // Collects input for the fee and checks to make sure it is a positive double, catches errors if not
        do {
            try {
                System.out.print("Enter the fee: ");
                fee = Libraries.currencyRound(input.nextDouble());
                if (fee > 0) {
                    continueInput = false;
                }
                else {
                    System.out.print("Invalid input: please enter an amount of money greater than 0.\n");
                }
            }
            catch (InputMismatchException ex) {
                System.out.print("Invalid input: please enter an amount of money greater than 0.\n");
                input.nextLine();
            }
        } while (continueInput);
        input.nextLine();
        
        // Collects client name and address input. No error checking necessary
        System.out.print("Enter the client name: ");
        String client = input.nextLine();
        
        System.out.print("Enter the performance address/city/state/zip: ");
        String address = input.nextLine();
        
        // Creates a File object named file (shows.txt)
        java.io.File file = new java.io.File("shows.txt");
        // If the file does not yet exist, create the file and append the .csv header to prepare it for the .csv format
        if (file.exists() == false) {
                try (PrintWriter csvprep = new PrintWriter(new FileOutputStream(new File("shows.txt"), false))) {
                    csvprep.println("show_title,show_type,show_performance_date,show_booking_date,show_fee,show_client,show_address,");
                    csvprep.close();
                }
            }
        // Write each piece of information onto a new line of the file, separated by commas to keep .csv compatibility
        try (PrintWriter output = new PrintWriter(new FileOutputStream(new File("shows.txt"),true))) {
            output.print(showTitle + ",");
            output.print(showTypeString + ",");
            output.print(dfprint.format(performanceDate) + ",");
            output.print(dfprint.format(bookingDate) + ",");
            output.print("$" + fee + ",");
            output.print(client + ",");
            output.println(address + ",");
            
            output.close();
        }
        // Display confirmation message
        System.out.println("Successfully added " + showTitle + " to the list.");
    }
    
    
    
    
    public static void updateShow() throws FileNotFoundException, IOException {
        Scanner input = new Scanner(System.in);
        Libraries.displayHeader("Update a Show");
        
        System.out.print("Enter the name of the show you want to replace: ");
        String oldShowTitle = input.nextLine();
        
        
        File file = new File("shows.txt");
        int memoryLineToUpdate = 0;
	boolean successfullyFoundLine = false;
                 
        Scanner searcher = new Scanner(file);
        int numberOfRows = 0;
        while (searcher.hasNextLine()) {
                String buffer = searcher.nextLine();
                numberOfRows++;
                if (buffer.contains(oldShowTitle)) {
                    successfullyFoundLine = true;
                    memoryLineToUpdate = numberOfRows;
                }
            }
            
        if (!successfullyFoundLine) {
            System.out.println("Error: The show name called \"" + oldShowTitle + "\" could not be found. Please try again.");
            return;
        }
        
        Scanner reader = new Scanner(file);
        reader.useDelimiter(",");
        String[][] memory = new String[numberOfRows][7];
        
        
        //System.out.println("Number of rows: " + numberOfRows);
        //System.out.println("Row to update: " + memoryLineToUpdate);
            
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < 7; column++) {
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
                System.out.print("Choose which you would like to edit: \n1: Show title\n2: Show type\n3: Performance Date\n4: Booking Date\n5: Fee\n6: Client Name\n7: Address\n\n");
                int showType = input.nextInt();
                switch (showType) {
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
                    case 5:
                        System.out.println("Old value: " + memory[memoryLineToUpdate - 1][4] + "\n");
                        System.out.print("New value: ");
                        memory[memoryLineToUpdate - 1][4] = update.nextLine();
                        continueInput = false;
                        break;
                    case 6:
                        System.out.println("Old value: " + memory[memoryLineToUpdate - 1][5] + "\n");
                        System.out.print("New value: ");
                        memory[memoryLineToUpdate - 1][5] = update.nextLine();
                        continueInput = false;
                        break;
                    case 7:
                        System.out.println("Old value: " + memory[memoryLineToUpdate - 1][6] + "\n");
                        System.out.print("New value: ");
                        memory[memoryLineToUpdate - 1][6] = update.nextLine();
                        continueInput = false;
                        break;
                    
                    default:
                        System.out.print("Please enter a number between 1 and 7.\n");
                }
            }
            // If user enters in anything but an int, catch the error, display an error message, and kick them back to the start of the loop
            catch (InputMismatchException ex) {
                System.out.print("Please enter a number between 1 and 7.\n");
                input.nextLine();
            }
        } while (continueInput);
        // Clear the buffer and advance the carriage to the next line to avoid input errors
        input.nextLine();
        
        BufferedWriter updater = new BufferedWriter(new FileWriter(file));
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < 7; column++) {
                updater.write(memory[row][column] + ",");
            }
            //updater.newLine();
        }
				
        updater.flush();
    }
    
    public static void deleteShow() throws FileNotFoundException, IOException {
        Scanner input = new Scanner(System.in);
        Libraries.displayHeader("Delete a Show");
        
        System.out.print("Enter the name of the show you want to delete: ");
        String searchQuery = input.nextLine();
        
        File file = new File("shows.txt");
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
        String[][] memory = new String[totalRows][7];
        for (int row = 0; row < memory.length; row++) {
            for (int column = 0; column < memory[row].length; column++) {
                if (uploader.hasNextLine()) {
                    memory[row][column] = uploader.next();
                }
            }
        }
        
        memoryLineToDelete = memoryLineToDelete + 1;
        int offset = 0;
        String[][] memoryNew = new String[totalRows - 1][7];
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
