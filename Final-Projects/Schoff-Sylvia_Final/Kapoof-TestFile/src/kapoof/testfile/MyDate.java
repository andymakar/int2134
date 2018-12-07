/*
 * Nathan Sylvia
 * MyDate Code
 * MyDate code
 * 12/6/18
 * Source: https://github.com/jsquared21/Intro-to-Java-Programming/tree/master/Exercise_10/Exercise_10_14
*/
package kapoof.testfile;;
import java.util.*;
public class MyDate {
	// Data Fields
	private int year;
	private int month;
	private int day;

	/** Creates a MyDate object for the current date */
	MyDate() {
		GregorianCalendar calander = new GregorianCalendar();
		year = calander.get(GregorianCalendar.YEAR);
		month = calander.get(GregorianCalendar.MONTH);
		day = calander.get(GregorianCalendar.DAY_OF_MONTH);
	}

	/** Creates a MyDate object with a specified elapsed time
	*	 since midnight, January 1, 1970, in milliseconds */
	MyDate(long elapsedTime) {
		setDate(elapsedTime);
	}

	/** Creates a MyDate object with the 
	*   specified year, month, and day */
	MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	/** Return year */
	public int getYear() {
		return year;
	}
        
	/** Return month */
	public String getMonth() {
		String m = String.valueOf(month + 1);
		return (month < 10 ? "0" + m : m);
	}
        public int getGivenMonth() {
            return month;
        }
	/** Return day */
	public String getDay() {
		String d = String.valueOf(day);
		return (day < 10 ? "0" + d : d);
	}
        public int getGivenDay() {
            return day;
        }
	/** Sets a new date for the object using the elapsed time */
	public void setDate(long elapsedTime) {
		GregorianCalendar calander = new GregorianCalendar();
		calander.setTimeInMillis(elapsedTime);
		year = calander.get(GregorianCalendar.YEAR);
		month = calander.get(GregorianCalendar.MONTH);
		day = calander.get(GregorianCalendar.DAY_OF_MONTH);
	} 
}