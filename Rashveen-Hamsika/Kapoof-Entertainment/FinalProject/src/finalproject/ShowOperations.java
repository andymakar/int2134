/************************************************************************************
* Name: Rashveen, Hamsika
* Description: This class implements all the functions for Show functionality
* Date: 12/9/2018
*************************************************************************************/
package finalproject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;


public class ShowOperations extends FileHandling {
  private Show show;
  private Address performanceAddress;
  private Client client;
    
  //function to add a show
  public void addShow() {
    setType("Show");
    show = new Show();
    client = new Client();
    performanceAddress = new Address();
    //function to get user input
    getData();
    //validate if the client exists
    if (validate(show.getClient().getEmail())) {
      //write show to file show.txt by calling function writeToFile  
      if (writeToFile(show.toString()))
        System.out.println("Please note your show ID is:"+ show.getShowId());        
      }          
    else
      System.out.println("Client doesn't exists");
  }
  
  //function to delete show. Show number is the input  
  public void deleteShow(String showNumber) {
    setType("Show");
    //check if the showID is valid
    if (validateShow(showNumber)) {
      //calling deleteRecord function to delete the show  
      deleteRecord(showNumber);
    }
    else
      System.out.println("Enter a valid show ID");
  }
  
  //Function to update the show  
  public void updateShowById(String showId) {
    setType("Show");        
    //validate showID
    if(validateShowbyID(showId)) {
      show = new Show();
      client = new Client();
      performanceAddress = new Address();
      getData();
      show.setShowId(showId);
      //validate if client exists 
      if (validate(show.getClient().getEmail())) {
        //call function to update the show   
        updateRecord(show.toString(), showId);
      }
      else
        System.out.println("Please enter email of a client that exists or else add client first");
    }
    else
      System.out.println("Invalid Show ID");
  }
  
  public void getData() {
    boolean flag = false;
    Scanner input = new Scanner(System.in);
    String title, date,inputAddress,type;
    //checking show title should not be blank
    flag = true;
    while(flag) {
      System.out.print("Enter show title:");
      title = input.nextLine();
      if(title.isEmpty()) {
          System.out.println("Title cannot be blank. Please enter valid title");    
      }
      else {
         show.setShowTitle(title);   
         flag = false;
      } 
    }
    
    //checking show type can be either 1,2 or 3
    flag = true;
    while(flag) {
      System.out.print("Enter show type 1 for Magic Show, 2 for Comedian Show, 3 for Rock Band:");
      type = input.nextLine();
      if(type.equals("1") || type.equals("2") || type.equals("3")) {
        show.setShowType(type);
        flag = false;
      }
      else {
          System.out.println("Please enter correct show type");  
      }
    }
    
    //checking the format of performance date 
    flag = true;
    while(flag) {
      System.out.print("Enter Performance Date MM-DD-YYYY:");
      date = input.nextLine();
      if (isThisDateValid(date,"MM-dd-yyyy")) {
        flag = false;
        show.setPerformanceDate(date);
      }
      else {
        System.out.println("Please enter proper date");        
      }
    }
        
    show.setBookingDate(new Date().toString());//current date method
    
    //checking if performance address cannot be blank
    flag = true;
    while (flag) {
      System.out.print("Street Address: ");
      inputAddress = input.nextLine();
      if(checkEmpty(inputAddress)) {
          System.out.println("Performance Street address cannot be Empty. Please enter it again. ");  
      }
      else {
        flag = false;
        performanceAddress.setStreet(inputAddress);
      }        
    }
    
    flag = true;
    while (flag) {
      System.out.print("City: ");
      inputAddress = input.nextLine();
      if(checkEmpty(inputAddress)) {
          System.out.println("Performance City cannot be Empty. Please enter it again. ");  
      }
      else {
        flag = false;
         performanceAddress.setCity(inputAddress);
      }        
    }
        
    flag = true;
    while (flag) {
      System.out.print("State: ");
      inputAddress = input.nextLine();
      if(checkEmpty(inputAddress)) {
          System.out.println("Performance State cannot be Empty. Please enter it again. ");  
      }
      else {
        flag = false;
         performanceAddress.setState(inputAddress);
      }        
    }
    
    flag = true;
    while (flag) {
      System.out.print("Zip:");
      inputAddress = input.nextLine();
      if(checkEmpty(inputAddress)) {
          System.out.println("Performance Zip cannot be Empty. Please enter it again. ");  
      }
      else {
        flag = false;
         performanceAddress.setZip(inputAddress);
      }        
    }
        
    show.setPerformanceAddress(performanceAddress);
    
    //checking the client email format.
    flag = true;
    String email;
    while(flag) {
      System.out.print("Client E-mail:");
      email = input.nextLine();
      if (isValid(email)) {
        client.setEmail(email);
        flag = false;
      }
      else
        System.out.println("Please enter email in proper format");
    }  
    show.setClient(client);        
  }
  
