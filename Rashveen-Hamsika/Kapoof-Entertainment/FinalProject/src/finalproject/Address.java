/************************************************************************************
* Name: Rashveen, Hamsika
* Description: This is the Address class that has getter and setter functions
* Date: 12/9/2018
*************************************************************************************/
package finalproject;

public class Address {
  private String street;
  private String city;
  private String state;
  private String zip;

  //default constructor
  public Address() {
  }

  //paramterized constructor
  public Address(String street, String city, String state, String zip) {
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
  }

  //setter for street
  public void setStreet(String street) {
    this.street = street;
  }

  //setter for city
  public void setCity(String city) {
    this.city = city;
  }

  //setter for state 
  public void setState(String state) {
    this.state = state;
  }

  //setter for zip
  public void setZip(String zip) {
    this.zip = zip;
  }

  //getter for street
  public String getStreet() {
    return street;
  }

  //getter for city
  public String getCity() {
    return city;
  }

  //getter for state 
  public String getState() {
    return state;
  }

  //getter for zip
  public String getZip() {
    return zip;
  }
    
  //Overriding toString function to return ; separated string
  @Override
  public String toString() {
    return street + ";" + city +";"+state+";"+zip;
  }
}
