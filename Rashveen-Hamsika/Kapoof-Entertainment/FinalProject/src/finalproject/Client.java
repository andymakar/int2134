
/************************************************************************************
* Name: Rashveen, Hamsika
* Description: This is the main file that presents the menu to user to select an option
* Date: 12/9/2018
*************************************************************************************/
package finalproject;


public class Client {
  //Data properties 
  private String firstName;
  private String lastName;
  private Address clientAddress;
  private String phoneNumber;
  private String email;
  
  //Parameterized constructor
  public Client(String firstName, String lastName, Address clientAddress, String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.clientAddress = clientAddress;
    this.phoneNumber = phoneNumber;
  }

  //default constructor
  public Client() {
  }

  //getter for first name
  public String getFirstName() {
    return firstName;
  }

  //getter for last name 
  public String getLastName() {
    return lastName;
  }

  //getter for email
  public String getEmail() {
    return email;
  }

  //setter for email
  public void setEmail(String email) {
    this.email = email;
  }

  //getter for Address
  public Address getClientAddress() {
    return clientAddress;
  }

  //getter for phone number 
  public String getPhoneNumber() {
    return phoneNumber;
  }

  //setter for first name 
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  //setter for last name 
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  //setter for Address
  public void setClientAddress(Address clientAddress) {
    this.clientAddress = clientAddress;
  }

  //setter for phone number 
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
    
  //overiding the toString function to return ; seperated strings
  @Override
  public String toString() {
    String str = firstName + ";" + lastName + ";" + phoneNumber+";"+ clientAddress.toString()+";"+email;
    return str;
  }
    
}
