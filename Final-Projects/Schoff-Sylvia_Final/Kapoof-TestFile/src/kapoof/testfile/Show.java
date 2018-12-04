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
        this.title = "Unknown";
        this.type = 0;
        this.performanceDate = "Unknown";
        this.bookingDate = "Unknown";
        this.fee = 0;
        this.client = "Unknown";
        this.location = "Unknown";
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
    public void dropStudent(String student, int i) { 
        if (student.equalsIgnoreCase(students[i])) {
            students[i] = null; // sets dropped student's value to null
            numberOfStudents--;
            while (i < numberOfStudents) {
                students[i] = students[i + 1];
                i++;
            }
            }
        }
    }
}