  //return true if string is empty else it will return false
  public boolean checkEmpty(String str) {
    if(str.equals("") || str.equals(null))
        return true;
    return false;
  }
  //function to check if the email entered is in valid format
  public static boolean isValid(String email) { 
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
    Pattern pat = Pattern.compile(emailRegex); 
    if (email == null) 
      return false; 
    return pat.matcher(email).matches(); 
  }
    
  //function to show show report. Input is month and year 
  public void showReport(String month, String year) {
    //get the show data from show.txt file for the given month and year  
    ArrayList<String> arraylist = getShowData(month,year);
    int count = 0;
    String clientData;
    String clientEmail;
    String[] tmp;
    String[] clienttmp = null;
    String line;
    generateReportHeader(month,year);
    double totalFees = 0;
    //traverse through the show data
    while(count < arraylist.size()) {
      line = arraylist.get(count); 
      tmp = line.split(";");
      //extract client email from show data. Client email is at 9th position
      clientEmail = tmp[9];
      //get the client data corresponding to the email. clientData will have data corresponding to client email from client.txt
      clientData = getClientDataByEmail(clientEmail);
      if(clientData != null)
       clienttmp = clientData.split(";");
      count++;
      System.out.printf("%-40s",tmp[0]);//show title is at position 0 in show.txt
      System.out.printf("%-24s",clienttmp[0]); //client first name is at position 0 in client.txt
      System.out.printf("%-24s",clienttmp[1]); //last name is at position 1 in client.txt
      System.out.printf("%-16s",tmp[1]); //show type is at position 1 in show.txt
      System.out.printf("%-16s",tmp[2]); //show performance is at position 2 in show.txt
      System.out.printf("%-16s",tmp[4]); //show fees is at position 4 in show.txt
      System.out.println("\n");
      totalFees= totalFees + Double.parseDouble(tmp[4]);
    }
    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("Total Number of Shows: " + count);
    System.out.println("Total Fees: " + totalFees);
    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
  }
  
  //function to generate report header   
  public void generateReportHeader(String month, String year) {
    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
    Date reportDate = new Date();//generate current date
    SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
    System.out.println("Show Report "+month+"/"+year + " - "+ df.format(reportDate));  
    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("Show Title\t\t\t\tClient First Name\tClient Last Name\tShow Type\tShow Date\tFees");
    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
  }
  
  //this function checks the date format, date validity and if date is not before the current date  
  public boolean isThisDateValid(String dateToValidate, String dateFromat){
    if(dateToValidate == null){
      return false;
    }
		
    SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
    
    sdf.setLenient(false);
    try {
      //if not valid, it will throw ParseException
      Date date = sdf.parse(dateToValidate);
      if(!date.after(new Date()))
        return false;
      
    } catch (ParseException e) {
	//e.printStackTrace();
	return false;
      }
    return true;
  }
	
}

