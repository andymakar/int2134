import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
* Name: Adam Ktona, Tyler Magdich, Deshawn Studavent
* Description: Generates two types of reports based on user input
*/
public class Report {
    public static void listClients() throws FileNotFoundException {
        
        Libraries.displayHeader("Report of Clients");
        
        File file = new File("clients.txt");
        int totalRows = 0;
        
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            String currentLine = reader.nextLine();
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
        
        System.out.println("--------------- Report of Clients ---------------");
        Date date = new Date();
        System.out.println("Date generated: " + date + "\n");
        System.out.println("==========================================================");
        
        int totalRowsThisMonth = 0;
        for (int row = 1; row < totalRows; row++) {
            System.out.print(memory[row][0] + " | " + memory[row][1] + " | " + memory[row][2] + " | " + memory[row][3] + "\n");
        }
        
        System.out.println("\nTotal number of clients: " + (totalRows - 1));
    }
    
    public static void listShowsInMonth() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int monthSearch = 0;
        int yearSearch = 0;
        
        Libraries.displayHeader("Report of Shows");
        System.out.print("Enter the month of shows to search for (in format MM): ");
        monthSearch = input.nextInt();
        System.out.print("Enter the year of shows to search for (in format YYYY): ");
        yearSearch = input.nextInt();
        
        File file = new File("shows.txt");
        int totalRows = 0;
        
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            String currentLine = reader.nextLine();
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
        
        double feeTotal = 0;
        System.out.println("--------------- Report of Shows This Month ---------------");
        Date date = new Date();
        System.out.println("Date generated: " + date + "\n");
        System.out.println("==========================================================");
        
        int totalRowsThisMonth = 0;
        for (int row = 1; row < totalRows; row++) {
            try {
                int bufferMonth = Integer.parseInt(memory[row][2].substring(0,2));
                int bufferYear = Integer.parseInt(memory[row][2].substring(6,10));

                if (monthSearch == bufferMonth && yearSearch == bufferYear) {
                    System.out.print(memory[row][0] + " | " + memory[row][1] + " | " + memory[row][2] + " | " + memory[row][3] + " | " + memory[row][4] + " | " + 
                        memory[row][5] + " | " + memory[row][6] + "\n");
                    totalRowsThisMonth++;
                    
                    String bufferString = memory[row][4];
                    double bufferValue = Double.parseDouble(bufferString.substring(1));
                    feeTotal += bufferValue;
                }
            }
            catch (InputMismatchException ex) {
                
            }
            
        }
        
        System.out.println("\nTotal number of shows: " + (totalRowsThisMonth));
        System.out.println("Total amount earned this month: $" + feeTotal);
    }
}
