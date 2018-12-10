/************************************************************************************
* Name: Rashveen, Hamsika
* Description: This class implements all the functions for Show functionality
* Date: 12/9/2018
*************************************************************************************/
package finalproject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ClientOperations extends FileHandling {
  //settiing the data properties
  private Client cl;
  private Address clientAddress;
  private boolean isUpdate;
  Scanner input = new Scanner(System.in);
  
  //function to add a new client
  public void addClient() {
    cl = new Client();
    clientAddress = new Address();
    //getting client data 
    getData();
    String data = cl.toString();
    //setting type so that file handler knows to write in client.txt file
    setType("Client");
    //check if client already exists
    if(!validate(cl.getEmail())) {
      //write client details to client.txt  
      if(writeToFile(data))
        System.out.println("Client added Succesfully");  
    }
    else
      System.out.println("Client email already exists. Please add user with a new email.");
  }
  
  //function to update the client details. email is the input of the client whose details
  //we need to update  
  public void updateClient(String email) {
    setType("Client");
    if(validate(email)) {
      cl = new Client();
      clientAddress = new Address();
      //do not ask email, so setting isUpdate to true
      isUpdate = true;
      getData();
      cl.setEmail(email);
      //call update record function to update the client information. Email is passed to identify the client whose information needs to updated
      updateRecord(cl.toString(), email);
      isUpdate = false;
    }
    else
      System.out.println("Record not found");
  }
    
  public void deleteClient (String email) {
    //setting type so that file handled knows to look in client.txt file  
    setType("Client");
    //check if the client exists
    if (validate(email)) {
      //if client exists, call deleteRecord to delete the client information from client.txt
       deleteRecord(email);
    }
    else
      System.out.println("In-correct email");
  }
  
  //function to get the client information  
  public void getData() {
    boolean flag;
    System.out.print("First Name: ");
    cl.setFirstName(input.nextLine());
        
    System.out.print("Last Name: ");
    cl.setLastName(input.nextLine());
    
    flag = true;
    String phoneNumber;
    while (flag) {
        System.out.print("Enter phone number XXX-XXX-XXXX: ");  
      phoneNumber =  input.nextLine();
      //check validity of number. If not correct, prompt again
      if (validatePhoneNumber(phoneNumber)) {
        cl.setPhoneNumber(phoneNumber);
        flag = false;
      }
      else
        System.out.println("Enter phone number in proper format");
    }
        
    System.out.print("Street Address: ");
    clientAddress.setStreet(input.nextLine());
        
    System.out.print("City: ");
    clientAddress.setCity(input.nextLine());
        
    System.out.print("State: ");
    clientAddress.setState(input.nextLine());
       
    System.out.print("Zip: ");
    clientAddress.setZip(input.nextLine());
    cl.setClientAddress(clientAddress);
        
    //ask email only if new client
  
    if(!isUpdate) {
      flag = true;
      String email;
      while(flag) {
        System.out.print("Email: ");
        email = input.nextLine();
        if (isValid(email)) {
          cl.setEmail(email);
          flag = false;
        }
        else
          System.out.println("Please enter email in proper format");
      }      
    }
  }
  
  //return true if phone number is in correct format else false 
  public boolean validatePhoneNumber(String phoneNumber) {
    String phoneRegex = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$";
    Pattern pat = Pattern.compile(phoneRegex); 
    if (phoneNumber == null) 
      return false; 
    return pat.matcher(phoneNumber).matches();     
  }
  //function to check if the email entered is in valid format
  public boolean isValid(String email) { 
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
    Pattern pat = Pattern.compile(emailRegex); 
    if (email == null) 
      return false; 
    return pat.matcher(email).matches(); 
  } 
  //function to generate client report   
  public void clientReport() {
    //getting all the records present in client.txt
    ArrayList<String> arraylist = getClientData();
    int count = 0;
    generateReportHeader();
    String line;
    String[] tmp;
    Client cl = new Client();
    //go throug each client record
    while(count < arraylist.size()) {
      line = arraylist.get(count);
      tmp = line.split(";");
      System.out.printf("%-16s",tmp[0]); //display client first name
      System.out.printf("%-16s",tmp[1]); //displaye client last name 
      System.out.printf("%-16s",tmp[2]); //display client phone number 
      System.out.printf("%s,%s,%s,%s",tmp[3],tmp[4],tmp[5],tmp[6]); //display client address
      System.out.println("\n");
      count++;
    }
    System.out.println("--------------------------------------------------------------------------------------------");
    System.out.println("Total Number of Customers: " + count);//total number of customer 
    System.out.println("--------------------------------------------------------------------------------------------");
  }
    
  public void generateReportHeader() {
    System.out.println("--------------------------------------------------------------------------------------------");
    Date reportDate = new Date();
    SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
    System.out.println("Client Report" + " - "+ df.format(reportDate));  
    System.out.println("--------------------------------------------------------------------------------------------");
    System.out.println("First Name\tLast Name\tPhone Number\tAddress");
    System.out.println("--------------------------------------------------------------------------------------------");
  }
    
    
}
