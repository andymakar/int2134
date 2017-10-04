/*Name: Andrew Makar
Class: INT2134
Date: 9/25/17
Program Description: My implementation of Zellers Congruence
Source Algorithm: https://en.wikipedia.org/wiki/Zeller%27s_congruence
*/
package anyday;

import java.util.*;

public class AnyDay {
    public static void main(String[] args) {
        // TODO code application logic here   
        Scanner input = new Scanner(System.in);    
        int day = 0;
		int month = 0;
		int year = 0;
        int h = 0;
		int k = 0;
		int j = 0;

        System.out.print("Enter the month (1-12): ");    
        month = input.nextInt();
        System.out.print("Enter the day (1-31): ");    
        day = input.nextInt();
        System.out.print("Enter the year (2017): ");    
        year = input.nextInt();

        //handle month logic    
        if (month == 1) {
            month = 13;
            year = year - 1;
        }

        if (month == 2) {
            month = 14;
            year--;
        }

        //calculate K and J values
        k = year % 100;
        j = year / 100;

        h = day + 13*(month+1)/5 + k +k/4 + j/4 +5*j;
        //Now mod by 7 complete the formula
        h = h % 7;

        System.out.print("On " + month + "/" + day + "/" + year + ", the day was a ");
        
        //0 = Saturday, 1 = Sunday, 2 = Monday, ..., 6 = Friday
        switch (h) {
            case 0 : System.out.println("Saturday"); break;
            case 1 : System.out.println("Sunday"); break; 
            case 2 : System.out.println("Monday"); break;
            case 3 : System.out.println("Tuesday"); break;
            case 4 : System.out.println("Wednesday"); break;
            case 5 : System.out.println("Thursday"); break;
            case 6 : System.out.println("Friday"); break;
			default: System.out.println("Invalid Day Calculation"); break;
        }
     
        
    
    }
    
}
