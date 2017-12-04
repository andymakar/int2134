/*
 * Romeo Medoro.
 * David Speck
 * Intro to Java
 * 11/25/2017
 * The Client class includes the following fields: First and Last name, phone 
 * number, address, email, and total clients. It includes the methods: add client, 
 * update client, delete client. 
 */
package eventbooking;
import java.io.*;
import java.util.*;

public class Client {
    String firstName;
    String lastName;
    String phoneNumber;
    String address;
    String email;
    static int totalClients = 0;
    
    /* default construction */
    Client(){
    
    }
    
    /* Client constructor */
    Client(String name, String lastName, String phoneNum, 
            String addy, String email){
        this.firstName = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNum;
        this.address = addy;
        this.email = email;
        totalClients ++;
    }
    
    /* returns client first name */
    public String getFirstName(){
        return this.firstName;
        
    }
    
    /* return client last name */
    public String getLastName(){
        return this.lastName;
    }
    
    /* return client name and last name */
    public String getName(){
        String fullName;
        
        fullName = (this.firstName + " " + this.lastName);
        
        return fullName;
    }
    
    /* set first name */
    public void setFirstName(String newName){
        this.firstName = newName;
    }
    
    /* set last name */
    public void setLastName(String newName){
        this.lastName = newName;
    }
    
    /* return the email */
    public String getEmail(){
        return this.email;
    }
    
    /* set email */
    public void setEmail(String newEmail){
        this.email = newEmail;
    }
    
    /* set phone number */
    public void setPhone(String phone){
        this.phoneNumber = phone;
    }
    
    /* return phone number */
    public String getPhone(){
        return this.phoneNumber;
    }
    
    /* set the address */
    public void setAddress(String addy){
        this.address = addy;
    }
    
    /* return the address */
    public String getAddress(){
        return this.address;
    }
    
