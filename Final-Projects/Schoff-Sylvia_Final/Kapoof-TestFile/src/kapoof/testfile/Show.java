/*
 * Nathan S & Zachary S
 * Final project
 * Kapoof - Show
 * 12/4/2018
*/
package kapoof.testfile;
public class Show {
    private String title;
    //Show types
    private int type;
        public final static int MAGIC = 1;
        public final static int COMEDIAN = 2;
        public final static int ROCK = 3;
    private String[] performanceDate = new String[3];
    MyDate bookingDate = new MyDate();
    private double fee;
    private String client;
    private String location;
    //Constructor
    Show() {
        this.title = "Unknown";
        this.type = 0;
        this.performanceDate[0] = "00";
        this.performanceDate[1] = "00";
        this.performanceDate[2] = "0000";
        MyDate bookingDate = new MyDate();
        this.fee = 0;
        this.client = "Unknown";
        this.location = "Unknown";
    }
    Show(String title, int type, String performanceDate, double fee, String client, String location) {
        this.title = title;
        this.type = type;
        this.performanceDate = performanceDate.split("/");
        MyDate bookingDate = new MyDate();
        this.fee = fee;
        this.client = client;
        this.location = location;
    }
    //Mutators and accesors
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getType() {
        switch(type) {
            case 1: return "Magic";
            case 2: return "Comedian";
            case 3: return "Rock";
            default: return "Unknown";
        }
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getBookingDate() {
        return this.bookingDate.getMonth() + "/" + this.bookingDate.getDay() + "/" + this.bookingDate.getYear();
    }
    public String getPerformanceDate() {
        return this.performanceDate[0] + "/" + this.performanceDate[1] + "/" + this.performanceDate[2];
    }
    public String getPerformanceYear() {
        return this.performanceDate[2];
    }
    public String getPerformanceMonth() {
        return this.performanceDate[0];
    }
    public double getFee() {
        return fee;
    }
    public void setFee(double fee) {
        this.fee = fee;
    }
    public String getClient() {
        return client;
    }
    public void setClient(String client) {
        this.client = client;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String toString() {
        return "_________________________\r\nTitle: " + title + "\r\nType: " + getType() + "\r\nPerformance Date: " + getPerformanceDate() + "\r\nBooking Date: " + getBookingDate() + "\r\nFee: " + fee + "\r\nClient: " + client + "\r\nLocation: " + location + "\r\n_________________________\r\n";
    }
}