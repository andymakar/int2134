
/************************************************************************************
* Name: Rashveen, Hamsika
* Description: This is the Show class that has getter and setter of class
* Date: 12/9/2018
*************************************************************************************/
package finalproject;

import java.util.Date;

public class Show {
  //data properties   
  private String showId;
  private String showTitle;
  private String showType;
  private String performanceDate;
  private String bookingDate;
  private double fee;
  private Client client;
  private Address performanceAddress;

  //getter for ShowID
  public String getShowId() {
    return showId;
  }

  //setter for showID
  public void setShowId(String showId) {
    this.showId = showId;
  }
  //getter for showTitle
  public String getShowTitle() {
    return showTitle;
  }

  //setter for showTitle
  public void setShowTitle(String showTitle) {
    this.showTitle = showTitle;
  }

  //getter for showType 
  public String getShowType() {
    return showType;
  }

  //setter for showType
  public void setShowType(String showType) {
      switch (showType) {
        case "1":
              this.showType = "Magic Show";
              this.setFee(100);
              break;
        case "2":
              this.showType = "Comedian Show";
              this.setFee(200);
              break;
        case "3":
              this.showType = "Rock Band";
              this.setFee(300);
              break;
        default:
              this.setFee(0);
              break;
      }
  }

  //getter for performance date 
  public String getPerformanceDate() {
    return performanceDate;
  }

  //setter for performance date
  public void setPerformanceDate(String performanceDate) {
    this.performanceDate = performanceDate;
  }

  //getter for booking date 
  public String getBookingDate() {
    return bookingDate;
  }

  //setter for booking date 
  public void setBookingDate(String bookingDate) {
    this.bookingDate = bookingDate;
  }

  //getter for Fee
  public double getFee() {
    return fee;
  }

  //setter for Fee
  public void setFee(double fee) {
      
    this.fee = fee;
  }

  //getter for Client 
  public Client getClient() {
    return client;
  }

  //setter for Client 
  public void setClient(Client client) {
    this.client = client;
  }

  //getter for Performance Address
  public Address getPerformanceAddress() {
    return performanceAddress;
  }

  //setter for performance address 
  public void setPerformanceAddress(Address performanceAddress) {
    this.performanceAddress = performanceAddress;
  }

  //paramterized constructor
  public Show(String showTitle, String showType, String performanceDate, String bookingDate, double fee, Client client, Address performanceAddress) {
    this.showTitle = showTitle;
    this.showType = showType;
    this.performanceDate = performanceDate;
    this.bookingDate = bookingDate;
    this.fee = fee;
    this.client = client;
    this.performanceAddress = performanceAddress;
    this.showId = Long.toString(System.currentTimeMillis());
  }

  //default constructor
  public Show() {
    this.showId = Long.toString(System.currentTimeMillis());
  }
    
  //overiding toString function to return ; separated string
  @Override
  public String toString() {
    return showTitle + ";" + showType + ";" + performanceDate + ";" + bookingDate + ";" + fee + ";"+ performanceAddress.toString() + ";" + client.getEmail() + ";"+ showId;
  }
    
}
