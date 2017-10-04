/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework.pkg4.pkg13;

import java.util.Scanner;
/**
 *
 * Class: Intro to Java
 * Description: user inputs a letter and the program deciphers whether it is a vowel or consonant
 */
public class Homework413 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //Variable and Object Declaration
        char letter;
        Scanner key = new Scanner(System.in);
        
        //Gathers Input
        System.out.print("Enter a letter: ");
        letter = key.next().charAt(0);
        
        //Sorts whether the letter is a variable consonant or an invalid input
        // and outputs the result
        switch (letter)
        {
            case 'a':
            case 'A':
            case 'e':
            case 'E':
            case 'i':
            case 'I':
            case 'o':
            case 'O':
            case 'u':
            case 'U':
                System.out.println(letter + " is a vowel");
                break;
            case 'b':
            case 'B':
            case 'c':
            case 'C':
            case 'd':
            case 'D':
            case 'f':
            case 'F':
            case 'g':
            case 'G':
            case 'h':
            case 'H':
            case 'j':
            case 'J':
            case 'k':
            case 'K':
            case 'l':
            case 'L':
            case 'm':
            case 'M':
            case 'n':
            case 'N':
            case 'p':
            case 'P':
            case 'q':
            case 'Q':
            case 'r':
            case 'R':
            case 's':
            case 'S':
            case 't':
            case 'T':
            case 'v':
            case 'V':
            case 'w':
            case 'W':
            case 'x':
            case 'X':
            case 'y':
            case 'Y':
            case 'z':
            case 'Z':
                System.out.println(letter + " is a consonant");
                break;
            default:
                System.out.println(letter + " is an invalid input");
                break;
        }
    }
    
}