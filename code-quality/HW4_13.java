/*
CLASS: INT2134
DATE: 9/28/17
PROGRAM DESCRIPTION: this program asks the user for a letter then prints out if 
its a vowel or not
*/

package hw4_13;
import java.util.*;


public class HW4_13 {

    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a letter: ");
        String letter = input.next();
        char let = Character.toLowerCase(letter.charAt(0));
        if (!Character.isLetter(let) || letter.length() > 1)
            System.out.println(letter + " is an invalid input.");
        else{
            switch (let){
                case 'a': case 'e': case 'i': case 'o': case 'u':
                    System.out.println(letter + " is a vowel");
                    break;
                default:
                    System.out.println(letter + " is not a vowel");
            }
        }
        
    }
    
}
