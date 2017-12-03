/*
 * Romeo Medoro.
 * David Speck
 * Intro to Java
 * 11/25/2017
 * The show class includes the following fields: Clients, title, type, performance
 * date, booking date, fee, address, city, state, zip. It includes the following 
 * methods: add show, update show, delete show. 
 */
package eventbooking;
import java.util.*;
import java.io.*;
import java.text.*;  

public class Show {
    String client;
    String clientID;
    String title;
    String type;
    String performanceDate;
    String bookingDate;
    double fee;
    String address;
    String city;
    String state;
    String zip;
    static int totalShows = 0;
    
    /* no arg constructor */
    Show(){
    this.bookingDate = new Date().toString();
    totalShows++;
    }
    
    /* Show Constructor */
    Show(String title, String type, String clientEmail, String performance, double fee, String address,
            String city, String state, String zip){
        String firstName = Client.getClient(clientEmail).getFirstName();
        String lastName = Client.getClient(clientEmail).getLastName();
        this.client = (firstName + " " + lastName);
        this.clientID = clientEmail;
        this.title = title;
        this.type = type;
        this.performanceDate = performance;
        this.fee = fee;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.bookingDate = new Date().toString();
        
        totalShows++;
    }
    
     /* Show Constructor */
    Show(String title, String type, String clientEmail, String booking, String performance, double fee, 
            String address, String city, String state, String zip){
        String firstName = Client.getClient(clientEmail).getFirstName();
        String lastName = Client.getClient(clientEmail).getLastName();
        this.client = (firstName + " " + lastName);
        this.clientID = clientEmail;
        this.title = title;
        this.type = type;
        this.performanceDate = performance;
        this.bookingDate = booking;
        this.fee = fee;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        
        totalShows++;
    }
    
    /* Set the title */
    public void setTitle(String newTitle){
        this.title = newTitle;
    }
    
    /* Return the title */
    public String getTitle(){
        return this.title;
    }
    
    /* Set the type */
    public void setType(int typeSelection){
        switch(typeSelection){
            case 1:
                this.type = "Magic";
                break;
            case 2:
                this.type = "Comedy";
                break;
            case 3:
                this.type = "Rock";
                break;
            default:
                this.type = null;
        }
    }
    
    /* Get the show type */
    public String getType(){
        return this.type;
    }
    
    /* Set the performance date */
    public void setPerformanceDate(String newPerformanceDate){
        this.performanceDate = newPerformanceDate;
    }
    
    /* Get the performance date */
    public String getPerformanceDate(){
        return this.performanceDate;
    }
    
    /* set the booking date */
    public void setBookingDate(String newDate){
        this.bookingDate = newDate;
    }
    
    /* return the booking date */
    public String getBookingDate(){
        return this.bookingDate;
    }
    
    /* set the fee */
    public void setFee(double newFee){
        this.fee = newFee;
    }
    
    /* return the fee */
    public double getFee(){
        return this.fee;
    }
    
    /* Set the client */
    public void setClient(Client newClient){
        this.client = (newClient.getFirstName() + " " + newClient.getLastName());
        this.clientID = newClient.getEmail();
    }
    
    /* Get the client's name */
    public String getClientName(){
        return this.client;
    }
    
    /* get the client's ID */
    public String getClientID(){
        return this.clientID;
    }
    
    /* set the address */
    public void setAddress(String newAddress){
        this.address = newAddress;
    }
    
    /* get the address */
    public String getAddress(){
        return this.address;
    }
    
    /* set the city */
    public void setCity(String newCity){
        this.city = newCity;
    }
    
    /* get the city */
    public String getCity(){
        return this.city;
    }
    
    /* set the state */
    public void setState(String newState){
        this.state = newState;
    }
    
    /* Get the state */
    public String getState(){
        return this.state;
    }
    
    /* set the zip */
    public void setZip(String newZip){
        this.zip = newZip;
    }
    
    /* get the zip */
    public String getZip(){
        return this.zip;
    }
    
