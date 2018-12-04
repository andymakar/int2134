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
    private String performanceDate;
    private String bookingDate;
    private int fee;
    private String client;
    private String location;
    Show() {
        
    }
    Show(String title, int type, String performanceDate, String bookingDate, int fee, String client, String location) {
        this.title = title;
        this.type = type;
        this.performanceDate = performanceDate;
        this.bookingDate = bookingDate;
        this.fee = fee;
        this.client = client;
        this.location = location;
    }
}
