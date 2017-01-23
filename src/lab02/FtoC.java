/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2017
 *
 * Name: Yuxuan Huang
 * Date: 01/22/2017
 *
 * Lab: Lab02, Exercise 2
 *
 * @author Brian King, 2017-Spring
 *
 * Description:
 * A simple program to ask the user for a temperature in F, and converts it to
 * Celsius.
 * *****************************************
 */

package lab02;

import java.util.Scanner;

public class FtoC {
    public static void main(String[] args) {
    	boolean check = true;
    	while(check){
    		check = false;
    		// Prompt user for a Fahrenheit temp
	        System.out.print("Enter a temperature in Fahrenheit: ");

	        // Create the Scanner object, attached to console input
	        Scanner in = new Scanner(System.in);

	        // Read and store the Fahrenheit temp
	        int fahTemp = in.nextInt();

	        // Convert the temp to Celsius
	        float celTemp = (float)5/(float)9*(fahTemp - 32);

	        // Output the results with correct formatting
	        System.out.printf("%d F = %.1f C\n",fahTemp,celTemp);

	        if (celTemp <= 0){
	        	System.out.print("Brrr... it is FREEZING out!\n");
	        } else if (celTemp <= 15){
	        	System.out.print("It's a bit cool out.\n");
	        } else if (celTemp <= 30){
	        	System.out.print("It's comfortably warm.\n");
	        } else {
	        	System.out.print("It's Hot! I need A/C!\n");
	        }
	        System.out.print("Try again? [y | n]: ");
	        String result = in.next();
	        if (result.equals("y") || result.equals("Y")){
	        	check = true;
	        }

    	}
    	System.out.print("Goodbye!\n");

        
    }
}