    /* writeCSV method checks if the file already exists, if so, 
        it appends data to the file, otherwise it creates a new file, and 
        writes a single abject into it. */
    public void writeCSV(){
         //Delimiter used in CSV file
        final String DELIMITER = ",";
        final String NEW_LINE = "\n";
        final String HEADER = ("Show Title, Show Type, Performance Date, "
                + "Booking Date, Fee, ClientID, Client, Performance Address, "
                + "Performance City, Performance State, Performance Zip");
        
         try{
            // create a file
            File file = new File("Shows.csv");
            FileWriter csvFile;
            // If the file doesn't exit, create it.
            if (!(file.exists())){
                file.createNewFile();
                csvFile = new FileWriter(file,false);
                csvFile.append(HEADER);
                csvFile.append(NEW_LINE);
            }
            
            else{
                csvFile = new FileWriter(file, true);
                csvFile.append(NEW_LINE);
            }
            csvFile.append(this.getTitle());
            csvFile.append(DELIMITER);
            csvFile.append(this.getType());
            csvFile.append(DELIMITER);
            csvFile.append(this.getPerformanceDate());
            csvFile.append(DELIMITER);
            csvFile.append(this.getBookingDate());
            csvFile.append(DELIMITER);
            csvFile.append(Double.toString(this.getFee()));
            csvFile.append(DELIMITER);
            csvFile.append(this.clientID);
            csvFile.append(DELIMITER);
            csvFile.append(this.client);
            csvFile.append(DELIMITER);
            csvFile.append(this.address);
            csvFile.append(DELIMITER);
            csvFile.append(this.city);
            csvFile.append(DELIMITER);
            csvFile.append(this.state);
            csvFile.append(DELIMITER);
            csvFile.append(this.zip);
            csvFile.flush();
            csvFile.close();
        }catch(IOException e){
            e.printStackTrace();
	}
    }
    /* overrides writeCSV allowing a list of shows as an argument */
    public void writeCSV(List<Show> shows){
         //Delimiter used in CSV file
        final String DELIMITER = ",";
        final String NEW_LINE = "\n";
        final String HEADER = "Show Title, Show Type, Performance Date, "
                + "Booking Date, Fee, ClientID, Client, Performance Address, "
                + "Performance City, Performance State, Performance Zip";
        
         try{
            // create a file
            File file = new File("Shows.csv");
            FileWriter csvFile;
            csvFile = new FileWriter(file, false);
            csvFile.write(HEADER);
            
            for (int i = 0; i < shows.size(); i++){
                Show show = shows.get(i);
                csvFile.write(NEW_LINE);
                csvFile.write(show.getTitle());
                csvFile.write(DELIMITER);
                csvFile.write(show.getType());
                csvFile.write(DELIMITER);
                csvFile.write(show.getPerformanceDate());
                csvFile.write(DELIMITER);
                csvFile.write(show.getBookingDate());
                csvFile.write(DELIMITER);
                csvFile.write(Double.toString(show.getFee()));
                csvFile.write(DELIMITER);
                csvFile.write(show.getClientID());
                csvFile.write(DELIMITER);
                csvFile.write(show.getClientName());
                csvFile.write(DELIMITER);
                csvFile.write(show.getAddress());
                csvFile.write(DELIMITER);
                csvFile.write(show.getCity());
                csvFile.write(DELIMITER);
                csvFile.write(show.getState());
                csvFile.write(DELIMITER);
                csvFile.write(show.getZip());
            }  
            csvFile.flush();
            csvFile.close();
        }catch(IOException e){
            e.printStackTrace();
	}
    }
    public List<Show> readCSV(){
        // Create a new file object.
        File file = new File("Shows.csv");
        // This list will be userd to hold the Shows pulled from the file. 
        List<Show> showList = new ArrayList<Show>();
        // Temp array to hold a single line which will then be dumped into line variable
        String[] temp;
        // Temporarily holds a line from the file as a single string before we
        // split it at each delimiter.
        String row = "";
        try{
            // Create the BufferedReader object
            BufferedReader reader = new BufferedReader(new FileReader(file));
            try{
                // This is so that we skip the header line
                reader.readLine();
                // Read the lines as long as the line is not blank, and assign
                // it to row.
                while((row = reader.readLine()) != null){
                    // split the line at each comma into an array of strings. 
                    temp = row.split(",");
                    // Add the array to our list of arrays. 
                    //lines.add(temp);
                    String title = temp[0],
                        type = temp[1],
                        performanceDate = temp[2],
                        bookingDate = temp[3],
                        clientID = temp[5],
                        clientName = temp[6],
                        address = temp[7],
                        city = temp[8],
                        state = temp[9],
                        zip = temp[10];
                    double fee = Double.parseDouble(temp[4]);
                       
                    
                    showList.add(new Show(title, type, clientID, bookingDate, performanceDate,
                        fee, address, city, state, zip));
                }
                reader.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }catch(FileNotFoundException ex){
           // ex.printStackTrace();
        }
        return showList;
    }
    
    /* Add show information to the "db"
    When the show is added, the show is immediately added to a .csv file. If
    no show .csv file exists, one is created. */
    public void addShow(){
        // Flag used to determine whether or not we should write to the csv.
        boolean exists = false;
        // create a list of clients
        List<Show> showList = new ArrayList<Show>();
        
        // read the csv data into the list
        showList = readCSV();
        
        // Loop through the data to see if the show is
        // already in the system, if so, break the loop.
        for (int i = 0; i < showList.size(); i++){
            Show tempShow = showList.get(i);
            if(tempShow.getTitle().equals(this.getTitle()) &&
                    tempShow.getClientID().equals(this.getClientID())){
                exists = true;
                break;
            }
            else{
                exists = false;
            }
        }
        if (exists == false){
            writeCSV(); 
            System.out.println("\nThe new Show has been added to the database");
        }
        else
            System.out.println("\nThe show is already stored in the system.");
    }
    
    /* updates the show */
    public void updateShow(String varToUpdate, String newValue){
       List<Show> showList = new ArrayList<Show>();
       // read the csv and create a list of objects with the data.
       showList = readCSV();
       
       // Loop through the list of objects and find the client that we wish
       // to update.
        for (int i = 0; i < showList.size(); i++){
            Show showToUpdate = showList.get(i);
            String showName = showToUpdate.getTitle();
            String thisShow = this.getTitle();
            
            if (showName.equals(thisShow)){
                // Find the show based on title, check what attribute the user
                // wishes to update, and set the new value. 
                switch(varToUpdate){
                    case "Title":
                        showToUpdate.setTitle(newValue);
                        System.out.println("\nThe Show Title has been updated!");
                        break;
                    case "Type":
                        if(newValue == "Magic"){
                            showToUpdate.setType(1);
                        }
                        else if (newValue == "Comedy"){
                            showToUpdate.setType(2);
                        }
                        else
                            showToUpdate.setType(3);
                        System.out.println("\nThe Show Type has been updated "
                                + "to " + newValue);
                        break;
                    case "Performance Date":
                        showToUpdate.setPerformanceDate(newValue);
                        System.out.println("\nThe performance date has been"
                                    + "updated to " + performanceDate);
                        break;
                    case "Fee" :
                        showToUpdate.setFee(Double.parseDouble(newValue));
                        System.out.println("\nThe Fee has been updated.");
                        break;
                    case "Address":
                        showToUpdate.setAddress(newValue);
                        System.out.println("\nThe address has been updated");
                        break;
                    case "City":
                        showToUpdate.setCity(newValue);
                        System.out.println("\nThe city has been updated");
                        break;
                    case "State":
                        showToUpdate.setState(newValue);
                        System.out.println("\nThe state has been updated");
                        break;
                    case "Zip":
                        showToUpdate.setZip(newValue);
                        System.out.println("The zip has been updated");
                        break;
                    case "Client":
                        Client newClient = Client.getClient(newValue);
                        showToUpdate.setClient(newClient);
                        System.out.println("\nThe client has been updates.");
                    default:
                        break;
                }
            }
            
        }
        // Rewrite our updated list to .csv
        writeCSV(showList);
    }
    
     /* Removes Shows from file */
    public void deleteShow(){
        // Flag used to determine whether or not the file should be overritten.
        boolean exists = false;
        List<Show> showList = new ArrayList<Show>();
       
       // read the csv and create a list of objects with the data.
       showList = readCSV();
       
       // Loop through the list of objects and find the show that we wish
       // to delete.
        for (int i = 0; i < showList.size(); i++){
            Show showToUpdate = showList.get(i);
            String showName = showToUpdate.getTitle();
            String thisShow = this.getTitle();
            
            if (showName.equals(thisShow)){
                showList.remove(showToUpdate);
                exists = true;
            }
            else{
                exists = false;
            }
        }
        
        // If exists is true
        if (exists == true){
            // Rewrite our updated list to .csv
            writeCSV(showList);
            totalShows--;
            System.out.println("\nThe show was succesfully deleted.\n");
        }
        else{
            System.out.println("\nInvalid show title.\n");
        }
    }
    
    /* check the shows in the "db" and returns the show if there's a match */
    public static Show getShow(String title){
        Show result = new Show();
        // Create a new file object.
        File file = new File("Shows.csv");
        // This list will be used to hold the shows pulled from the file. 
        List<Show> showList = new ArrayList<Show>();
        // Temp array to hold a single line which will then be dumped into line
        String[] temp;
        // Temporarily holds a line from the file as a single string before we
        // split it at each delimiter.
        String row = "";
        try{
            // Create the BufferedReader object
            BufferedReader reader = new BufferedReader(new FileReader(file));
            try{
                // This is so that we skip the header line
                reader.readLine();
                // Read the lines as long as the line is not blank, and assign
                // it to row.
                while((row = reader.readLine()) != null){
                    // split the line at each comma into an array of strings. 
                    temp = row.split(",");
                    // Add the array to our list of arrays. 
                    String showTitle = temp[0], 
                            type = temp[1],
                            performanceDate = temp[2],
                            bookingDate = temp[3],
                            clientID = temp[5],
                            clientName = temp[6],
                            address = temp[7],
                            city = temp[8],
                            state = temp[9],
                            zip = temp[10];
                    double fee = Double.parseDouble(temp[4]);
                       
                    
                    showList.add(new Show(showTitle, type, clientID, bookingDate, performanceDate,
                        fee, address, city, state, zip));
                }
                reader.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        for (int i = 0; i < showList.size(); i++){
            Show show = showList.get(i);
            if (show.getTitle().equals(title)){
                result = show;
            }
        }
        return result;
    }
    /* Returns a list of all the shows */
     public static List<Show> getShows(){
        File file = new File("Shows.csv");
        // This list will be used to hold the shows pulled from the file. 
        List<Show> showList = new ArrayList<Show>();
        // Temp array to hold a single line which will then be dumped into line
        String[] temp;
        // Temporarily holds a line from the file as a single string before we
        // split it at each delimiter.
        String row = "";
        try{
            // Create the BufferedReader object
            BufferedReader reader = new BufferedReader(new FileReader(file));
            try{
                // This is so that we skip the header line
                reader.readLine();
                // Read the lines as long as the line is not blank, and assign
                // it to row.
                while((row = reader.readLine()) != null){
                    // split the line at each comma into an array of strings. 
                    temp = row.split(",");
                    // Add the array to our list of arrays. 
                      String title = temp[0],
                        type = temp[1],
                        performanceDate = temp[2],
                        bookingDate = temp[3],
                        clientID = temp[5],
                        clientName = temp[6],
                        address = temp[7],
                        city = temp[8],
                        state = temp[9],
                        zip = temp[10];
                    double fee = Double.parseDouble(temp[4]);
                       
                    
                    showList.add(new Show(title, type, clientID, bookingDate, performanceDate,
                        fee, address, city, state, zip));
                }
                reader.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        return showList;
    }
}
