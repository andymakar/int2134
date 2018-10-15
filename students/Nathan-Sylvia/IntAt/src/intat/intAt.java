/*
 * Nathan Sylvia 
 * Class: IntAt
 * 10-15-18
*/ 
package intat;
public class intAt {
    public static int intAt(String number, int n) {
        //seperate the character that you want
        char charEnd = number.charAt(n);
        int intEnd = (int) (charEnd - '0');
        return intEnd;
    }
}
