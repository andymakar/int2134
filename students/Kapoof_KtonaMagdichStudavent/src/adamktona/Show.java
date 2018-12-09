package adamktona;

/*
* Name: Adam Ktona
* Description: Adds, modifies, or deletes shows from the filesystem
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
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
        DateFormat df = new SimpleDateFormat("M d y");
        DateFormat dfprint = new SimpleDateFormat("M/d/y");
        DateFormat m = new SimpleDateFormat("M");
        DateFormat d = new SimpleDateFormat("d");
        DateFormat y = new SimpleDateFormat("y");
        
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
                
                // WIP: basic data integrity check. If the performance date's month is less than 1 or greater than 12, throw an error, etc.
                if (Integer.parseInt(m.format(performanceDate)) < 1 || Integer.parseInt(m.format(performanceDate)) > 12) {
                    System.out.print("Invalid input: the month must be between 1 and 12.\n");
                }
                else if (Integer.parseInt(d.format(performanceDate)) < 1 || Integer.parseInt(d.format(performanceDate)) > 31) {
                    System.out.print("Invalid input: the day must be between 1 and 31.\n");
                }
                else if (Integer.parseInt(y.format(performanceDate)) < 1970 || Integer.parseInt(y.format(performanceDate)) > 9999) {
                    System.out.print("Invalid input: the year must be between 1970 and 9999.\n");
                }
                else {
                    // On correct input, the loop will be broken
                    continueInput = false;
                }
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
                
                if (Integer.parseInt(m.format(bookingDate)) < 1 || Integer.parseInt(m.format(bookingDate)) > 12) {
                    System.out.print("Invalid input: the month must be between 1 and 12.\n");
                }
                else if (Integer.parseInt(d.format(bookingDate)) < 1 || Integer.parseInt(d.format(bookingDate)) > 31) {
                    System.out.print("Invalid input: the day must be between 1 and 31.\n");
                }
                else if (Integer.parseInt(y.format(bookingDate)) < 1970 || Integer.parseInt(y.format(bookingDate)) > 9999) {
                    System.out.print("Invalid input: the year must be between 1970 and 9999.\n");
                }
                else {
                    continueInput = false;
                }
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
    
    public static void updateShow() throws FileNotFoundException {
        
        Scanner input = new Scanner(System.in);
        Libraries.displayHeader("Update a Show");
        
        System.out.println("Enter the name of the show you want to modify: ");
        String oldShowTitle = input.nextLine();
/*
        String[] splitRow;
        Scanner searcher = new Scanner(new File("shows.txt"));
        while(searcher.hasNext()){
            String buffer = searcher.nextLine().toLowerCase();
            if(buffer.contains(oldShowTitle)){
                splitRow = buffer.split(",");
                break;
            }
        }
*/

        int numberOfRows = 0;
        try (Scanner loader = new Scanner("shows.txt")) {
            while(loader.hasNext()) {
                numberOfRows++;
                loader.nextLine();
            }
        }
        
        String[][] memory = new String[numberOfRows][];
        try {
            try (Scanner s = new Scanner(new File("shows.txt"))) {
                s.useDelimiter(",");
                while (s.hasNext()) {
                    for (int i = 0; i < numberOfRows; i++) {
                        for (int j = 0; j < 7; j++) {
                            memory[i][j] = s.next();
                        }
                    }
                }
            }

        } catch (IOException i) {
            System.out.println("Problems..");
        }
        
        System.out.println(memory[2][2]);
        
        
        
        
        //String[] splitRow = animals.split(",");
        //searcher.useDelimiter(",");
        /*
        File sourceFile = new File("shows.txt");
        if (!sourceFile.exists()) {
            
        }
        
        File targetFile = new File("tempShows.txt");
        if (!targetFile.exists()) {
            
        }
        
        try (
            Scanner searcher = new Scanner(sourceFile);
            PrintWriter output = new PrintWriter(targetFile);
            ) {
            while (input.hasNext()) {
                    String s1 = input.nextLine();
                    String s2 = s1.replaceAll(oldString, newString);
                    output.println(s2);
                }
        
        }
*/
    }
    
    public static void deleteShow() throws IOException {
        // Credit for help with solution: https://stackoverflow.com/questions/1377279/find-a-line-in-a-file-and-remove-it
        Scanner input = new Scanner(System.in);
        
        Libraries.displayHeader("Delete a Show");
        System.out.print("Enter the name of the show you want to delete: ");
        String lineToRemove = input.nextLine();
        
        File inputFile = new File("shows.txt");
        File tempFile = new File("showsTemp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) { //
            
            String currentLine;
            Boolean found = false;
            
            while((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if(trimmedLine.contains(lineToRemove)) {
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            inputFile.delete();
            if(inputFile.delete()){
               tempFile.renameTo(inputFile);
            }
        }
    }
}
