/*
 * TCSS 342 - Winter 2017
 * Assignment 1
 */

package program;

import java.util.Scanner;

import structures.ArrayStack;

/**
 * This class converts positive integers from decimal to binary.
 * 
 * @author Yaro Salo
 * @version 1.1
 */
public final class StackApps {

    /** Message to display to the user. */
    private static final String DISPLAY_MSG = 
                    "Enter a positive integer value to be converted: ";
    
    /** Scanner to be read user input.*/
    private static final Scanner INPUT = new Scanner(System.in);
    
    /**
     * Prevent instantiation. 
     */
    private StackApps() {
       
        //Utility classes should not be instantiated. 
        throw new AssertionError("Utility class instantiation.");    
    }
    
    /** 
     * Staring point of the program.
     * @param theArgs command line parameter (ignored in this application).
     */
    public static void main(final String[] theArgs) {
        
        do {
            
            final int value = validateInteger();
            
            System.out.println(decimalToBinary(value));
            System.out.println("Would you like to convert another number?\n"
                            + "Enter y for yes and anything else for no: ");
            
        } while ("y".equals(INPUT.next()));
        
        System.out.println("exiting...");
        INPUT.close(); 
    }
    
    /**
     * Returns a binary representation of a positive integer as a string.
     * 
     * @param theNumber the number to be converted.
     * @return binary representation of a positive integer.
     * @throws IllegalArgumentException when a non-positive integer is passed in.
     */
    public static String decimalToBinary(final int theNumber) {
        
        //This method only handles positive integers.
        if (theNumber <= 0) {
            
            //should not happen in this application. 
            throw new IllegalArgumentException(); 
        }
        
        int n = theNumber;
        final ArrayStack<Integer> stack = new ArrayStack<>();
        final StringBuilder sb = new StringBuilder();
        int remainder;
        
        while (n > 0) {
         
            remainder = n % 2;
            stack.push(remainder);
            n /= 2;
        }
        
        while (!stack.isEmpty()) {
            
            sb.append(stack.pop());
        }
       
        return sb.toString();
    }

    /**
     * Prompts the user until a positive integer value is entered.
     * 
     * @return positive integer. 
     */
    private static int validateInteger() {
        
        int value;
      
        do {
            
            System.out.print(DISPLAY_MSG);
            
            while (!INPUT.hasNextInt()) {
                
                INPUT.next(); // discard bad input.
                System.out.print(DISPLAY_MSG);
            }
            
            value = INPUT.nextInt();
    
        } while (value <= 0);
        
        return value;  
    }
   
}