    /* return a single client from from the file based on an email match */
    public static Client getClient(String clientEmail){
        Client result = new Client();
        // Create a new file object.
        File file = new File("Clients.csv");
        // This list will be used to hold the clients pulled from the file. 
        List<Client> clientList = new ArrayList<Client>();
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
                    //lines.add(temp);
                    String email = temp[0],
                    fname = temp[1],
                    lname = temp[2],
                    phone = temp[3],
                    address = temp[4];
                    
                    clientList.add(new Client(fname, lname, phone, address,
                        email));
                }
                reader.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        for (int i = 0; i < clientList.size(); i++){
            Client client = clientList.get(i);
            if (client.getEmail().equals(clientEmail)){
                result = client;
            }
        }
        return result;
    }
    
    /* Returns a List of Client Objects */
    public static List<Client> getClients(){
        File file = new File("Clients.csv");
        // This list will be used to hold the clients pulled from the file. 
        List<Client> clientList = new ArrayList<Client>();
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
                    //lines.add(temp);
                    String email = temp[0],
                    fname = temp[1],
                    lname = temp[2],
                    phone = temp[3],
                    address = temp[4];
                    
                    clientList.add(new Client(fname, lname, phone, address,
                        email));
                }
                reader.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        return clientList;
    }
    
    
     /* Add client information 
    When the client is added, the client is immediately added to a .csv file. If
    no Clients .csv file exists, one is created. */
    public void addClient(){
        // Flag used to determine whether or not we should wire to the csv.
        boolean exists = false;
        // create a list of clients
        List<Client> clientList = new ArrayList<Client>();
        
        // read the csv data into the list
        clientList = readCSV();
        
        // Loop through the data to see if the email address input is 
        // already in the system, if so, break the loop.
        for (int i = 0; i < clientList.size(); i++){
            Client tempClient = clientList.get(i);
            if(tempClient.getEmail().equals(this.getEmail())){
                exists = true;
                break;
            }
            else{
                exists = false;
            }
        }
        if (exists == false){
            writeCSV(); 
            System.out.println("\nThe new client has been added to the database");
        }
        else
            System.out.println("\nThere is already an account for that email address");
    }
    
    /* updates the client */
    public void updateClient(String varToUpdate, String newValue){
       List<Client> clientList = new ArrayList<Client>();
       
       // read the csv and create a list of objects with the data.
       clientList = readCSV();
       
       // Loop through the list of objects and find the client that we wish
       // to update.
        for (int i = 0; i < clientList.size(); i++){
            Client clientToUpdate = clientList.get(i);
            String clientEmail = clientToUpdate.getEmail();
            String thisEmail = this.getEmail();
            
            if (clientEmail.equals(thisEmail)){
                // Find the client based on email, check what attribute the user
                // wishes to update, and set the new value. 
                switch(varToUpdate){
                    case "Email":
                        clientToUpdate.setEmail(newValue);
                        break;
                    case "First Name":
                        clientToUpdate.setFirstName(newValue);
                        break;
                    case "Last Name":
                        clientToUpdate.setLastName(newValue);
                        break;
                    case "Address" :
                        clientToUpdate.setAddress(newValue);
                        break;
                    case "Phone Number" :
                        clientToUpdate.setPhone(newValue);
                        break;
                    default:
                        break;
                }
            }
            
        }
        // Rewrite our updated list to .csv
        writeCSV(clientList);
    }
    
    /* Removes Client from file */
    public void deleteClient(){
        // Flag used to determine whether or not the file should be overritten.
        boolean exists = false;
        List<Client> clientList = new ArrayList<Client>();
       
       // read the csv and create a list of objects with the data.
       clientList = readCSV();
       
       // Loop through the list of objects and find the client that we wish
       // to delete.
        for (int i = 0; i < clientList.size(); i++){
            Client clientToUpdate = clientList.get(i);
            String clientEmail = clientToUpdate.getEmail();
            String thisEmail = this.getEmail();
            
            if (clientEmail.equals(thisEmail)){
                clientList.remove(clientToUpdate);
                exists = true;
            }
            else{
                exists = false;
            }
        }
        
        // If exists is true
        if (exists == true){
            // Rewrite our updated list to .csv
            writeCSV(clientList);
            totalClients--;
            System.out.println("\nThe client was succesfully deleted.\n");
        }
        else{
            System.out.println("\nInvalid email address.\n");
        }
    }
    
   
    
    /* writeCSV method checks if the file already exists, if so, 
        it appends data to the file, otherwise it creates a new file, and 
        writes a single abject into it. */
    public void writeCSV(){
         //Delimiter used in CSV file
        final String DELIMITER = ",";
        final String NEW_LINE = "\n";
        final String HEADER = "Email, First Name, Last Name, Phone Number, Address";
        
         try{
            // create a file
            File file = new File("Clients.csv");
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
            csvFile.append(this.getEmail());
            csvFile.append(DELIMITER);
            csvFile.append(this.getFirstName());
            csvFile.append(DELIMITER);
            csvFile.append(this.getLastName());
            csvFile.append(DELIMITER);
            csvFile.append(this.getPhone());
            csvFile.append(DELIMITER);
            csvFile.append(this.getAddress());
            csvFile.flush();
            csvFile.close();
        }catch(IOException e){
            e.printStackTrace();
	}
    }
    
    public void writeCSV(List<Client> clients){
         //Delimiter used in CSV file
        final String DELIMITER = ",";
        final String NEW_LINE = "\n";
        final String HEADER = "Email, First Name, Last Name, Phone Number, Address";
        
         try{
            // create a file
            File file = new File("Clients.csv");
            FileWriter csvFile;
            csvFile = new FileWriter(file, false);
            csvFile.write(HEADER);
            
            for (int i = 0; i < clients.size(); i++){
                Client client = clients.get(i);
                csvFile.write(NEW_LINE);
                csvFile.write(client.getEmail());
                csvFile.write(DELIMITER);
                csvFile.write(client.getFirstName());
                csvFile.write(DELIMITER);
                csvFile.write(client.getLastName());
                csvFile.write(DELIMITER);
                csvFile.write(client.getPhone());
                csvFile.write(DELIMITER);
                csvFile.write(client.getAddress());
            }  
            csvFile.flush();
            csvFile.close();
        }catch(IOException e){
            e.printStackTrace();
	}
    }
    public List<Client> readCSV(){
        // Create a new file object.
        File file = new File("Clients.csv");
        // This list will be userd to hold the clients pulled from the file. 
        List<Client> clientList = new ArrayList<Client>();
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
                    //lines.add(temp);
                    String email = temp[0],
                    fname = temp[1],
                    lname = temp[2],
                    phone = temp[3],
                    address = temp[4];
                    
                    clientList.add(new Client(fname, lname, phone, address,
                        email));
                }
                reader.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }catch(FileNotFoundException ex){
            //ex.printStackTrace();
        }
        return clientList;
    }
    
}
